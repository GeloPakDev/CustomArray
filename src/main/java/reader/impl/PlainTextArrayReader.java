package reader.impl;

import exception.FileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reader.ArrayReader;
import validator.ArrayValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class PlainTextArrayReader implements ArrayReader {

    private static final String REGEX_SPLITTER = "\\s+";
    private static final Logger LOGGER = LogManager.getLogger(PlainTextArrayReader.class);

    public List<String> readData(String path) throws FileException {
        if (path == null) {
            throw new FileException("File path is null");
        }
        List<String> list;
        ArrayValidator arrayValidator = new ArrayValidator();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            Stream<String> words = stream.flatMap(line -> Stream.of(line.split(REGEX_SPLITTER)));
            LOGGER.info("Reading the data completed");
            list = words
                    .filter(arrayValidator::checkNumberCorrectness)
                    .toList();
            LOGGER.info("Validating the list completed");
        } catch (IOException e) {
            LOGGER.error("File is not found!", e);
            throw new FileException("File is not found!", e);
        }
        LOGGER.info("File successfully read from the file: " + path);
        return list;
    }
}