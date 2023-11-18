package hexlet.code.formatters;

import hexlet.code.Action;

import java.util.Map;

import static hexlet.code.Action.ADDED;
import static hexlet.code.Action.DELETED;
import static hexlet.code.Action.UNCHANGED;

public class StyilishFormatter {
    public static String format(Map<String, Map<Action, Object>> formatDiffList) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map.Entry<String, Map<Action, Object>> diffSet : formatDiffList.entrySet()) {
            Map<Action, Object> diff = diffSet.getValue();
            if (diff.containsKey(ADDED) && diff.containsKey(DELETED)) {
                result.append(addString(diffSet.getKey(), diff, DELETED));
                result.append(addString(diffSet.getKey(), diff, ADDED));
            } else if (diff.containsKey(ADDED)) {
                result.append(addString(diffSet.getKey(), diff, ADDED));
            } else if (diff.containsKey(DELETED)) {
                result.append(addString(diffSet.getKey(), diff, DELETED));
            } else if (diff.containsKey(UNCHANGED)) {
                result.append(addString(diffSet.getKey(), diff, UNCHANGED));
            }
        }
        result.append("}");
        return String.valueOf(result);
    }

    public static String addString(String name, Map<Action, Object> diff, Action action) {
        String beginStr = " ";
        String splitter = ": ";
        StringBuilder result = new StringBuilder();
        String stylishAction = switch (action) {
            case ADDED -> "+ ";
            case DELETED -> "- ";
            case UNCHANGED -> "  ";
        };
        result.append(beginStr.repeat(2))
                .append(stylishAction)
                .append(name)
                .append(splitter)
                .append(diff.get(action))
                .append("\n");
        return result.toString();
    }
}
