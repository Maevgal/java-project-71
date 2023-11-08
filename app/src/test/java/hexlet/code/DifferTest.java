package hexlet.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DifferTest {

    public static final String STYLISH_FORMAT = "stylish";

    @Test
    void generateShouldCorrectWorkWihtBothFileJson() throws IOException {
        String path1 = "./src/test/resources/json/file1.json";
        String path2 = "./src/test/resources/json/file2.json";
        String expected = """
                {
                      chars1: [a, b, c]
                    - chars2: [d, e, f]
                    + chars2: false
                    - checked: false
                    + checked: true
                    - default: null
                    + default: [value1, value2]
                    - id: 45
                    + id: null
                    - key1: value1
                    + key2: value2
                      numbers1: [1, 2, 3, 4]
                    - numbers2: [2, 3, 4, 5]
                    + numbers2: [22, 33, 44, 55]
                    - numbers3: [3, 4, 5]
                    + numbers4: [4, 5, 6]
                    + obj1: {nestedKey=value, isNested=true}
                    - setting1: Some value
                    + setting1: Another value
                    - setting2: 200
                    + setting2: 300
                    - setting3: true
                    + setting3: none
                }""";
        String actual = Differ.generate(path1, path2, STYLISH_FORMAT);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWithOneEmptyFileJson() throws IOException {
        String path1 = "./src/test/resources/json/file0.json";
        String path2 = "./src/test/resources/json/file2.json";
        String expected = """
                {
                    + chars1: [a, b, c]
                    + chars2: false
                    + checked: true
                    + default: [value1, value2]
                    + id: null
                    + key2: value2
                    + numbers1: [1, 2, 3, 4]
                    + numbers2: [22, 33, 44, 55]
                    + numbers4: [4, 5, 6]
                    + obj1: {nestedKey=value, isNested=true}
                    + setting1: Another value
                    + setting2: 300
                    + setting3: none
                }""";
        String actual = Differ.generate(path1, path2, STYLISH_FORMAT);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWithSameFileJson() throws IOException {
        String path1 = "./src/test/resources/json/file2.json";
        String path2 = "./src/test/resources/json/file2.json";
        String expected = """
                {
                      chars1: [a, b, c]
                      chars2: false
                      checked: true
                      default: [value1, value2]
                      id: null
                      key2: value2
                      numbers1: [1, 2, 3, 4]
                      numbers2: [22, 33, 44, 55]
                      numbers4: [4, 5, 6]
                      obj1: {nestedKey=value, isNested=true}
                      setting1: Another value
                      setting2: 300
                      setting3: none
                }""";
        String actual = Differ.generate(path1, path2, STYLISH_FORMAT);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWihtBothFileYml() throws IOException {
        String path1 = "./src/test/resources/yaml/file1.yml";
        String path2 = "./src/test/resources/yaml/file2.yaml";
        String expected = """
                {
                      chars1: [a, b, c]
                    - chars2: [d, e, f]
                    + chars2: false
                    - checked: false
                    + checked: true
                    - default: null
                    + default: [value1, value2]
                    - id: 45
                    + id: null
                    - key1: value1
                    + key2: value2
                      numbers1: [1, 2, 3, 4]
                    - numbers2: [2, 3, 4, 5]
                    + numbers2: [22, 33, 44, 55]
                    - numbers3: [3, 4, 5]
                    + numbers4: [4, 5, 6]
                    + obj1: {nestedKey=value, isNested=true}
                    - setting1: Some value
                    + setting1: Another value
                    - setting2: 200
                    + setting2: 300
                    - setting3: true
                    + setting3: none
                }""";
        String actual = Differ.generate(path1, path2, STYLISH_FORMAT);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWithOneEmptyFileYml() throws IOException {
        String path1 = "./src/test/resources/yaml/file0.yaml";
        String path2 = "./src/test/resources/yaml/file2.yaml";
        String expected = """
                {
                    + chars1: [a, b, c]
                    + chars2: false
                    + checked: true
                    + default: [value1, value2]
                    + id: null
                    + key2: value2
                    + numbers1: [1, 2, 3, 4]
                    + numbers2: [22, 33, 44, 55]
                    + numbers4: [4, 5, 6]
                    + obj1: {nestedKey=value, isNested=true}
                    + setting1: Another value
                    + setting2: 300
                    + setting3: none
                }""";
        String actual = Differ.generate(path1, path2, STYLISH_FORMAT);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWithSameFileYml() throws IOException {
        String path1 = "./src/test/resources/yaml/file2.yaml";
        String path2 = "./src/test/resources/yaml/file2.yaml";
        String expected = """
                {
                      chars1: [a, b, c]
                      chars2: false
                      checked: true
                      default: [value1, value2]
                      id: null
                      key2: value2
                      numbers1: [1, 2, 3, 4]
                      numbers2: [22, 33, 44, 55]
                      numbers4: [4, 5, 6]
                      obj1: {nestedKey=value, isNested=true}
                      setting1: Another value
                      setting2: 300
                      setting3: none
                }""";
        String actual = Differ.generate(path1, path2, STYLISH_FORMAT);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void correctFormatFileForParce() throws IOException {
        String path = "./src/test/resources/uncorrectFormat.jpg";
        String expected = "Формат: jpg не поддеpживается";
        Assertions.assertThatThrownBy(() -> Parser.getFormat(path))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(expected);
    }
}


