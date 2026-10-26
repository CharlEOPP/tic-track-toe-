package tictracktoe.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    public static final int DEFAULT_SIZE = 3;

    private final int size;
    private final Mark[][] cells;

    public Board() {
        this(DEFAULT_SIZE);
    }

    public Board(int size) {
        if (size < DEFAULT_SIZE) {
            throw new IllegalArgumentException("Board size must be at least " + DEFAULT_SIZE);
        }
        this.size = size;
        this.cells = new Mark[size][size];
        for (Mark[] row : cells) {
            Arrays.fill(row, Mark.EMPTY);
        }
    }

    public int size() {
        return size;
    }

    public Mark getMark(Position p) {
        requireInBounds(p);
        return cells[p.row()][p.col()];
    }

    public boolean isEmpty(Position p) {
        return getMark(p) == Mark.EMPTY;
    }

    public void place(Position p, Mark mark) {
        if (mark == Mark.EMPTY) {
            throw new IllegalArgumentException("Use clear() to empty a cell");
        }
        if (!isEmpty(p)) {
            throw new InvalidMoveException("Cell " + p + " is already taken");
        }
        cells[p.row()][p.col()] = mark;
    }

    public void clear(Position p) {
        requireInBounds(p);
        cells[p.row()][p.col()] = Mark.EMPTY;
    }

    public boolean isFull() {
        return emptyPositions().isEmpty();
    }

    public List<Position> emptyPositions() {
        List<Position> empty = new ArrayList<>();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (cells[r][c] == Mark.EMPTY) {
                    empty.add(new Position(r, c));
                }
            }
        }
        return empty;
    }

    private void requireInBounds(Position p) {
        if (p.row() >= size || p.col() >= size) {
            throw new InvalidMoveException("Position " + p + " is off the board");
        }
    }
}
