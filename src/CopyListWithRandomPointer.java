class Node {
    Node random;
    Node next;
    int data;

    public Node(int data){
        this.random = null;
        this.next = null;
        this.data = data;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. Interleave copies
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node copy = new Node(cur.data);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        // 2. Set random pointers for copies
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3. Separate the lists (with the crucial copy.next fix)
        cur = head;
        Node dummy = new Node(0);
        Node copyTail = dummy;

        while (cur != null) {
            Node copy = cur.next;
            cur.next = copy.next;                           // restore original
            copy.next = (copy.next != null) ? copy.next.next : null; // fix copy's next
            copyTail.next = copy;
            copyTail = copy;
            cur = cur.next;
        }

        return dummy.next;
    }
}


