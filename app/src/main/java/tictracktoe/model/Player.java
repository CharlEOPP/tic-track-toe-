package tictracktoe.model;

public interface Player {
    String getName();
    Mark getMark();
    Position chooseMove(Board board);
}
