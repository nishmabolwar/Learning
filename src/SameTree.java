import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public static boolean  isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        Queue<TreeNode> que=new LinkedList<>();
        Queue<TreeNode> li=new LinkedList<>();
        que.add(p);
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                li.add(node);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
        }
        Queue<TreeNode> que2=new LinkedList<>();
        Queue<TreeNode> li2=new LinkedList<>();
        que2.add(q);
        while(!que2.isEmpty()){
            int size=que2.size();
            for(int i=0;i<size;i++){
                TreeNode node=que2.poll();
                li2.add(node);
                if(node.left!=null) que2.add(node.left);
                if(node.right!=null) que2.add(node.right);
            }
        }

        if(li.size()!=li2.size()) return false;
        else{
            for(int i=0;i<li.size();i++){
                if(li.poll().val!=li2.poll().val) return false;
            }
            return true;
        }
    }

    public static void main(String args[]){
        TreeNode p=new TreeNode(1,new TreeNode(2));
        TreeNode q=new TreeNode(1,null,new TreeNode(3));
        if(isSameTree(p,q)) {
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}