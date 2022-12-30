package utility;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class generatedId {
    public long idAdditioner (String path) {
        long count = 0;
        try {

            // Establishing a connection with the file
            Path document  = Paths.get(path);

            // Read the file in its entirety.
            count = Files.lines(document).count();

        }catch(Exception e) {
            e.getStackTrace();

        }
        return count;
    }
}
