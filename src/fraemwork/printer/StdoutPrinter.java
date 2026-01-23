package fraemwork.printer;
import fraemwork.execution.Execution;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StdoutPrinter implements Printer {
    private final String template;

    public StdoutPrinter(String template) {
        this.template = template;
    }

    @Override
    public void write(List<Execution> excecutions) {
        for (var execution : excecutions) {
            System.out.println("Test class " + execution.getClass().getName());
            System.out.println("Start time " + execution.getStartTime().format(DateTimeFormatter.ofPattern(template)));
            System.out.println("End time " + execution.getEndTime().format(DateTimeFormatter.ofPattern(template)));
            System.out.println("\n---------------------------Test---------------------------");
            for (var executionItem : execution.getExecutionItems()) {
                var colorCode = executionItem.getAssertResult().isSuccess() ? ColorCodes.GREEN : ColorCodes.RED;
                System.out.println(colorCode);
                System.out.printf("%-20s |    %s\n", executionItem.getMethod().getName(), executionItem.getAssertResult().toString());
            }
            System.out.print(ColorCodes.RESET);
            System.out.println("\n\n");
        }
    }
}
