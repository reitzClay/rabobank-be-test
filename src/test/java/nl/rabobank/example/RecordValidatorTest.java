package nl.rabobank.example;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class RecordValidatorTest
{
    private static final Logger logger = LoggerFactory.getLogger( RecordValidatorTest.class );
    @Test
    public void testValidateXml() throws IOException {
        var result = new RecordValidator().validate("src/test/resources/records.xml", RecordValidator.Type.XML );

        System.out.println( "write assertions" );
        // TODO: Test Assertions...
        //Check that a condition is true
        assert result != null;
        return;
        //Generate report in test
        //Use Logger with nice table
    }

    @Test
    public void testValidateCsv() throws IOException {
        var result = new RecordValidator().validate("src/test/resources/records.csv", RecordValidator.Type.CSV );

        System.out.println( "write assertions" );
        // TODO: Test Assertions...
        assert result != null;
        return;
        //Generate report in test
        //Use Logger with nice table
    }

}
