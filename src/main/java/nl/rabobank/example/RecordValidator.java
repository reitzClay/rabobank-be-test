package nl.rabobank.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import nl.rabobank.example.model.Record;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;

/**
 * Hello world!
 */
public class RecordValidator {
    public void validate() throws IOException {
        loadRecordsFromXml();
        loadRecordsFromCsv();
    }

    private void loadRecordsFromXml() throws IOException {

        XmlMapper mapper = new XmlMapper();
        File file = new File("src/test/resources/records.xml");
        Record value = mapper.readValue(file, Record.class);
        System.out.println(value.getRecord());
        System.out.println(value.getAccountNumber());
        System.out.println(value.getDate());
        System.out.println(value.getDescription());
        System.out.println(value.getMutation());
        System.out.println(value);
    }

    private void loadRecordsFromCsv() throws IOException {
        //TODO read from csv

    }

}
