public class RangeSum8 {
    int[] nums_;
    public RangeSum8(int[] nums) {
        this.nums_=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            this.nums_[i]=nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int sum=0;
        for(int i=left;i<=right;i++){
            sum+=nums_[i];
        }
        return sum;
    }
    public static void main(String args[]){
        int[] n=new int[]{-2, 0, 3, -5, 2, -1};
        RangeSum8 RangeSum8=new RangeSum8(n);
        System.out.println(RangeSum8.sumRange(0,2));
    }
}
