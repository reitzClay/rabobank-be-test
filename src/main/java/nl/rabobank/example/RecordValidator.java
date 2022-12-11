package nl.rabobank.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import nl.rabobank.example.model.Record;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ABC Bank Customer Statement Processor
 */
public class RecordValidator {

    public enum Type {
        CSV,
        XML,
        JSON // to be implemented
    }

    /**
     *
     * @param path
     * @param type
     * @return
     * @throws IOException
     */
    public List<Record> validate( String path, Type type ) throws IOException {

        List<Record> records = null;
        switch ( type ) {
            case CSV -> records = loadRecordsFromCsv( path );
            case XML -> records = loadRecordsFromXml( path );
        }

        List<Record> finalRecords = records;
        var nonUniqueRecords = records.stream()
                .filter( r -> isNonUniqueRecord( r, finalRecords ) )
                .collect( Collectors.toList() );

        var nonValidRecords = records.stream()
                .filter( RecordValidator::isNonValidRecord)
                .collect( Collectors.toList());

        var result = new ArrayList<Record>();
        result.addAll( nonUniqueRecords );
        result.addAll( nonValidRecords );

        return result.stream().distinct().collect( Collectors.toList());

    }

    /**
     * O = N2
     * @param a
     * @param records
     * @return
     */
    private static Boolean isNonUniqueRecord( Record a, List<Record> records ) {
        return records.stream().anyMatch( ( b ) -> ( !a.equals( b ) ) && a.getReference() == b.getReference());
    }

    /**
     * O = N
     * @param a
     * @return
     */
    private static Boolean isNonValidRecord( Record a ) {
        return !a.isValid();
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    private List<Record> loadRecordsFromXml( String path ) throws IOException {
        try ( var stream = new FileInputStream( path ) ){
            return new XmlMapper().readValue( stream, new TypeReference<List<Record>>() {} );
        }
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    private List<Record> loadRecordsFromCsv( String path ) throws IOException {

        // Create a mapper
        var mapper = new CsvMapper();

        // The schema
        var schema = mapper
                .typedSchemaFor( Record.class )
                .withHeader()
                .withColumnSeparator(',')
                .withComments();

        // Type iterator
        MappingIterator<Record> iterator = mapper
                .readerWithTypedSchemaFor( Record.class )
                .with( schema )
                .readValues( new File( path ) );

        return iterator.readAll();

    }
}