public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int p=0;
    int i=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recoursiveBuildTree(preorder, inorder, Integer.MIN_VALUE);
    }

    public TreeNode recoursiveBuildTree(int[] preorder, int[] inorder, int stop) {
        if(preorder.length == p){
            return null;
        }
        if(inorder[i] == stop){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[p++]);
        root.left = recoursiveBuildTree(preorder, inorder, root.val);
        root.right = recoursiveBuildTree(preorder, inorder, stop);

        return root;
    }
}


