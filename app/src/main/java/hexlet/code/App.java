package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {
    @Parameters(description = "path to first file", paramLabel = "filepath1")
    private String filepath1;
    @Parameters(description = "path to second file", paramLabel = "filepath2")
    private String filepath2;
    @Option(names = {"-f", "--format"}, description = "output format [default: ${DEFAULT-VALUE}]", defaultValue = "stylish", paramLabel = "format")
    String format;

    @Override
    public String call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2));
        return Differ.generate(filepath1, filepath2);
    }

    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }
}
