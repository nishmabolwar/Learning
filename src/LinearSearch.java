import java.util.Arrays;

public class LinearSearch {
    public static void main(String args[]){
       int[] input={31, 41, 59, 26, 41, 58,-90};
       int key=31;
       System.out.println(search(input,key));
    }
    private static int search(int[] input,int key){
        for(int j=0;j<input.length;j++){
             if(input[j]==key){
                 return j;
            }
        }

        return -1;
    }
}
