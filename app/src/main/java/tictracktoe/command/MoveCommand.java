package tictracktoe.command;

import tictracktoe.model.Board;
import tictracktoe.model.Mark;
import tictracktoe.model.Position;

/** Concrete command for placing a mark on the board, clearable with undo.*/
public class MoveCommand implements Command {
    private final Board board;
    private final Position position;
    private final Mark mark;

    public MoveCommand(Board board, Position position, Mark mark) {
        this.board = board;
        this.position = position;
        this.mark = mark;
    }

    @Override
    public void execute() {
        board.place(position, mark);
    }

    @Override
    public void undo() {
        board.clear(position);
    }

    public Position getPosition() {
        return position;
    }

    public Mark getMark() {
        return mark;
    }
}
