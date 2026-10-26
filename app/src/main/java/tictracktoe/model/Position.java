package tictracktoe.model;

public record Position(int row, int col) {
    public Position {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Row and column must be non-negative: " + row + ", " + col);
        }
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
