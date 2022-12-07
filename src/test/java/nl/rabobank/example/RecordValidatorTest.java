package nl.rabobank.example;


import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class RecordValidatorTest
{
    @Test
    public void testValidate() throws IOException {
        var validator = new RecordValidator();
        validator.validate("/Users/claytonreitz/Development/rabobank-be-test/src/test/resources/records.xml","xml");
        return;
    }
    public void loadRecordsFromXml(String path, String file){
        return;
    }

}
