package DynamicProgramming;

import java.util.ArrayList;

/*
Given a numeric string, count how many ways it can be decoded into letters.
 */
public class AlphaCode {

    //create a mapping of numbers to letters
    public  static char getChar(int n) {
        return (char) ('A' + n - 1);
    }

    public static void find(String s, int i, ArrayList<String> res, String tmp) {
        if(i > s.length()-1) {
            res.add(tmp);
            return;
        }

        if( i == s.length()-1) {
            find(s, i+1, res, tmp+getChar(s.charAt(i)-'0'));
        }
        int a = s.charAt(i) - '0';
        if(s.length() > i+1) {
            int b = s.charAt(i+1) - '0';
            if(a*10 + b <= 26) {

                find(s, i+2, res, tmp+getChar(a*10+b));
            }
            if(b != 0) {
                find(s, i+1, res, tmp+getChar(a));
            }
        }
    }

    static void main() {
        String s = "1111111111";
        // s = 1102, 25114
        ArrayList<String> res = new ArrayList<>();

        String tmp = "";
        find(s, 0, res, tmp);

        System.out.println("total number of ways to decode the string: " + res.size());
        res.forEach(System.out::println);

    }
}
