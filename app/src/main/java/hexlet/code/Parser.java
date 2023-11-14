package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(byte[] content, String format) throws IOException {
        if (content == null || content.length == 0) {
            return Map.of();
        }
        ObjectMapper mapper = new ObjectMapper(getFormat(format));
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
    }

    public static JsonFactory getFormat(String format) {
        return switch (format) {
            case "json" -> new JsonFactory();
            case "yaml", "yml" -> new YAMLFactory();
            default -> throw new RuntimeException("Формат: %s не поддеpживается".formatted(format));
        };
    }
}




