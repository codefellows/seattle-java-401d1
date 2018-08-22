package main.java;

import static java.util.Objects.hash;

public class ChessPiece {
    public String rank;
    public String color;

    public ChessPiece(String rank, String color) {
        this.rank = rank;
        this.color = color;
    }

    @Override
    public boolean equals(Object oo) {
        if (!(oo instanceof ChessPiece)) {
            return false;
        }

        ChessPiece piece = (ChessPiece) oo;
        return this.rank.equals(piece.rank) &&
                this.color.equals(piece.color);
    }

    @Override
    public int hashCode() {
        return hash(this.rank, this.color);
    }
}
