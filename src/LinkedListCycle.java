import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNodeForLinkedListCycle {
    int val;
    ListNodeForLinkedListCycle next;
    ListNodeForLinkedListCycle(int x) {
        val = x;
    }

    public void setNext(ListNodeForLinkedListCycle next) {
        this.next = next;
    }

    public static ListNodeForLinkedListCycle deserialize(String str) {
        ListNodeForLinkedListCycle dummy = new ListNodeForLinkedListCycle(0);
        ListNodeForLinkedListCycle cur = dummy;

        int i = 1;  // skip opening '['
        while (i < str.length() - 1) {  // stop before closing ']'
            char c = str.charAt(i);

            // Skip commas and whitespace
            if (c == ',' || Character.isWhitespace(c)) {
                i++;
                continue;
            }

            // Read sign
            int sign = 1;
            if (c == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                num = num * 10 + (str.charAt(i) - '0');
                i++;
            }

            cur.next = new ListNodeForLinkedListCycle(sign * num);
            cur = cur.next;
        }

        return dummy.next;
    }
}


public class LinkedListCycle {
    public boolean hasCycle(ListNodeForLinkedListCycle head) {
        ListNodeForLinkedListCycle slow = head;
        ListNodeForLinkedListCycle fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }


}


class MainOfLinkedListCycle {
    public static void main(String[] args) {
        ListNodeForLinkedListCycle.deserialize("[-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5]");
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.hasCycle(ListNodeForLinkedListCycle.deserialize("[-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5]"));
    }
}