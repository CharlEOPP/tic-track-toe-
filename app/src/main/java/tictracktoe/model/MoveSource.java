package tictracktoe.model;

/** Supplies a human player's next move (console input, a GUI, or a test script). */
@FunctionalInterface
public interface MoveSource {
    Position nextMove(Player player, Board board);
}