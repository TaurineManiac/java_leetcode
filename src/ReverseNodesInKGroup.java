public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode cur = prev.next;
        while(cur!= null){
            int count = 0;

            ListNode check = cur;
            for(int i = 0; i < k; i++){
                if(check == null){
                    return dummy.next;
                }
                check = check.next;
            }


            while(cur.next!=null && count<k-1){
                ListNode next = cur.next;
                ListNode.printList(dummy.next);
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                count++;

            }
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}

class MainOfReverseKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        ReverseNodesInKGroup r = new ReverseNodesInKGroup();
        ListNode.printList(r.reverseKGroup(head.next, 3));
    }
}
