import java.util.Stack;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode cur;
        for(int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        cur= prev.next;
        for(int i = 0; i < right-left; i++) {
            ListNode forward = cur.next;
            cur.next = forward.next;
            forward.next = prev.next;
            prev.next = forward;
        }
        return dummy.next;
    }
}

class MainOfReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList2 rl = new ReverseLinkedList2();
        ListNode.printList(rl.reverseBetween(head, 2, 4));
    }
}
