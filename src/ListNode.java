public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode deserialize(String str) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

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

            cur.next = new ListNode(sign * num);
            cur = cur.next;
        }

        return dummy.next;
    }
}
