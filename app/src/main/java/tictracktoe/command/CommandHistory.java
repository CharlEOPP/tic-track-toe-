package tictracktoe.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {
    private final Deque<Command> executedCommands = new ArrayDeque<>();

    public void execute(Command command) {
        command.execute();
        executedCommands.push(command);
    }

    public Boolean canUndo() {
        return !executedCommands.isEmpty();
    }

    public void undo(){
        if(!canUndo()) {
            throw new IllegalStateException("No command to undo");
        }
        executedCommands.pop().undo();
    }
}


