import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
            }
            map.put(nums[i],i);
        }

        return result;
    }
    public static void main(String args[]){
        int[] input={2,7,11,15};
        int key=9;
        System.out.println(twoSum(input,key));
    }
}
