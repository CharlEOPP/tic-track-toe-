package tictracktoe.command;

/** Command pattern: an action that can be executed/undone */
public interface Command {
    void execute();
    void undo();
}
