package main.java;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ChessPieceTest {
    @Test
    public void testPieceEquality() {
       ChessPiece king = new ChessPiece("king", "black");
       ChessPiece knight = new ChessPiece("knight", "white");

       Set<ChessPiece> set1 = new HashSet<>();
       set1.add(king);

       Set<ChessPiece> set2 = new HashSet<>();
       set2.add(king);
       set2.add(knight);

       Set<ChessPiece> expected = new HashSet<>();
       expected.add(king);

       set1.retainAll(set2);
       assertEquals(expected, set1);
    }

   @Test
   public void testPieceDifferentInstanceEquality() {
      Set<ChessPiece> set1 = new HashSet<>();
      set1.add(new ChessPiece("king", "black"));

      Set<ChessPiece> set2 = new HashSet<>();
      set2.add(new ChessPiece("king", "black"));
      set2.add(new ChessPiece("knight", "white"));

      Set<ChessPiece> expected = new HashSet<>();
      expected.add(new ChessPiece("king", "black"));

      set1.retainAll(set2);
      assertEquals(expected, set1);
   }

   @Test
   public void checkPieceEquality() {
       ChessPiece king1 = new ChessPiece("king", "black");
       ChessPiece king2 = new ChessPiece("king", "black");

       boolean isEqual = king1.equals(king2);
       assertTrue(isEqual);
   }

}