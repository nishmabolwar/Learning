import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumDisappreadInArray3 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List ret = new ArrayList();
        int[] mark = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            mark[nums[i]] ++;
        }
        for (int j = 1; j < nums.length + 1; j++) {
            if (mark[j] < 1) ret.add(j);
        }
        return ret;
    }
    public static void main(String args[]){
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
