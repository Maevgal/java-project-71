package hexlet.code.formatters;

import hexlet.code.Action;

import java.util.Map;

import static hexlet.code.Action.ADDED;
import static hexlet.code.Action.DELETED;
import static hexlet.code.Action.UNCHANGED;

public class PlainFormatter {
    public static String format(Map<String, Map<Action, Object>> formatDiffList) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<Action, Object>> diff : formatDiffList.entrySet()) {
            if (diff.getValue().containsKey(UNCHANGED)) {
                continue;
            }
            result.append("Property '");
            result.append(diff.getKey());
            if (diff.getValue().containsKey(ADDED) && diff.getValue().containsKey(DELETED)) {
                result.append("' was updated. From ")
                        .append(resultValue(diff.getValue().get(DELETED)))
                        .append(" to ")
                        .append(resultValue(diff.getValue().get(ADDED)))
                        .append("\n");
            } else if (diff.getValue().containsKey(ADDED)) {
                result.append("' was added with value: ").append(resultValue(diff.getValue().get(ADDED))).append("\n");
            } else if (diff.getValue().containsKey(DELETED)) {
                result.append("' was removed").append("\n");
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
