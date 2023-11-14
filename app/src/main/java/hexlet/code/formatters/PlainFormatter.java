package hexlet.code.formatters;

import java.util.Map;

public class PlainFormatter {
    public static String format(Map<String, Map<String, Object>> formatDiffList) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<String, Object>> diff : formatDiffList.entrySet()) {
            if (diff.getValue().containsKey("  ")) {
                continue;
            }
            result.append("Property '");
            result.append(diff.getKey());
            if (diff.getValue().containsKey("+ ") && diff.getValue().containsKey("- ")) {
                result.append("' was updated. From ");
                result.append(resultValue(diff.getValue().get("- ")));
                result.append(" to ");
                result.append(resultValue(diff.getValue().get("+ ")));
                result.append("\n");
            } else if (diff.getValue().containsKey("+ ")) {
                result.append("' was added with value: ");
                result.append(resultValue(diff.getValue().get("+ ")));
                result.append("\n");
            } else if (diff.getValue().containsKey("- ")) {
                result.append("' was removed");
                result.append("\n");
            }
        }
        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    private static String resultValue(Object kv) {
        if (kv == null) {
            return "null";
        }
        if (kv instanceof String) {
            return "'" + kv + "'";
        }
        if (kv instanceof Integer || kv instanceof Boolean) {
            return kv.toString();
        } else {
            return "[complex value]";
        }
    }
}
