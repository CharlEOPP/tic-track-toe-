package tictracktoe.command;

import java.util.ArrayDeque;
import java.util.Deque;

/** Runs commands and undoes them starting with most recent*/
public class CommandHistory {
    private final Deque<Command> executedCommands = new ArrayDeque<>();

    public void execute(Command command) {
        command.execute();
        executedCommands.push(command);
    }

    public boolean canUndo() {
        return !executedCommands.isEmpty();
    }

    public void undo() {
        if(!canUndo()) {
            throw new IllegalStateException("No command to undo");
        }
        executedCommands.pop().undo();
    }
}