package hexlet.code.formatters;

import java.util.Map;
import java.util.stream.Collectors;

public class Styilishformatter {
    public static String format(Map<String, Map<String, Object>> formatDiffList) {
        StringBuilder result = new StringBuilder("{\n");
        String beginStr = " ";
        String splitter = ": ";
        String resultOsMap = formatDiffList.entrySet().stream()
                .flatMap(es -> es.getValue().entrySet().stream()
                        .map(k -> beginStr.repeat(2) + k.getKey() + es.getKey() + splitter + k.getValue()))
                .collect(Collectors.joining("\n"));
        result.append(resultOsMap);
        result.append("\n}");
        return String.valueOf(result);
    }
}
