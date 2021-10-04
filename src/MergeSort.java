import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]){
        int[] input={31, 41, 59, 26, 41, 58,-90};
        mergeSort(input,input.length);
        System.out.println(Arrays.toString(input));
    }
    private static void mergeSort(int[] input,int n){
        //check if the length is greater than two
        //EXIT condition!
       if(n<2)
           return;
       //Initialize the two arrays
       int mid=n/2;
       int[] l=new int[mid];
       int[] r=new int[n-mid];
       for(int i=0;i<mid;i++){
           l[i]=input[i];
       }
        for(int j=mid;j<n;j++){
            r[j-mid]=input[j];
        }
        //call mergeSort recursively to divide the array
        mergeSort(l,mid); //length mid
        mergeSort(r,n-mid); //length n-mid

        merge(l,r,input,mid,n-mid);
    }

    private static void merge(int[] l, int[] r,int[] input,int lLength,int rLength){
        int i=0,j=0, k=0;

        while(i<lLength && j<rLength){
            if(l[i]<=r[j]){
                input[k++]=l[i++];
            }else{
                input[k++]=r[j++];
            }
        }

        while(i<lLength){
            input[k++]=l[i++];
        }
        while(j<rLength){
            input[k++]=r[j++];
        }
    }
}
