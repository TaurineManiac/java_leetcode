import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        ListNode cur = head;
        while(cur!=null && cur.next != null){
            if(cur.val == cur.next.val){
                while(cur.next!=null &&  cur.val == cur.next.val){
                    cur=cur.next;
                }
                prev.next = cur.next;
            }
            else{
                prev = prev.next;
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }
}

class MainOfRemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);
        RemoveDuplicatesFromSortedList2 r = new RemoveDuplicatesFromSortedList2();
        ListNode.printList(r.deleteDuplicates(head));

    }
}
