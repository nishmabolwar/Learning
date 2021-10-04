public class MissingNum2 {
    public static int missingNumber(int[] nums) {

        int n=nums.length;

        int totalSum= (n*(n+1))/2;
        int sum=0;

        for(int i:nums){
            sum+=i;
        }

        return totalSum-sum;
    }

    public static void main(String args[]){
        int[] nums={0,1,3};
        System.out.println(missingNumber(nums));
    }
}
