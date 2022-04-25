import exception.CustomArrayException;
import exception.FileException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.impl.PlainTextArrayParser;
import reader.impl.PlainTextArrayReader;
import service.CustomArrayService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomArrayServiceTest {
    private static final String PATH = "C:\\Users\\super\\Desktop\\GELO\\Files\\numbers.txt";
    PlainTextArrayReader reader;
    PlainTextArrayParser parser;
    CustomArrayService service;


    @BeforeEach
    void setUp() {
        parser = new PlainTextArrayParser();
        reader = new PlainTextArrayReader();
        service = new CustomArrayService();
    }

    @Test
    void findMaxElement() throws FileException, CustomArrayException {
        List<String> list;
        int[] array;
        try {
            list = reader.readData(PATH);
            array = parser.parseData(list);
        } catch (FileException e) {
            throw new FileException("File is not found");
        }
        int result = service.findMaxElement(array);
        assertEquals(454, result);
    }

    @Test
    void findMinElement() throws FileException, CustomArrayException {
        List<String> list;
        int[] array;
        try {
            list = reader.readData(PATH);
            array = parser.parseData(list);
        } catch (FileException e) {
            throw new FileException("File is not found");
        }
        int result = service.findMinElement(array);
        assertEquals(1, result);
    }
}
