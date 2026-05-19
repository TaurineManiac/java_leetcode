public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftTail = left;
        ListNode rightTail = right;

        while(head != null) {
            if(head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            }
            else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
}

class MainOfPartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        PartitionList partitionList = new PartitionList();
        ListNode.printList(partitionList.partition(head, 3));
    }
}
