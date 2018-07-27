import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @org.junit.jupiter.api.Test
    void push() {
        IntStack stack = new IntStack();
        stack.push(14);
        stack.push(98);
        stack.push(34);

        System.out.println(stack);

        assertEquals(34, stack.pop());
        assertEquals(98, stack.pop());
        assertEquals(14, stack.pop());

        assertTrue(stack.isEmpty());
        assertTrue(stack.size() == 0);

        System.out.println(stack);

        stack.push(44);
        stack.push(44);
        stack.push(44);
        stack.push(44);

        System.out.println(stack);
    }

    @Test
    public void eleven() {
        IntStack stack = new IntStack();
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println(stack);
        stack.push(10);
        System.out.println(stack);
        stack.push(11);
        System.out.println(stack);
    }

    @Test
    public void castIntoMethod() {
        ObjectStack ss = new ObjectStack();
        ss.push("foo");
    }

    @Test
    public void stringCheese() {
        ObjectStack stack = new ObjectStack();
        stack.push("cheddar");

        String cheese = (String) stack.pop();
        assertEquals("cheddar", cheese);
    }

    @Test
    public void mixedNuts() {
        ObjectStack stack = new ObjectStack();
        stack.push("cheddar");
        stack.push(new Date());
        stack.push(new Scanner(""));
    }

    @Test
    public void generic() {
        Map<String, Integer> mm;

        GenericStack<String> ss = new GenericStack<>();
        GenericStack<Integer> ii = new GenericStack<>();

        ss.push("cheddar");
        ss.push("mozarella");
        String result = ss.pop();

        ii.push(2);
        ii.push(4);
        ii.push(9);
        int iii = ii.pop();
    }
}

























