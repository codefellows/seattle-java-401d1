public class Clue {
    private int row;
    private int col;
    private int number;
    private boolean isAcross;
    private boolean isDown;
    private int lengthAcross;
    private int lengthDown;

    private boolean isAcrossSolved;
    private String answerAcross;

    private boolean isDownSolved;
    private String answerDown;

    public Clue(int row, int col, int number, boolean isAcross, boolean isDown) {
        this.row = row;
        this.col = col;
        this.number = number;
        this.isAcross = isAcross;
        this.isDown = isDown;

        this.lengthAcross = 0;
        this.lengthDown = 0;

        isAcrossSolved = false;
        answerAcross = null;

        isDownSolved = false;
        answerDown = null;
    }

    public boolean isAcross() {
        return this.isAcross;
    }

    public boolean isDown() {
        return this.isDown;
    }

    public int lengthAcross() {
        return this.lengthAcross;
    }

    public int lengthDown() {
        return this.lengthDown;
    }

    public boolean isSolvedAcross() {
        return this.isAcrossSolved;

    }

    public boolean isSolvedDown() {
        return this.isDownSolved;
    }

    @Override
    public boolean equals(Object oo) {
        if (!(oo instanceof Clue)) {
            return false;
        }
        Clue other = (Clue) oo;
        return this.row == other.row &&
                this.col == other.col &&
                this.number == other.number &&
                this.isAcross == other.isAcross &&
                this.isDown == other.isDown;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getNumber() {
        return this.number;
    }

    public void setLengthAcross(int length) {
        this.lengthAcross = length;
    }

    public void setLengthDown(int length) {
        this.lengthDown = length;
    }

    public int getLengthAcross() {
        return this.lengthAcross;
    }

    public int getLengthDown() {
        return this.lengthDown;
    }

    @Override
    public String toString() {
        String format = "#%d (%d,%d) up: %b down: %b";
        return String.format(format, this.number, this.row, this.col, this.isAcross, this.isDown);
    }

    // Override the hashcode to use the toString representation
    // so Set.equals() will compare Sets of Clues properly.
    // If this is not Overrode then it uses Object memory-location equality.
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public void setAcross(String word) {
        this.answerAcross = word;
        this.isAcrossSolved = true;
    }

    public void unsetAcross() {
        this.answerAcross = null;
        this.isAcrossSolved = false;
    }

    public void setDown(String word) {
        this.answerDown = word;
        this.isDownSolved = true;
    }

    public void unsetDown() {
        this.answerDown = null;
        this.isDownSolved = false;
    }

    public boolean isSolved() {
        if (this.isAcross && !this.isAcrossSolved) {
            return false;
        }
        if (this.isDown && !this.isDownSolved) {
            return false;
        }
        return true;
    }
}
