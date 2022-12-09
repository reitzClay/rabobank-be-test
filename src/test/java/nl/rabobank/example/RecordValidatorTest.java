package nl.rabobank.example;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class RecordValidatorTest
{
    @Test
    public void testValidate() throws IOException, ParserConfigurationException, SAXException {
        var validator = new RecordValidator();
        validator.validate("src/test/resources/records.xml");
    }
}
