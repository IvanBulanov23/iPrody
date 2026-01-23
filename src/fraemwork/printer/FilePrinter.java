package fraemwork.printer;

import fraemwork.execution.Execution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class FilePrinter implements Printer {

    private final String template;
    private final Path target;

    public FilePrinter(String template, Path target) {
        this.template = template;
        this.target = target;
    }

    @Override
    public void write(List<Execution> executions) {
        try {
            Files.deleteIfExists(target);
            Files.createFile(target);
            for (var execution : executions) {
                StringBuilder sb = new StringBuilder();
                sb.append("Test class: ").append(execution.getTestClass().getName()).append("\n");
                sb.append("Start time: ").append(execution.getStartTime().format(DateTimeFormatter.ofPattern(template))).append("\n");
                sb.append("End time: ").append(execution.getEndTime().format(DateTimeFormatter.ofPattern(template))).append("\n");
                sb.append("\n---------------------------Test---------------------------\n");

                for (var executionItem : execution.getExecutionItems()) {
                    sb.append(String.format("%-20s | %-5s | %s\n",
                            executionItem.getMethod().getName(),
                            executionItem.getAssertResult().toString(),
                            executionItem.getAssertResult().isSuccess() ? "True" : "False"));
                }
                sb.append("\n\n");
                Files.writeString(target, sb.toString(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
