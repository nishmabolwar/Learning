import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class longestNonReapSub {
    public static int lengthOfLongestSubstring(String s) {
        try(FileOutputStream fos = new FileOutputStream("movies.txt");

            DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeUTF("Java 7 Block Buster");

        } catch(IOException e) {

            // log the exception
Predicate<Integer> p= i->i>10;
            System.out.println(p.test(10));
            Function<Integer,Integer> y= i->{
                System.out.println("hello");
                if(i>10)
                    return 10;
                return i;
            };
            System.out.println(y.apply(10));
            System.out.println(p.test(10));

        }
        if(s==null || s.length()==0) return 0;

        HashMap<Character,Integer> map=new HashMap<>();
        int start=0,max=0;
        for(int end=0;end<s.length();end++){
            if(map.containsKey(s.charAt(end))){
                // start=Math.max(start,map.get(s.charAt(end)));
                start=map.get(s.charAt(end));
                System.out.println(s.charAt(end));
                System.out.println("start:"+start);
                System.out.println("end:"+end);
            }
            max=Math.max(end-start+1,max);
            map.put(s.charAt(end),end+1);
        }
        return max;
    }
    public static void main(String[] args) {
        throw new ArithmeticException("dfdsf");
      //  lengthOfLongestSubstring("abba");
       // List<Integer> l=new ArrayList<>();

      //  l.forEach(i-> System.out.println("longestNonReapSub.main"));
    }


}
