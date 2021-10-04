import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]){
        //int[] input={31, 41, 59, 26, 41, 58,-90};
        int[] input={1,2,3,4,5};
        int key=31;
        sort(input);
        Arrays.stream(input).forEach(i-> System.out.println(i));
    }
    private static void sort(int[] input){
        boolean swap=false;
        for(int j=0;j<input.length;j++) {
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    swap=true;
                }
            }
            if(!swap) break;
        }
    }

}
