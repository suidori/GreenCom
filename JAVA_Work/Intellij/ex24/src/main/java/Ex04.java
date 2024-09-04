import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex04 {
    public static void main(String[] args) throws Exception {
        Files.createFile(Paths.get("d:/a/b/myfile"));

//        Files.createFile(Paths.get("d:/a/nope/myfile")); -> error

        Files.createDirectory(Paths.get("d:/a/bbb"));
    }
}
