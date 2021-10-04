import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ContainsDuplicate1 {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                return true;
            }else{
                map.put(i,1);
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[] nums={1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
