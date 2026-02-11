package rescursion;

//Count the number of binary strings of length N with no consecutive 1s.
public class CountBinaryString {

    /* 1----(n-1) 0----(n-1)
       10---(n-2) 0----(n-1)

       f(n) = f(n-2) + f(n-1)
     */
    public static int countBinaryStrings(int n) {

        if(n==1 || n==0) {
            return n+1;
        }

        return countBinaryStrings(n-2) + countBinaryStrings(n-1);
    }

    static void main() {
        int n = 3;
        int count = countBinaryStrings(n);
        System.out.println("Number of binary strings of length " + n + " with no consecutive 1s: " + count);
    }
}
