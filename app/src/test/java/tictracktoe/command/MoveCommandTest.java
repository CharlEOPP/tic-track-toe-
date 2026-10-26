package tictracktoe.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tictracktoe.model.Board;
import tictracktoe.model.Mark;
import tictracktoe.model.Position;

import static org.junit.jupiter.api.Assertions.*;

public class MoveCommandTest {
    private Board board;
    private final Position center = new Position(1,1);

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void executePlacesTheMark() {
        new MoveCommand(board, center, Mark.X).execute();
        assertEquals(Mark.X, board.getMark(center));
    }

    @Test
    public void undoClearsTheCell() {
        Command move = new MoveCommand(board, center, Mark.O);
        move.execute();
        move.undo();
        assertTrue(board.isEmpty(center));
    }

}
