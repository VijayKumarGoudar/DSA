package rescursion;

// a^n
// f{a, n} = when n is even f(a, n/2}^2
//          = when n is odd  a * f(a, n/2)^2
public class PowerOfN {

    public static int findPower(int a, int n) {
        if(n == 1) {
            return a;
        }

        int temp =  findPower(a, n/2);
        int res = temp*temp;
        if(n%2 != 0) {
            res = a*res;
        }

        return res;
    }

    static void main() {
        int n = 5;
        int p = 3;
        int result = findPower(n, p);
        System.out.println(n + " raised to the power of " + p + " is: " + result);
    }
}
