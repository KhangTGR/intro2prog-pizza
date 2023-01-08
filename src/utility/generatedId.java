package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class generatedId {
    public long idAdditioner(String path) throws IOException {
        long count;
        Path file = Paths.get(path);
        count = Files.lines(file).count();
        return count;
    }
}

