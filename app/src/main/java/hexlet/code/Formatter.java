package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StyilishFormatter;

import java.util.Map;

public class Formatter {
    public static String format(
            Map<String, Map<String, Object>> formatDiffList,
            String format
    ) throws JsonProcessingException {
        return switch (format) {
            case "plain" -> PlainFormatter.format(formatDiffList);
            case "json" -> JsonFormatter.format(formatDiffList);
            default -> StyilishFormatter.format(formatDiffList);
        };
    }
}
