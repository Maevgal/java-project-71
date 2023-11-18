package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Action;

import java.util.Map;

public class JsonFormatter {
    public static String format(Map<String, Map<Action, Object>> formatDiffList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(formatDiffList);
    }
}
