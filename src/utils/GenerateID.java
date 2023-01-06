package utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GenerateID {
    public long idIncrementor(String filepath) throws IOException {
        long count;
        Path file = Paths.get(filepath);
        count = Files.lines(file).count();
        return count;
    }
}