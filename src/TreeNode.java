import java.util.*;

/**
 * TreeNode represents a node in a binary tree.
 * Includes LeetCode-style serialization/deserialization,
 * max depth calculation, and a sideways tree print.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    Boolean visited=false;

    public void setVisited(Boolean visited) {
        this.visited=visited;
    }

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // ------------------------------------------------------------
    // Maximum depth (instance method – uses the current node as root)
    // ------------------------------------------------------------
    public int maxDepth() {
        return maxDepth(this);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    // ------------------------------------------------------------
    // Serialize (static) – converts a tree to LeetCode string
    // ------------------------------------------------------------
    public static String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        String s = sb.toString();
        while (s.endsWith("null,") || s.endsWith(",")) {
            if (s.endsWith("null,")) {
                s = s.substring(0, s.length() - 5);
            } else {
                s = s.substring(0, s.length() - 1);
            }
        }
        s += "]";
        return s;
    }

    // ------------------------------------------------------------
    // Deserialize (static) – builds a tree from a LeetCode string
    // ------------------------------------------------------------
    public static TreeNode deserialize(String data) {
        if (data == null || data.equals("[]") || data.equals("")) return null;
        String[] parts = data.substring(1, data.length() - 1).split(",");
        if (parts.length == 0 || parts[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(parts[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < parts.length) {
            TreeNode node = queue.poll();
            if (index < parts.length) {
                String leftVal = parts[index++].trim();
                if (!leftVal.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(leftVal));
                    queue.offer(node.left);
                }
            }
            if (index < parts.length) {
                String rightVal = parts[index++].trim();
                if (!rightVal.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    // ------------------------------------------------------------
    // Print the tree sideways (right child on top)
    // ------------------------------------------------------------
    public void print() {
        print(this, 0);
    }

    private void print(TreeNode node, int level) {
        if (node == null) return;
        print(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.val);
        print(node.left, level + 1);
    }
}