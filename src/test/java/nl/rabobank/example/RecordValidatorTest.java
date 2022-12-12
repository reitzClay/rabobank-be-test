package nl.rabobank.example;


import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.IOException;

/**
 * Unit test for ABC Bank Customer Statement Processor
 */
public class RecordValidatorTest
{
    private static final Logger logger = LoggerFactory.getLogger(RecordValidatorTest.class);

    public static Logger getLogger() {

        return logger;
    }

    @Test
        public void testValidateXml() throws IOException {
        var result = new RecordValidator().validate("src/test/resources/records.xml", RecordValidator.Type.XML );

        //System.out.println( "Test Assertions..." );
        // TODO: Test Assertions...
        assert result != null;

        System.out.println("----------failed XML records-----------");
        result.stream().map( record -> record.getReference()+ " Desc. : " + record.getDescription())
                .forEach(s -> System.out.println(" Ref# : " + s + " "));
        return;
        //Generate report in test
        //Use Logger with nice table
    }

    @Test
    public void testValidateCsv() throws IOException {
        var result = new RecordValidator().validate("src/test/resources/records.csv", RecordValidator.Type.CSV );

        // TODO: Test Assertions...
        //System.out.println( "write assertions" );
        //Generate report in test
        //Use Logger with nice table
        assert result != null;


        System.out.println("----------failed CSV records-----------");
        result.stream().map( record -> record.getReference()+ "Desc. : " + record.getDescription())
                .forEach(s -> System.out.println("Ref# : " + s + " "));
        return;

    }
}
