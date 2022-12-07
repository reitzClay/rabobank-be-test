package nl.rabobank.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class RecordValidator
{
    public void validate( String path, String fileType ) throws IOException {

    }

    private List<Record> loadRecordsFromXml(String path, String xml) throws IOException {
        //TODO Read value from xml
        final File initialFile = new File("/Users/claytonreitz/Development/rabobank-be-test/src/test/resources/records.xml");
        final InputStream targetStream = new FileInputStream(initialFile);
        return (List<Record>) initialFile;
    };

    private List<Record> loadRecordsFromCsv(String path, String csv) throws IOException {
        //TODO read from csv
        final File initialFile = new File("/Users/claytonreitz/Development/rabobank-be-test/src/test/resources/records.csv");
        final InputStream targetStream = new FileInputStream(initialFile);
        return (List<Record>) initialFile;
    };

}
