import creator.CustomArrayCreator;
import exception.CustomArrayException;
import exception.FileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.impl.PlainTextArrayParser;
import reader.impl.PlainTextArrayReader;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

public class CustomArrayCreatorTest {

    PlainTextArrayReader reader;
    PlainTextArrayParser parser;
    CustomArrayCreator creator;
    private static final Logger LOGGER = LogManager.getLogger(CustomArrayCreatorTest.class);
    private static final String PATH = "C:\\Users\\super\\Desktop\\GELO\\Computer Science\\numbers.txt";
    private static final int[] correctArray = {44, 982, 347, 823, 18, 573, 35, 27, 2390, 391, 82, 984, 721, 72, 842, 837, 52, 4959, 93, 850, 8935, 77, 24, 78, 75, 182, 209, 30};


    @BeforeEach
    void setUp() {
        reader = new PlainTextArrayReader();
        parser = new PlainTextArrayParser();
        creator = new CustomArrayCreator();
    }

    @Test
    void createCustomArray() throws FileException, CustomArrayException {
        List<String> list;
        int[] resultArray;
        try {
            try {
                list = reader.readData(PATH);
            } catch (FileException e) {
                LOGGER.error("Unable to read the data!");
                throw new FileException();
            }
            resultArray = parser.parseData(list);
            creator.createCustomArray(resultArray);
        } catch (CustomArrayException e) {
            LOGGER.error("Unable to create an array!");
            throw new CustomArrayException();
        }
        assertArrayEquals(correctArray, resultArray);
    }

    @Test
    void createCustomArrayWithWrongPath() throws FileException, CustomArrayException {
        String wrongPath = "C:\\Users\\super\\Desktop\\GELO\\numbers.txt";
        List<String> list;
        int[] resultArray;
        try {
            try {
                list = reader.readData(wrongPath);
            } catch (FileException e) {
                LOGGER.error("Unable to read the data!");
                throw new FileException("Unable to read the data!");
            }
            resultArray = parser.parseData(list);
            creator.createCustomArray(resultArray);
        } catch (CustomArrayException e) {
            LOGGER.error("Unable to create the data!");
            throw new CustomArrayException();
        }
        assertNotEquals(correctArray, resultArray);
    }
}