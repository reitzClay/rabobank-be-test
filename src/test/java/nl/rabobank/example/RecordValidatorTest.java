package nl.rabobank.example;


import org.junit.jupiter.api.Assertions;
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
        result.stream().forEach( r -> logger.info( () -> String.format("ref: %s, desc: '%s'", r.getReference(), r.getDescription() ) ) );
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testValidateCsv() throws IOException {
        var result = new RecordValidator().validate("src/test/resources/records.csv", RecordValidator.Type.CSV );
        result.stream().forEach( r -> logger.info( () -> String.format("ref: %s, desc: '%s'", r.getReference(), r.getDescription() ) ) );
        Assertions.assertEquals(1, result.size());
    }
}
