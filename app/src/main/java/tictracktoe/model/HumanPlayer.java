package tictracktoe.model;

public class HumanPlayer implements Player {
    private final String name;
    private final Mark mark;
    private final MoveSource moveSource;

    public HumanPlayer(String name, Mark mark, MoveSource moveSource) {
        if (mark == Mark.EMPTY) {
            throw new IllegalArgumentException("A player must be X or O");
        }
        this.name = name;
        this.mark = mark;
        this.moveSource = moveSource;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    @Override
    public Position chooseMove(Board board) {
        return moveSource.nextMove(this, board);
    }
}
