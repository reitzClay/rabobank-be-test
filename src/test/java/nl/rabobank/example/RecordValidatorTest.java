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
        validator.validate("src/test/resources/records.xml");
    }
}
