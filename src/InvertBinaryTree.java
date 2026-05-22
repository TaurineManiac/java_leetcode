import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                TreeNode temp1=temp.left;
                temp.left=temp.right;
                temp.right=temp1;

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }


//    public TreeNode invertTree(TreeNode root) {
//        if(root==null){
//            return root;
//        }
//
//        TreeNode temp=root.left;
//        root.left=root.right;
//        root.right=temp;
//        invertTree(root.left);
//        invertTree(root.right);
//
//        return root;
//    }

}

class MainOfInvertBinaryTree{
    public static void main(String[] args) {
        InvertBinaryTree obj=new InvertBinaryTree();
        TreeNode.printRootTop(obj.invertTree(TreeNode.deserialize("[4,2,7,1,3,6,9]")));

    }

}
