package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;

public class Formatter {
    public static String formatStyilish(Map<String, Object> formatDiffList) {
        StringBuilder result = new StringBuilder("{\n");
        String beginStr = " ";
        String splitter = ": ";
        String resultOsMap = formatDiffList.entrySet().stream()
                .map(es -> beginStr.repeat(4) + es.getKey() + splitter + es.getValue())
                .collect(Collectors.joining("\n"));
        result.append(resultOsMap);
        result.append("\n}");
        return String.valueOf(result);
    }
}
