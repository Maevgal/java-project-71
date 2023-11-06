package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String path1, String path2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> pars1 = Parser.parse(path1);
        Map<String, Object> pars2 = Parser.parse(path2);
        return findDiffer(pars1, pars2);
    }

    public static void main(String[] args) throws IOException {
        String path1 = "./src/test/resources/json/file1.json";
        String path2 = "./src/test/resources/json/file2.json";
        System.out.println(generate(path1, path2));
    }

    public static String findDiffer(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object> mapOfResult = new LinkedHashMap<>();
        //List<Map<String, Object>> result = new ArrayList<>();
        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            if (!map1.containsKey(key)) {
                mapOfResult.put("+ " + key, map2.get(key));
            } else if (!map2.containsKey(key)) {
                mapOfResult.put("- " + key, map1.get(key));
            } else if (Objects.equals(map1.get(key), (map2.get(key)))) {
                mapOfResult.put("  " + key, map1.get(key));
            } else {
                mapOfResult.put("- " + key, map1.get(key));
                mapOfResult.put("+ " + key, map2.get(key));
            }
        }
        return Formatter.formatStyilish(mapOfResult);
    }
}
