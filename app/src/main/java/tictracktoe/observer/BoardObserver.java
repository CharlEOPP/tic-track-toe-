package tictracktoe.observer;

import tictracktoe.model.Board;
import tictracktoe.model.Position;

public interface BoardObserver {
    void onBoardChanged(Board board, Position changed);
}
