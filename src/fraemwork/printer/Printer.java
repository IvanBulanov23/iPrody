package fraemwork.printer;

import fraemwork.execution.Execution;

import java.util.List;

public interface Printer {
    void write(List<Execution> excecutions);
}
