package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String path1, String path2) throws IOException {
        return generate(path1, path2, "stylish");
    }

    public static String generate(String path1, String path2, String format) throws IOException {
        Map<String, Object> pars1 = Parser.parse(getData(path1), getFormat(path1));
        Map<String, Object> pars2 = Parser.parse(getData(path2), getFormat(path2));
        return Formatter.format(findDiffer(pars1, pars2), format);
    }

    public static String getFormat(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }

    public static byte[] getData(String path) throws IOException {
        return Files.readAllBytes(Path.of(path));
    }

    public static Map<String, Map<String, Object>> findDiffer(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Map<String, Object>> mapOfResult = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            if (!map1.containsKey(key)) {
                Map<String, Object> value = new LinkedHashMap<>();
                value.put("+ ", map2.get(key));
                mapOfResult.put(key, value);
            } else if (!map2.containsKey(key)) {
                Map<String, Object> value = new LinkedHashMap<>();
                value.put("- ", map1.get(key));
                mapOfResult.put(key, value);
            } else if (Objects.equals(map1.get(key), (map2.get(key)))) {
                Map<String, Object> value = new LinkedHashMap<>();
                value.put("  ", map1.get(key));
                mapOfResult.put(key, value);
            } else {
                Map<String, Object> value = new LinkedHashMap<>();
                value.put("- ", map1.get(key));
                mapOfResult.put(key, value);
                value.put("+ ", map2.get(key));
                mapOfResult.put(key, value);
            }
        }
        return mapOfResult;
    }
}
