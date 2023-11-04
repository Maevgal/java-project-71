package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Differ {
    public static String generate(String path1, String path2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> pars1 = Parser.parse(path1);
        Map<String, Object> pars2 = Parser.parse(path2);
        return findDiffer(pars1, pars2);
    }

    public static String findDiffer(Map<String, Object> map1, Map<String, Object> map2) {
        List<String> result = new ArrayList<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            if (!map1.containsKey(key)) {
                result.add("+ " + key + ": " + map2.get(key));
            } else if (!map2.containsKey(key)) {
                result.add("- " + key + ": " + map1.get(key));
            } else if (map1.get(key).equals(map2.get(key))) {
                result.add("  " + key + ": " + map1.get(key));
            } else {
                result.add("- " + key + ": " + map1.get(key));
                result.add("+ " + key + ": " + map2.get(key));
            }
        }
        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n", "{\n", "\n}"));
    }
}
