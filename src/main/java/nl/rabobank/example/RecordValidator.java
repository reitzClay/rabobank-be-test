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
    public void validate() throws IOException {
        loadRecordsFromXml();
        loadRecordsFromCsv();
    }

    private void loadRecordsFromXml() throws IOException {

        try ( var stream = new FileInputStream(new File("src/test/resources/records.xml")))
        {
           List<Record> records = new XmlMapper().readValue(stream, new TypeReference<List<Record>>() {
               @Override
               public Type getType() {
                   return super.getType();
               }

               @Override
               public int compareTo(TypeReference<List<Record>> o) {
                   return super.compareTo(o);
               }

               @Override
               public int hashCode() {
                   return super.hashCode();
               }

               @Override
               public boolean equals(Object obj) {
                   return super.equals(obj);
               }

               @Override
               protected Object clone() throws CloneNotSupportedException {
                   return super.clone();
               }

               @Override
               public String toString() {
                   return super.toString();
               }

               @Override
               protected void finalize() throws Throwable {
                   super.finalize();
               }
           });
        }
    }

    private void loadRecordsFromCsv() throws IOException {
        //TODO read from csv

    }

}
