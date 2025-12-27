class ListNodeForRemoveElements {
    int val;
    ListNodeForRemoveElements next;
    ListNodeForRemoveElements() {}
    ListNodeForRemoveElements(int x) { val = x; }
    ListNodeForRemoveElements(int x, ListNodeForRemoveElements next) {
        val = x;
        this.next = next;
    }
    public static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if(head.next != null){
                sb.append(",");
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public static ListNodeForRemoveElements deserialize(String data) {
        ListNodeForRemoveElements dummy = new ListNodeForRemoveElements(0);
        ListNodeForRemoveElements result = dummy;
        data = data.substring(1, data.length() - 1);
        String[] arr = data.split(",");
        for(String s : arr){
            dummy.next = new ListNodeForRemoveElements(Integer.parseInt(s));
            dummy = dummy.next;
        }
        return result.next;
    }
}

public class RemoveNthNodeFromTheEndOfTheList {
    public ListNodeForRemoveElements removeNthFromEnd(ListNodeForRemoveElements head, int n) {
        ListNodeForRemoveElements result = new ListNodeForRemoveElements();
        ListNodeForRemoveElements current = head;
        int counter1 = 1;
        while(current.next != null){
            counter1++;
            current = current.next;
        }
        if(counter1 == n){
            return result.next;
        }
        int counter2 =1;
        while(current.next != null){
            if(counter2 == counter1-n){
                current.next = current.next.next;
                break;
            }
            counter2++;
            current = current.next;
        }
        return result;
    }
}


class SolutionOfRemoveNthFromTheEndOfTheList {
    public static void main(String[] args) {
        RemoveNthNodeFromTheEndOfTheList sol = new RemoveNthNodeFromTheEndOfTheList();
        sol.removeNthFromEnd(ListNodeForRemoveElements.deserialize("[1,2]"), 1);

    }
}