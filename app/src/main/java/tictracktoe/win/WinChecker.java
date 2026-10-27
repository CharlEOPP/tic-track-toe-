package tictracktoe.win;

import tictracktoe.model.Board;
import tictracktoe.model.Mark;

import java.util.Arrays;
import java.util.List;

public class WinChecker {
    private final List<WinCondition> conditions;
    public WinChecker() {
        this.conditions = Arrays.asList(
                new RowWinCondition(),
                new ColumnWinCondition(),
                new DiagonalWinCondition()
        );
    }

    public WinChecker(List<WinCondition> conditions) {
        this.conditions = conditions;
    }
    public boolean isWinner(Board board, Mark mark) {
        for (WinCondition condition : conditions) {
            if (condition.isSatisfied(board, mark)) {
                return true;
            }
        }
        return false;
    }

}
