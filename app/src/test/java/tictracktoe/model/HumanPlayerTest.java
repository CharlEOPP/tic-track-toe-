package tictracktoe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {
    @Test
    void chooseMoveDelegatesToInjectedMoveSource() {
        Position scripted = new Position(0, 2);
        Player player = new HumanPlayer("Charlie", Mark.X, (who, board) -> scripted);

        assertEquals(scripted, player.chooseMove(new Board()));
    }

    @Test
    void playerCannotUseEmptyMark() {
        assertThrows(IllegalArgumentException.class,
                () -> new HumanPlayer("Nobody", Mark.EMPTY, (who, board) -> null));
    }
}