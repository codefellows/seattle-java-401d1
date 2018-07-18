public class LinkedList {
    public ListNode root;

    public LinkedList() {
        this.root = null;
    }

    // O(1) it always takes the same constant amount of time to prepend to a linked list
    // it doesn't matter how big the list is.
    public void prepend(int value) {
        // make the node, point it to front, then reset front to it.
        ListNode node = new ListNode(value);
        node.next = this.root;
        this.root = node;
    }

    // Insert the newValue before the first occurrence of target.
    // If target occurs multiple times in the list, it will be added
    // in front of only the first time it appears.
    //
    // target: must be any existing value in the list.
    // newValue: a new value to add to the list.
    //
    // [1, 3, 3, 4].insertAfter(3, 2) => [1, 3, 2, 3, 4]
    public void insertAfter(int target, int newValue) {
        ListNode node = new ListNode(newValue);
        ListNode current = this.root;

        // step through the list until we get to a current node
        // that has the target value
        while (current.data != target) {
            current = current.next;
        }

        // now tie the new node into the list
        node.next = current.next;
        current.next = node;
    }

    public void insertBefore(int target, int value) {
        // if the target is at the root of the list
        // then handle the special case that we need to replace
        // explicitly the root and not just attaching it between two
        // nodes in the middle of the list.
        if (this.root.data == target) {
            this.prepend(value);
        }

        ListNode node = new ListNode(value);
        ListNode current = this.root;

        // step through the list until we get to a current node
        // that has the target value
        while (current.next.data != target) {
            current = current.next;
        }

        // now tie the new node into the list
        node.next = current.next;
        current.next = node;
    }

    public String toString() {
        if (this.root == null) {
           return "[]";
        }

        String result = "";
        ListNode current = this.root;

        while (current != null) {
            result += current.data;

            // if there's another node after this one
            // then place a comma and a space
            if (current.next != null) {
                result += ", ";
            }

            current = current.next;
        }

        return "[" + result + "]";
    }

    public int size() {
        int total = 0;

        ListNode current = this.root;
        while (current != null) {
            current = current.next;
            total++;
        }

        return total;
    }

    public int[] toArray() {
        int[] numbers = new int[this.size()];

        int i = 0;
        ListNode current = this.root;
        while (current != null) {
            numbers[i] = current.data;
            i++;
        }

        return numbers;
    }

    public ListNode kthElementFromEnd(int k) {
       return null;
    }
}
