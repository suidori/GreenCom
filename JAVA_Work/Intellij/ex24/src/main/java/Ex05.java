import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) throws IOException {

        Path fp = Paths.get("d:/a/b/mytest");

        System.out.println(Files.exists(fp));
        if (!Files.exists(fp)) {
            fp = Files.createFile(fp);
        }

        byte[] buf = {0x15, 0x16, 0x17};
        System.out.println(Arrays.toString(buf));

        Files.write(fp, buf, StandardOpenOption.APPEND);

        byte[] buf2 = Files.readAllBytes(fp);
        System.out.println(Arrays.toString(buf2));
    }
}
