package rescursion;

// This is useful how processing works just before recursion or after recursion.
// It is also useful to understand the stack of function calls in recursion.
public class PrintNumbers {

    public static void printNumbersInDecreasing(int n) {
        if(n == 0) {
            return;
        }

        System.out.println(n);
        printNumbersInDecreasing(n - 1);
    }

    public static void printNumbersInIncreasing(int n) {
        if(n == 0) {
            return;
        }

        printNumbersInIncreasing(n - 1);
        System.out.println(n);
    }

    static void main() {
        int n = 10;
        printNumbersInDecreasing(n);
        System.out.println("******");
        printNumbersInIncreasing(n);
    }
}
