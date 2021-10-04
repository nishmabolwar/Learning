public class FindMaxSubArray
{
    public static void main(String args[]){
        int[] input_1={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int[] input={1,-4,3,-4};
        int key=31;
        System.out.println(maxSubArray(input));
    }
    private static int maxSubArray(int[] input){
        int max=input[0];
        int max_final=input[0];
        for(int i=1;i<input.length;i++){
            max=Math.max(input[i],max+input[i]);
            max_final=Math.max(max,max_final);
        }
        return max_final;
    }
}
