package tictracktoe.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tictracktoe.model.Board;
import tictracktoe.model.Mark;
import tictracktoe.model.Position;
import tictracktoe.model.InvalidMoveException;

import static org.junit.jupiter.api.Assertions.*;

public class CommandHistoryTest {
    private Board board;
    private CommandHistory history;

    @BeforeEach
    public void setUp() {
        board = new Board();
        history = new CommandHistory();
    }

    @Test
    public void newHistoryHasNothingForUndo() {
        assertFalse(history.canUndo());
    }

    @Test
    public void executingCommandRunsAndAllowsUndo() {
        Position position = new Position(0,0);
        history.execute(new MoveCommand(board, position, Mark.X));

        assertEquals(Mark.X, board.getMark(position));
        assertTrue(history.canUndo());
    }

    @Test
    public void undoReversesMostRecentMove() {
        Position first = new Position(0,0);
        Position second = new Position(1,1);

        history.execute(new MoveCommand(board, first, Mark.X));
        history.execute(new MoveCommand(board, second, Mark.O));

        history.undo();

        assertTrue(board.isEmpty(second));
        assertEquals(Mark.X, board.getMark(first));
    }

    @Test
    public void undoWithEmptyHistoryThrows() {
        assertThrows(IllegalStateException.class, () -> history.undo());
    }

    @Test
    public void failedCommandNotRecorded() {
        Position position = new Position(0,0);
        history.execute(new MoveCommand(board, position, Mark.X));
        assertThrows(InvalidMoveException.class, () -> history.execute(new MoveCommand(board, position, Mark.O)));

        history.undo();

        assertTrue(board.isEmpty(position));
        assertFalse(history.canUndo());
    }
}
