public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int counter = 1;
        ListNode cur =  head;
        if(head == null || k==0){
            return head;
        }
        while(cur.next != null){
            cur = cur.next;
            counter++;
        }
        cur.next = head;
        cur = head;
        ListNode dummy = head;
        for(int i = 0; i < counter - (k % counter); i++){
            dummy = cur;
            cur = cur.next;
        }
        dummy.next = null;
        return cur;
    }
}

class MainOfRotateList{
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RotateList rl = new RotateList();
        ListNode.printList(rl.rotateRight(head, 2));
    }
}


