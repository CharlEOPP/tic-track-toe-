package tictracktoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void newBoardIsEmptyAndNotFull() {
        assertEquals(9, board.emptyPositions().size());
        assertFalse(board.isFull());
    }

    @Test
    public void placeMarksTheCell() {
        Position center = new Position(1, 1);
        board.place(center, Mark.X);
        assertEquals(Mark.X, board.getMark(center));
    }

    @Test
    public void placingOnOccupiedCellThrows() {
        Position position = new Position(0, 0);
        board.place(position, Mark.X);
        assertThrows(InvalidMoveException.class, () -> board.place(position, Mark.O));
    }

    @Test
    public void placingOffTheBoardThrows() {
        assertThrows(InvalidMoveException.class, () -> board.place(new Position(3, 0), Mark.X));
    }

    @Test
    public void clearRestoresEmptyCell() {
        Position position = new Position(2, 2);
        board.place(position, Mark.O);
        board.clear(position);
        assertTrue(board.isEmpty(position));
    }

    @Test
    public void boardIsFullWhenEveryCellIsMarked() {
        for (Position position : board.emptyPositions()) {
            board.place(position, Mark.X);
        }
        assertTrue(board.isFull());
    }
}
