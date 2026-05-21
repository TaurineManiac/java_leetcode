import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    //BFS
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        Queue<TreeNode> q1=new LinkedList<>();
//        Queue<TreeNode> q2=new LinkedList<>();
//
//        q1.offer(p);
//        q2.offer(q);
//
//        while(!q1.isEmpty() && !q2.isEmpty()){
//
//            TreeNode node1 = q1.poll();
//            TreeNode node2 = q2.poll();
//
//            if(node1==null&&node2==null){
//                continue;
//            }
//            if(node1==null||node2==null || node1.val!=node2.val){
//                return false;
//            }
//
//            q1.offer(node1.left);
//            q2.offer(node2.left);
//            q1.offer(node1.right);
//            q2.offer(node2.right);
//        }
//
//        return q1.isEmpty()&&q2.isEmpty();
//    }

    //DFS

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p == null && q == null;
        }

        if(p.val!=q.val){
            return false;
        }

        return  isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

class MainOfSameTree{
    public static void main(String[] args) {
        TreeNode p= TreeNode.deserialize("[1]");
        TreeNode q= TreeNode.deserialize("[1,null,2]");
        SameTree obj=new SameTree();
        obj.isSameTree(p,q);
    }
}
