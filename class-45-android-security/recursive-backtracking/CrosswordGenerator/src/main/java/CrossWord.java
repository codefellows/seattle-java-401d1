import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrossWord {
    private static final char FILLED = '#';
    private static final char EMPTY = ' ';

    private Character[][] grid;
    public Set<Clue> clues;

    // Having trouble with Map<Coord, Set<Clue>> so I'm using strings.
    private Map<String, Counter> contestedLetters;

    public CrossWord(Character[][] grid) {
        this.grid = grid;
        this.clues = this.findStarts();

        contestedLetters = new HashMap<>();

        // explicitly set empty cells to empty.
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid.length; col++) {
                if (this.grid[row][col] != FILLED) {
                   this.grid[row][col] = EMPTY;

                    Coord coord = new Coord(row, col);
                    contestedLetters.put(coord.toString(), new Counter());
                }
            }
        }
    }

    public char getCharAt(int row, int col) {
        if (row < 0 || col < 0 ||
            row >= this.grid.length ||
            col >= this.grid.length) {
            return FILLED;
        }
        return this.grid[row][col];
    }

    public Clue getClueAt(int row, int col) {
        for (Clue clue : this.clues) {
            if (clue.getRow() == row && clue.getCol() == col) {
                return clue;
            }
        }
        return null;
    }

    public Clue getClueByNumber(int number) {
        for (Clue clue : this.clues) {
            if (clue.getNumber() == number) {
                return clue;
            }
        }
        return null;
    }

    public boolean isAcrossStart(int row, int col) {
        // prevent single-letter words
        if (getCharAt(row, col + 1) == FILLED) {
            return false;
        }
        // make sure there wasn't an empty space before
        if (getCharAt(row, col - 1) != FILLED) {
            return false;
        }
        return true;
    }

    public boolean isDownStart(int row, int col) {
        // prevent single-letter words
        if (getCharAt(row + 1, col) == FILLED) {
            return false;
        }
        // make sure there wasn't an empty space before
        if (getCharAt(row - 1, col) != FILLED) {
            return false;
        }
        return true;
    }

    public Set<Clue> findStarts() {
        int clueNumber = 1;
        Set<Clue> clues = new HashSet<>();

        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid.length; col++) {
                boolean isAcross = isAcrossStart(row, col);
                boolean isDown = isDownStart(row, col);
                if (isAcross || isDown) {
                    Clue clue = new Clue(row, col, clueNumber, isAcross, isDown);
                    clues.add(clue);

                    if (isAcross) {
                        int lengthAcross = lengthAcross(row, col);
                        clue.setLengthAcross(lengthAcross);
                    }
                    if (isDown) {
                        int lengthDown = lengthDown(row, col);
                        clue.setLengthDown(lengthDown);
                    }

                    clueNumber++;
                }
            }
        }
        return clues;
    }

    public int lengthAcross(int row, int col) {
        int length = 0;
        char cc = this.getCharAt(row, col);
        while (cc != FILLED) {
            length++;
            col++;
            cc = this.getCharAt(row, col);
        }

        return length;
    }

    public int lengthDown(int row, int col) {
        int length = 0;

        char cc= this.getCharAt(row, col);
        while (cc != FILLED) {
            length++;
            row++;
            cc = this.getCharAt(row, col);
        }

        return length;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid.length; col++) {
                builder.append(this.grid[row][col]);
            }
            builder.append('\n');
        }

        return builder.toString();
    }

    public boolean isSolved() {
        for (Clue clue : this.clues) {
            if (!clue.isSolved()) {
                return false;
            }
        }
        return true;
    }

    public Clue getUnsolvedClue() {
        for (Clue clue : this.clues) {
            if (!clue.isSolved()) {
                return clue;
            }
        }
        return null;
    }

    public boolean attemptClueAcross(Clue clue, String word) {
        int row0 = clue.getRow();
        int col0 = clue.getCol();

        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            char currentChar = this.getCharAt(row0, col0 + i);
            if (currentChar != EMPTY && wordChar != currentChar) {
                return false;
            }
        }

        // write the letters onto the board
        for (int i = 0; i < word.length(); i++) {
            this.grid[row0][col0 + i] = word.charAt(i);

            // register this space with this clue.
            Coord coord = new Coord(row0, col0 + i);
            contestedLetters.get(coord.toString()).increment();
        }

        clue.setAcross(word);
        return true;
    }

    public boolean attemptClueDown(Clue clue, String word) {
        int row0 = clue.getRow();
        int col0 = clue.getCol();

        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            char currentChar = this.getCharAt(row0 + 1, col0);
            if (currentChar != EMPTY && wordChar != currentChar) {
                return false;
            }
        }

        // write the letters onto the board
        for (int i = 0; i < word.length(); i++) {
            this.grid[row0 + i][col0] = word.charAt(i);

            // register this space with this clue.
            Coord coord = new Coord(row0 + i, col0);
            contestedLetters.get(coord.toString()).increment();
        }

        clue.setDown(word);
        return true;
    }

    public void unsetClueAcross(Clue clue) {
        int length = clue.getLengthAcross();
        int row0 = clue.getRow();
        int col0 = clue.getCol();

        for (int i = 0; i < length; i++) {
            // TODO: account for the same clue having two claims for one space
            // because it has both a across and down clue.
            Counter counter = contestedLetters.get(new Coord(row0, col0 + i).toString());
            counter.decrement();

            // only erase the letter if no clue claims ownership of it
            if (counter.value() == 0) {
                this.grid[row0][col0 + i] = EMPTY;
            }
        }

        clue.unsetAcross();
    }

    public void unsetClueDown(Clue clue) {
        int length = clue.getLengthDown();
        int row0 = clue.getRow();
        int col0 = clue.getCol();

        for (int i = 0; i < length; i++) {
            Counter counter = contestedLetters.get(new Coord(row0 + 1, col0).toString());
            counter.decrement();

            // only erase the letter if no clue claims ownership of it
            if (counter.value() == 0) {
                this.grid[row0 + i][col0] = EMPTY;
            }
        }

        clue.unsetDown();
    }
}
