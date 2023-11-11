package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonFormatter {
    public static String format(Map<String, Map<String, Object>> formatDiffList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(formatDiffList);
    }
}
