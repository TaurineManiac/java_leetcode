import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    //BFS
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(root);
//
//        int res=0;
//        while(!queue.isEmpty()){
//            res++;
//            int queueSize=queue.size();
//
//            for(int i =0;i<queueSize;i++){
//                TreeNode node=queue.poll();
//                if(node.left!=null){
//                    queue.add(node.left);
//                }
//                if(node.right!=null){
//                    queue.add(node.right);
//                }
//            }
//        }
//        return res;
//    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}

class MainOfMaxDepthOfBinaryTree{
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree obj=new MaximumDepthOfBinaryTree();
        obj.maxDepth(TreeNode.deserialize("[0,2,4,1,null,3,-1,5,1,null,6,null,8]"));
    }
}
