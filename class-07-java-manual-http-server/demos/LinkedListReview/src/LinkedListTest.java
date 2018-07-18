import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    public LinkedList empty;
    public LinkedList l1;
    public LinkedList l2;
    public LinkedList l5;
    public LinkedList repeated;

    @BeforeEach
    void setUp() {
        empty = new LinkedList();

        l1 = new LinkedList();
        l1.prepend(12);

        l2 = new LinkedList();
        l2.prepend(14);
        l2.prepend(12);

        // [12, 14, 19, 92, 45]
        l5 = new LinkedList();
        l5.prepend(45);
        l5.prepend(92);
        l5.prepend(19);
        l5.prepend(14);
        l5.prepend(12);

        repeated = new LinkedList();
        repeated.prepend(4);
        repeated.prepend(3);
        repeated.prepend(3);
        repeated.prepend(1);
    }

    @Test
    void toStringEmptyList() {
        assertEquals("[]", empty.toString());
    }

    @Test
    void toStringOneItemList() {
        assertEquals("[12]", l1.toString());
    }

    @Test
    void toStringTwoItemList() {
        assertEquals("[12, 14]", l2.toString());
    }

    @Test
    void toStringFiveItemList() {
        assertEquals("[12, 14, 19, 92, 45]", l5.toString());
    }

    @Test
    void insertAfterOne() {
       l1.insertAfter(12, 2);
       assertEquals("[12, 2]", l1.toString());
    }

    @Test
    void insertAfterDuplicates() {
        repeated.insertAfter(3, 2);
        assertEquals("[1, 3, 2, 3, 4]", repeated.toString());
    }

    @Test
    void insertBeforeOne() {
        l1.insertBefore(12, 2);
        assertEquals("[2, 12]", l1.toString());
    }

    @Test
    void insertBeforeDuplicates() {
        repeated.insertBefore(3, 2);
        assertEquals("[1, 2, 3, 3, 4]", repeated.toString());
    }

    @Test
    void toArrayEmptyList() {
        int[] expected = {};
        assertArrayEquals(expected, empty.toArray());
    }

    @Test
    void toArrayTwoList() {
        int[] expected = {12, 14};
        assertArrayEquals(expected, l2.toArray());


        l1.kthElementFromEnd(2);
    }
}