public class MaxProfit {
    public static int maxProfit(int[] prices) {
            int max=0;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<prices.length;i++){
                if(prices[i]<min){
                    min=prices[i];
                }else if(prices[i]-min>max){
                    max=prices[i]-min;
                }
            }
            return max;

        }
    public static void main(String args[]){
        int[] nums={1,2};
        System.out.println(maxProfit(nums));
    }
}
