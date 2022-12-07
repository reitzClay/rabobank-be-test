package com.claytonReitz.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("/Users/claytonreitz/Development/beTest/src/main/resources/records.xml");
        Records value = xmlMapper.readValue(file, Records.class);
        System.out.println(value);
        // read file and put contents into the string
        Records deserializedData = xmlMapper.readValue(file, Records.class);
        System.out.println("Deserialized data: ");
        System.out.println("\tName: " + deserializedData.getAccountNumber());
        System.out.println("\tName: " + deserializedData.getDescription());
        System.out.println(deserializedData.record);
        System.out.println(file.toString());
        System.out.println(deserializedData.getDate());
        System.out.println(deserializedData);
        System.out.println(deserializedData.record.getBytes());
        System.out.println(deserializedData.record.getBytes().toString());
    }

}
