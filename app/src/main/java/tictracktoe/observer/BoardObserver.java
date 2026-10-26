package tictracktoe.observer;

import tictracktoe.model.Board;
import tictracktoe.model.Position;
// Observer pattern: notified when a cell on board changes
public interface BoardObserver {
    void onBoardChanged(Board board, Position changed);
}
