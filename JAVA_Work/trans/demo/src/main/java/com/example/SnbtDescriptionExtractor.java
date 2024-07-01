import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.spacehq.jnbt.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SnbtDescriptionExtractor {

    public static void main(String[] args) {
        // 예시 SNBT 파일 경로 (여기에 실제 SNBT 파일 경로를 입력하세요)
        String snbtFilePath = "path/to/your/snbtfile.snbt";

        try {
            // SNBT 파일을 읽어 String으로 변환
            String snbtString = readFile(snbtFilePath);

            // SNBT 문자열을 NBT 형식으로 변환
            CompoundTag nbtData = (CompoundTag) parseSnbt(snbtString);

            // NBT 데이터를 JSON 문자열로 변환
            Gson gson = new Gson();
            String jsonString = gson.toJson(convertToMap(nbtData));

            // JSON 문자열을 파싱하여 JsonObject로 변환
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

            // "description" 키의 값 추출
            if (jsonObject.has("description")) {
                JsonElement descriptionElement = jsonObject.get("description");
                String description = descriptionElement.getAsString();
                System.out.println("Description: " + description);
            } else {
                System.out.println("The key 'description' was not found in the SNBT data.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) throws IOException {
        try (InputStream is = new FileInputStream(filePath)) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private static Tag parseSnbt(String snbt) throws IOException {
        try (NBTInputStream nbtInputStream = new NBTInputStream(new ByteArrayInputStream(snbt.getBytes(StandardCharsets.UTF_8)))) {
            return nbtInputStream.readTag();
        }
    }

    private static Map<String, Object> convertToMap(CompoundTag compoundTag) {
        Map<String, Tag> tagMap = compoundTag.getValue();
        return tagMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            Tag tag = entry.getValue();
                            if (tag instanceof CompoundTag) {
                                return convertToMap((CompoundTag) tag);
                            } else if (tag instanceof ListTag) {
                                return ((ListTag) tag).getValue().stream()
                                        .map(t -> t instanceof CompoundTag ? convertToMap((CompoundTag) t) : t.getValue())
                                        .collect(Collectors.toList());
                            } else {
                                return tag.getValue();
                            }
                        }
                ));
    }
}
