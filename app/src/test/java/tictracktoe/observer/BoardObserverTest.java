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


class BoardObserverTest {
    /** Test double that records every notification it receives. */
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
    void setUp() {
        board = new Board();
        observer = new RecordingObserver();
        board.addObserver(observer);
    }

    @Test
    void observerIsNotifiedWhenMarkIsPlaced() {
        Position p = new Position(1, 1);
        board.place(p, Mark.X);
        assertEquals(List.of(p), observer.changes);
    }

    @Test
    void observerIsNotifiedWhenCellIsCleared() {
        Position p = new Position(0, 0);
        board.place(p, Mark.O);
        board.clear(p);
        assertEquals(List.of(p, p), observer.changes);
    }

    @Test
    void everyRegisteredObserverIsNotified() {
        RecordingObserver second = new RecordingObserver();
        board.addObserver(second);

        board.place(new Position(2, 0), Mark.X);

        assertEquals(1, observer.changes.size());
        assertEquals(1, second.changes.size());
    }

    @Test
    void removedObserverIsNoLongerNotified() {
        board.removeObserver(observer);
        board.place(new Position(0, 1), Mark.X);
        assertTrue(observer.changes.isEmpty());
    }

    @Test
    void rejectedMoveDoesNotNotify() {
        Position p = new Position(0, 0);
        board.place(p, Mark.X);
        assertThrows(InvalidMoveException.class, () -> board.place(p, Mark.O));
        assertEquals(1, observer.changes.size());
    }
}
