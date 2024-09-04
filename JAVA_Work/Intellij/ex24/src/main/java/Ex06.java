import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Ex06 {
    public static void main(String[] args) throws IOException {

        Path fp = Paths.get("d:/a/lines.file");

        List list = Arrays.asList("test", "글입니다");

        Files.write(fp, list, StandardOpenOption.APPEND);

        List<String> readlist = Files.readAllLines(fp);
        System.out.println(readlist);
    }
}
