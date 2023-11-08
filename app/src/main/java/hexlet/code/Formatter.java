package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.Styilishformatter;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Map<String, Object>> formatDiffList, String format) {
        return switch (format) {
            case "plain" -> PlainFormatter.format(formatDiffList);
            default -> Styilishformatter.format(formatDiffList);
        };
    }

}
