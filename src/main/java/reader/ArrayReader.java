package reader;

import exception.FileException;

import java.util.List;

public interface ArrayReader {
    List<String> readData(String path) throws FileException;
}

