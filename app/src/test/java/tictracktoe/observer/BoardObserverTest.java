package tictracktoe.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tictracktoe.model.Board;
import tictracktoe.model.InvalidMoveException;
import tictracktoe.model.Mark;
import tictracktoe.model.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BoardObserverTest {
    //Test double that records every notification it receives.
    private static class RecordingObserver implements BoardObserver {
        final List<Position> changes = new ArrayList<>();

        @Override
        public void onBoardChanged(Board board, Position changed) {
            changes.add(changed);
        }
    }

    private Board board;
    private RecordingObserver observer;

    @BeforeEach
    public void setUp() {
        board = new Board();
        observer = new RecordingObserver();
        board.addObserver(observer);
    }

    @Test
    public void observerIsNotifiedWhenMarkIsPlaced() {
        Position position = new Position(1, 1);
        board.place(position, Mark.X);
        assertEquals(List.of(position), observer.changes);
    }

    @Test
    public void observerIsNotifiedWhenCellIsCleared() {
        Position position = new Position(0, 0);
        board.place(position, Mark.O);
        board.clear(position);
        assertEquals(List.of(position, position), observer.changes);
    }

    @Test
    public void everyRegisteredObserverIsNotified() {
        RecordingObserver second = new RecordingObserver();
        board.addObserver(second);

        board.place(new Position(2, 0), Mark.X);

        assertEquals(1, observer.changes.size());
        assertEquals(1, second.changes.size());
    }

    @Test
    public void removedObserverIsNoLongerNotified() {
        board.removeObserver(observer);
        board.place(new Position(0, 1), Mark.X);
        assertTrue(observer.changes.isEmpty());
    }

    @Test
    public void rejectedMoveDoesNotNotify() {
        Position position = new Position(0, 0);
        board.place(position, Mark.X);
        assertThrows(InvalidMoveException.class, () -> board.place(position, Mark.O));
        assertEquals(1, observer.changes.size());
    }
}
