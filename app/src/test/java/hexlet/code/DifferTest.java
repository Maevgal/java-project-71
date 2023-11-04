package hexlet.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DifferTest {

    @Test
    void generateShouldCorrectWorkWihtBothFileJson() throws IOException {
        String path1 = "./src/test/resources/json/file1.json";
        String path2 = "./src/test/resources/json/file2.json";
        String expected = """
                {
                - follow: false
                  host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true
                }""";
        String actual = Differ.generate(path1, path2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWithOneEmptyFileJson() throws IOException {
        String path1 = "./src/test/resources/json/file0.json";
        String path2 = "./src/test/resources/json/file2.json";
        String expected = """
                {
                + host: hexlet.io
                + timeout: 20
                + verbose: true
                }""";
        String actual = Differ.generate(path1, path2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWithSameFileJson() throws IOException {
        String path1 = "./src/test/resources/json/file2.json";
        String path2 = "./src/test/resources/json/file2.json";
        String expected = """
                {
                  host: hexlet.io
                  timeout: 20
                  verbose: true
                }""";
        String actual = Differ.generate(path1, path2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    @Test
    void generateShouldCorrectWorkWihtBothFileYml() throws IOException {
        String path1 = "./src/test/resources/yaml/file1.yml";
        String path2 = "./src/test/resources/yaml/file2.yaml";
        String expected = """
                {
                - follow: false
                  host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true
                }""";
        String actual = Differ.generate(path1, path2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWithOneEmptyFileYml() throws IOException {
        String path1 = "./src/test/resources/yaml/file0.yaml";
        String path2 = "./src/test/resources/yaml/file2.yaml";
        String expected = """
                {
                + host: hexlet.io
                + timeout: 20
                + verbose: true
                }""";
        String actual = Differ.generate(path1, path2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateShouldCorrectWorkWithSameFileYml() throws IOException {
        String path1 = "./src/test/resources/yaml/file2.yaml";
        String path2 = "./src/test/resources/yaml/file2.yaml";
        String expected = """
                {
                  host: hexlet.io
                  timeout: 20
                  verbose: true
                }""";
        String actual = Differ.generate(path1, path2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
