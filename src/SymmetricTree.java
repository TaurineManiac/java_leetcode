import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
//    public boolean isSymmetric(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root.left);
//        q.offer(root.right);
//
//        while(!q.isEmpty()){
//            TreeNode t1=q.poll();
//            TreeNode t2=q.poll();
//
//            if(t1==null&&t2==null){
//                continue;
//            }
//            if((t1==null||t2==null) || (t1.val!=t2.val)){
//                return false;
//            }
//
//            q.offer(t1.left);
//            q.offer(t2.right);
//            q.offer(t1.right);
//            q.offer(t2.left);
//        }
//        return true;
//    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }
}

class MainOfSymmetricTree {
    public static void main(String[] args) {
        SymmetricTree tree=new SymmetricTree();
        TreeNode root = TreeNode.deserialize("[5,2,2,4,null,null,1,null,1,null,4,2,null,2,null]");
        System.out.println(tree.isSymmetric(root));
        TreeNode.printRootTop(root);
    }
}
