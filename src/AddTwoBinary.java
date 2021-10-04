import java.util.Arrays;

public class AddTwoBinary {
    public static void main(String args[]){
        int[] A={1,0,1,0};
        int[] B={1,0,1,0};
        String a="1010";
        String b="1010";
        System.out.println(addSameLength(A,B));
        System.out.println(addDiffLength(a,b));
    }
    private static String addSameLength(int[] A,int[] B){
        String result="";
        int sum=0;
        int i=A.length-1;
        while(i>=0 || sum==1){
            sum+= i>=0? A[i]+B[i]:0;
            result=sum%2+result;
            sum=sum/2;
            i--;
        }
        return result;
    }
    private static String addDiffLength(String a,String b){
        String result="";
        int sum=0;
        int i=a.length()-1;
        int j=b.length()-1;
        while(i>=0 || j>=0 || sum==1){
            sum+= i>=0? a.charAt(i)-'0':0;
            sum+= j>=0? b.charAt(j)-'0':0;
            result=(char)(sum % 2 + '0') + result;
            sum=sum/2;
            i--;
            j--;
        }
        return result;
    }
}
