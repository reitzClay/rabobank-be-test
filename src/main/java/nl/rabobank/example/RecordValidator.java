package nl.rabobank.example;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class RecordValidator {
    public void validate() throws IOException, ParserConfigurationException, SAXException {
        loadRecordsFromXml();
        loadRecordsFromCsv();
    }

    private void loadRecordsFromXml() throws IOException, ParserConfigurationException, SAXException {
        //Read value from xml
        System.out.println("Hello Xml");
        DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dBfactory.newDocumentBuilder();
        //Fetch Xml file
        Document document = builder.parse(new File("src/test/resources/records.xml"));
        document.getDocumentElement().normalize();
        //Get the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        //Get all students
        NodeList nList = document.getElementsByTagName("record");
        System.out.println(".................................");

        for (int i = 0; i < nList.getLength(); ++i) {
            Node node = nList.item(i);
            System.out.println(); //Just a line seperator
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each client record detail
                Element element = (Element) node;
                System.out.println("record reference: " + element.getAttribute("reference"));
                System.out.println("accountNumber :" + element.getElementsByTagName("accountNumber").item(0).getTextContent());
                System.out.println("description : " + element.getElementsByTagName("description").item(0).getTextContent());
                System.out.println("startBalance : " + element.getElementsByTagName("startBalance").item(0).getTextContent());
                System.out.println("mutation : " + element.getElementsByTagName("mutation").item(0).getTextContent());
                System.out.println("endBalance : " + element.getElementsByTagName("endBalance").item(0).getTextContent());
                System.out.println("date : " + element.getElementsByTagName("date").item(0).getTextContent());
                System.out.println(" ");
            }
        }

    }

    private void loadRecordsFromCsv() {
        //TODO read from csv
        System.out.println(" ");
        System.out.println("Hello Csv");
        System.out.println(".................................");
        try
        {
            List<List<String>> data = new ArrayList<>(); //List of list to store data
            String file = "src/test/resources/records.csv"; //File path
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //Reading until we run out of lines
            String line = br.readLine();
            while (line != null)
            {
                List<String> lineData = Arrays.asList(line.split(",")); //Split the lines
                data.add(lineData);
                line = br.readLine();
            }

            //Print the fetched data
            for (List<String> list : data)
            {
                for (String str: list)
                    System.out.print(str + " ");
                System.out.println();
            }
            br.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
