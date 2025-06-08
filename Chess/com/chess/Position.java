package chess;

import java.util.Objects;

public class Position implements Cloneable {
    public int i;
    public int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Position clone() {
        return new Position(this.i, this.j);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return i == position.i && j == position.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}