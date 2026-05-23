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


    public static void printRootTop(TreeNode root) {
        if (root == null) {
            System.out.println("(empty tree)");
            return;
        }

        int height = root.maxDepth();               // total rows
        int width = (1 << height) - 1;              // columns needed (2^h - 1)

        String[][] tree = new String[height][width];
        for (String[] row : tree) {
            Arrays.fill(row, " ");
        }

        // Fill node values into the grid
        fillTree(root, 0, 0, width - 1, tree);

        // Print the tree row by row with connection slashes
        for (int r = 0; r < height; r++) {
            // 1) print node values in this row
            for (int c = 0; c < width; c++) {
                System.out.print(tree[r][c]);
            }
            System.out.println();

            // 2) print slashes (unless it's the last row)
            if (r < height - 1) {
                char[] line = new char[width];
                Arrays.fill(line, ' ');
                for (int c = 0; c < width; c++) {
                    if (tree[r][c].matches("\\d+")) {   // a node exists here
                        int mid = c;
                        // find left child in the next row (closest to the left of mid)
                        int leftPos = -1;
                        for (int step = 1; step <= width / (1 << (r + 1)); step++) {
                            if (mid - step >= 0 && tree[r + 1][mid - step].matches("\\d+")) {
                                leftPos = mid - step;
                                break;
                            }
                        }
                        // find right child
                        int rightPos = -1;
                        for (int step = 1; step <= width / (1 << (r + 1)); step++) {
                            if (mid + step < width && tree[r + 1][mid + step].matches("\\d+")) {
                                rightPos = mid + step;
                                break;
                            }
                        }
                        if (leftPos != -1) line[leftPos] = '/';
                        if (rightPos != -1) line[rightPos] = '\\';
                    }
                }
                // print the line with slashes
                for (char ch : line) System.out.print(ch);
                System.out.println();
            }
        }
    }

    // static helper to recursively fill the 2D array
    private static void fillTree(TreeNode node, int row, int left, int right, String[][] tree) {
        if (node == null) return;
        int col = (left + right) / 2;
        tree[row][col] = Integer.toString(node.val);
        fillTree(node.left, row + 1, left, col - 1, tree);
        fillTree(node.right, row + 1, col + 1, right, tree);
    }
}