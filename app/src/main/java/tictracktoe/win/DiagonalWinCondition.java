package tictracktoe.win;
import tictracktoe.model.Board;
import tictracktoe.model.Mark;
import tictracktoe.model.Position;
public class DiagonalWinCondition implements WinCondition{
    @Override
    public boolean isSatisfied(Board board, Mark mark) {
        boolean mainDiagonalWin = true;
        boolean antiDiagonalWin = true;
        int size =board.size();

        for (int i = 0; i <size; i++)
        {
            if (board.getMark(new Position(i, i)) != mark) {
                mainDiagonalWin = false;
            }
            if (board.getMark(new Position(i, size - 1 - i)) != mark) {
                antiDiagonalWin = false;
            }
        }

        return mainDiagonalWin || antiDiagonalWin;
    }
}
