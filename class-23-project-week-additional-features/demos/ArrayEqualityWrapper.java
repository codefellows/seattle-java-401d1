import java.util.*;

class ArrayEqualityWrapper {
  public int[][] data;

  public static void main(String[] args){
    Set<ArrayEqualityWrapper> set = new HashSet<>();
    int[][] d1 = {{1,2,3},{4,5}};
    int[][] d2 = {{1,2,3},{4,5}};

    ArrayEqualityWrapper wrapped1 = new ArrayEqualityWrapper(d1);
    ArrayEqualityWrapper wrapped2 = new ArrayEqualityWrapper(d2);

    set.add(wrapped1);

    boolean result = set.contains(wrapped2);
    System.out.println("contains? " + result);
  }

  public ArrayEqualityWrapper(int[][] data) {
    this.data = data;
  }

  @Override
  public int hashCode() {
    return Arrays.deepToString(this.data).hashCode();
  }

  // overwrite the default .equals method
  public boolean equals(Object other) {
    ArrayEqualityWrapper casted = (ArrayEqualityWrapper) other;
    return Arrays.deepEquals(this.data, casted.data);
  }
}
