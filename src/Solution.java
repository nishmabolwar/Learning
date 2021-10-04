import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> li=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        helper(li,temp,k,1,n-k+1);
        return li;
    }

    void  helper(List<List<Integer>> li,List<Integer> temp,int k,int start,int end){

        if(temp.size()==k){
            li.add(new ArrayList<>(temp));
            return;
        }else{
            for(int i=start;i<=end;i++){

                temp.add(i);


                helper(li,temp,k,i+1,end+1);

                temp.remove(temp.size()-1);

            }
        }
    }
    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.combine(4,2));
    }
}