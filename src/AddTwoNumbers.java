//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order, and each of their nodes contains a single digit.
//Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public class AddTwoNumbers {
    public ListNodeForAddTwoNumbers addTwoNumbers(ListNodeForAddTwoNumbers l1, ListNodeForAddTwoNumbers l2) {
        ListNodeForAddTwoNumbers dummy = new ListNodeForAddTwoNumbers(0, 0);
        ListNodeForAddTwoNumbers current = dummy;
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
            current.next = new ListNodeForAddTwoNumbers(sum % 10, 0);
            current = current.next;
        }

        return dummy.next;
    }
}

class ListNodeForAddTwoNumbers {
    int val;
    ListNodeForAddTwoNumbers next;

    ListNodeForAddTwoNumbers(int x, int i) {
        this.val = x;
    }

    ListNodeForAddTwoNumbers(int val, ListNodeForAddTwoNumbers next) {
        this.val = val;
        this.next = next;
    }

    // Метод который ожидает тестовая система - из строки "[2,4,3]"
    public static ListNodeForAddTwoNumbers deserialize(String data) {
        // Убираем скобки и пробелы
        String clean = data.replace("[", "").replace("]", "").replace(" ", "");
        if (clean.isEmpty()) return null;

        String[] values = clean.split(",");
        ListNodeForAddTwoNumbers dummy = new ListNodeForAddTwoNumbers(0, 0);
        ListNodeForAddTwoNumbers current = dummy;

        for (String value : values) {
            if (!value.isEmpty()) {
                current.next = new ListNodeForAddTwoNumbers(Integer.parseInt(value), 0);
                current = current.next;
            }
        }

        return dummy.next;
    }

    // Метод для сериализации обратно в строку (может понадобиться для вывода)
    public static String serialize(ListNodeForAddTwoNumbers head) {
        StringBuilder sb = new StringBuilder("[");
        ListNodeForAddTwoNumbers current = head;

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


