import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 12 -> 34 -> 8
        LinkedList ll = new LinkedList();
        ll.prepend(8);
        ll.prepend(34);
        ll.prepend(12);

        ListNode n1 = new ListNode(12);
        ListNode n2 = new ListNode(98);

        n1.next = n2;
        n2.next = n1;

        if (ll.isEmpty()) {
            System.out.println("empty!");
        }

        System.out.println("ll: " + ll.size());
    }
}
