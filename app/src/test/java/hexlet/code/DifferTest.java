package hexlet.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DifferTest {

    @Test
    void generateShouldCorrectWorkWihtBothFile() throws IOException {
        String path1 = "./src/test/resources/file1.json";
        String path2 = "./src/test/resources/file2.json";
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
    void generateShouldCorrectWorkWithOneEmptyFile() throws IOException {
        String path1 = "./src/test/resources/file0.json";
        String path2 = "./src/test/resources/file2.json";
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
    void generateShouldCorrectWorkWithSameFile() throws IOException {
        String path1 = "./src/test/resources/file2.json";
        String path2 = "./src/test/resources/file2.json";
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
