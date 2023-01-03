package Model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class GenerateID {
    public int generateID(String path) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while(reader.readLine() != null) {
            count++;
        }
        return count;
    }
}