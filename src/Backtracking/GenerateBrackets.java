package Backtracking;

//Given n pairs of brackets, generate all valid parentheses combinations.
// e.g. for n = 3, the output should be ["((()))","(()())","(())()","()(())","()()()"]
public class GenerateBrackets {

    public static int generateBrackets(int n, int c, String s) {

        // c is the count of open brackets that are not closed yet.
        // It should never be negative and it should never be more than n.
        if(c<0 || c > n) {
            return 0;
        }

        // If the length of the string is 2*n, then we have used all the brackets.
        if(s.length() == 2*n) {
            if(c != 0) {
                return 0;
            }
            System.out.println(s);
            return 1;
        }

       int count = 0;
       count += generateBrackets(n, c+1, s+"(");
       count += generateBrackets(n, c-1, s+")");

       return count;
    }

    static void main() {
        int n = 3;
        int count = generateBrackets(n, 0, "");
        System.out.println(count);
    }
}
