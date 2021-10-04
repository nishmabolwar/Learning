import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageBT {

    public List average(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        while(root!=null)
            queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode t=queue.poll();
                sum+=t.val;
                if(t.left!=null) queue.add(t.left);
                if(t.right!=null) queue.add(t.right);
            }
            res.add((double) sum/size);
        }
        return res;
    }



}
