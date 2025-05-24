public class Cell2Player {

    int x, y;

    Shape shape;

    Cell2Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        if(shape == null) {
            return "_";
        }
        return shape.toString();
    }
}
