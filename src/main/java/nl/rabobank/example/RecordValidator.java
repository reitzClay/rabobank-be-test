package nl.rabobank.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import nl.rabobank.example.model.Record;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Hello world!
 */
public class RecordValidator {
    public void validate(String path) throws IOException {
        var records = loadRecordsFromXml("src/test/resources/records.xml");
        //TODO filter records
    }

    private List<Record> loadRecordsFromXml(String path) throws IOException {
        try ( var stream = new FileInputStream(path)){
            return new XmlMapper().readValue(stream, new TypeReference<List<Record>>() {

            });
        }
    }

    private void loadRecordsFromCsv(String path) throws IOException{

    }
}
