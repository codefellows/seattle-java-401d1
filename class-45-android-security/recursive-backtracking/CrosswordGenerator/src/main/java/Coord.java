public class Coord {
    public int row;
    public int col;

    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Coord fromClue(Clue clue) {
        return new Coord(clue.getRow(), clue.getCol());
    }

    @Override
    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }

    @Override
    public int hashCode() {
       return this.toString().hashCode();
    }
}
