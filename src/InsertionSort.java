import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]){
       int[] input={31, 41, 59, 26, 41, 58,-90};
        //int[] input={};
        sort(input);
       // System.out.println("asc:"+Arrays.toString(input));
        int[] input_1={31, 41, 59, 26, 41, 58,-90};
        descendingSort(input_1);
       // System.out.println("dec:"+Arrays.toString(input_1));
        System.out.println(getSubtract(-2,-3));

    }

    public static int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }
    private static int[] sort(int[] input){
        for(int j=1;j<input.length;j++){
            //take second element compare it with first
            int key=input[j];
            int i=j-1;
            while(i>=0 && input[i]>key){
                //rearrange the element
                input[i+1]=input[i];
                input[i]=key;
                //reposition the value of i to come out of this loop
                i=i-1;
            }
        }

        return input;
    }

    private static int[] descendingSort(int[] input){
        for(int j=1;j<input.length;j++){
            //take second element compare it with first
            int key=input[j];
            int i=j-1;
            while(i>=0 && input[i]<key){
                //rearrange the element
                input[i+1]=input[i];
                input[i]=key;
                //reposition the value of i to come out of this loop
                i=i-1;
            }
        }

        return input;
    }
}
