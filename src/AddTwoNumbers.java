//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order, and each of their nodes contains a single digit.
//Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Метод который ожидает тестовая система - из строки "[2,4,3]"
    public static ListNode deserialize(String data) {
        // Убираем скобки и пробелы
        String clean = data.replace("[", "").replace("]", "").replace(" ", "");
        if (clean.isEmpty()) return null;

        String[] values = clean.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String value : values) {
            if (!value.isEmpty()) {
                current.next = new ListNode(Integer.parseInt(value));
                current = current.next;
            }
        }

        return dummy.next;
    }

    // Метод для сериализации обратно в строку (может понадобиться для вывода)
    public static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        ListNode current = head;

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}


