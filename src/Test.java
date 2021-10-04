

public class Test{
    public static void main(String[] args) {
        try{
            char[] ch={'a','b','c','d','e','f','g'};

            nextGreatestLetter(ch,'c');
            m1();
        }catch(Myexcep e){
            System.out.println("a");
        }
    }
    public static void m1(){
        try{
          double val=  2.5;
            System.out.println(val);
            throw val> 0.5 ? new Myexcep():new Myexcep();
        }catch(RuntimeException e){
            System.out.println("b");
        }
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length-1;
        while (lo <=hi) {
            int mi = (lo + hi) / 2;
            if (letters[mi] <= target) {lo = mi + 1;}

            else {hi = mi-1;
            }
        }
        System.out.println(lo % letters.length);
        return letters[lo % letters.length];
    }
}
