package tictracktoe.win;
import tictracktoe.model.Board;
import tictracktoe.model.Mark;
import tictracktoe.model.Position;
public class ColumnWinCondition implements WinCondition {
    @Override
    public boolean isSatisfied(Board board, Mark mark) {
        for (int c =0; c < board.size(); c++)
        {
            boolean win =true;
            for (int r = 0; r < board.size(); r++) {
                if (board.getMark(new Position(r, c)) != mark) {
                    win = false;
                    break;}
            }
            if (win) return true;
        }
        return false;
    }

}
