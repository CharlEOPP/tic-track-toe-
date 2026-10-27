package tictracktoe.win;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tictracktoe.model.Board;
import tictracktoe.model.Mark;
import tictracktoe.model.Position;

import static org.junit.jupiter.api.Assertions.*;
public class WinconditionTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void rowWinConditionDetectsWin() {
        WinCondition rowWin = new RowWinCondition();
        board.place(new Position(1, 0), Mark.X);
        board.place(new Position(1, 1), Mark.X);
        board.place(new Position(1, 2), Mark.X);

        assertTrue(rowWin.isSatisfied(board, Mark.X));
        assertFalse(rowWin.isSatisfied(board, Mark.O));
    }

    @Test
    public void columnWinConditionDetectsWin() {
        WinCondition colWin = new ColumnWinCondition();
        board.place(new Position(0, 2), Mark.O);
        board.place(new Position(1, 2), Mark.O);
        board.place(new Position(2, 2), Mark.O);

        assertTrue(colWin.isSatisfied(board, Mark.O));
        assertFalse(colWin.isSatisfied(board, Mark.X));
    }

    @Test
    public void diagonalWinConditionDetectsMainDiagonal() {
        WinCondition diagWin = new DiagonalWinCondition();
        board.place(new Position(0, 0), Mark.X);
        board.place(new Position(1, 1), Mark.X);
        board.place(new Position(2, 2), Mark.X);

        assertTrue(diagWin.isSatisfied(board, Mark.X));
    }

    @Test
    public void diagonalWinConditionDetectsAntiDiagonal() {
        WinCondition diagWin = new DiagonalWinCondition();
        board.place(new Position(0, 2), Mark.O);
        board.place(new Position(1, 1), Mark.O);
        board.place(new Position(2, 0), Mark.O);

        assertTrue(diagWin.isSatisfied(board, Mark.O));
    }

    @Test
    public void winCheckerDetectsAnyWin() {
        WinChecker checker = new WinChecker();
        board.place(new Position(0, 0), Mark.X);
        board.place(new Position(0, 1), Mark.X);
        board.place(new Position(0, 2), Mark.X);

        assertTrue(checker.isWinner(board, Mark.X));
        assertFalse(checker.isWinner(board, Mark.O));
    }

    @Test
    public void winCheckerReturnsFalseForNoWin() {
        WinChecker checker = new WinChecker();
        board.place(new Position(0, 0), Mark.X);
        board.place(new Position(1, 1), Mark.O);
        board.place(new Position(0, 2), Mark.X);

        assertFalse(checker.isWinner(board, Mark.X));
        assertFalse(checker.isWinner(board, Mark.O));
    }

}
