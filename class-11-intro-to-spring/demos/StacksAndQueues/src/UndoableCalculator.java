import java.util.ArrayDeque;
import java.util.Stack;

public class UndoableCalculator {
    private Stack<String> undoStack;
    public int total;

    public static void main(String[] args) {
        UndoableCalculator calc = new UndoableCalculator();
        calc.add(12);
        System.out.println(calc.total);
        calc.subtract(23);
        System.out.println(calc.total);
        calc.add(35);
        System.out.println(calc.total);
        calc.add(45);
        System.out.println(calc.total);
        calc.subtract(34);
        System.out.println(calc.total);
        calc.subtract(83);
        System.out.println(calc.total);
        calc.add(83);
        System.out.println(calc.total);
        calc.add(98);
        System.out.println(calc.total);

        System.out.println();

        calc.undo();
        System.out.println(calc.total);
        calc.undo();
        System.out.println(calc.total);
        calc.undo();
        System.out.println(calc.total);
    }

    public UndoableCalculator() {
        this.undoStack = new Stack<>();
        this.total = 0;
    }

    public void add(int value) {
        this.total += value;
        this.undoStack.push("add " + value);
    }

    public void subtract(int value) {
        this.total -= value;
        this.undoStack.push("sub " + value);
    }

    public void undo() {
        if (this.undoStack.isEmpty()) {
            return;
        }

        String action = this.undoStack.pop();

        String[] cells = action.split(" ");
        action = cells[0];
        int value = Integer.parseInt(cells[1]);

        if (action.startsWith("add")) {
           this.total -= value;
        } else if (action.startsWith("sub")) {
            this.total += value;
        }
    }
}
