package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String path) throws IOException {
        if (Files.size(Path.of(path)) == 0) {
            return Map.of();
        }
        ObjectMapper mapper = new ObjectMapper(getFormat(path));
        return mapper.readValue(new File(path), new TypeReference<Map<String, Object>>() {
        });
    }

    public static JsonFactory getFormat(String path) {
        Object format = path.substring(path.lastIndexOf(".") + 1);
        if (format.equals("json")) {
            return new JsonFactory();
        } else if (format.equals("yaml") || format.equals("yml")) {
            return new YAMLFactory();
        }
        throw new RuntimeException("Формат: %s не поддеоживается".formatted(format));
    }
}
