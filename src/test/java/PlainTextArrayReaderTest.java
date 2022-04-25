import exception.FileException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reader.impl.PlainTextArrayReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlainTextArrayReaderTest {
    PlainTextArrayReader reader;
    private static final String PATH = "C:\\Users\\super\\Desktop\\GELO\\Files\\numbers.txt";

    @BeforeEach
    void setUp() {
        reader = new PlainTextArrayReader();
    }

    @Test
    void readDataFromTheFile() throws FileException {
        String[] stringList = {"1", "23", "45", "6", "7", "89", "454", "43", "52"};
        List<String> list;
        try {
            list = reader.readData(PATH);
        } catch (FileException e) {
            throw new FileException();
        }
        assertArrayEquals(stringList, list.toArray());
    }
}