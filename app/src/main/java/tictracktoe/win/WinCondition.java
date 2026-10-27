package tictracktoe.win;
import tictracktoe.model.Board;
import tictracktoe.model.Mark;

public interface WinCondition {
    boolean isSatisfied(Board board, Mark mark);
}
