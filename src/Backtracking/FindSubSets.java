package Backtracking;

// This is a basic backtracking problem to find all the subsets of a string. It is also known as power set of a string.
// example input: "abc"
// example output: "","a","b","c","ab","ac","bc","abc
public class FindSubSets {

    public static void findSubStrings(String str, int i, String res) {
        if(i == str.length()) {
            System.out.println(res);
            return;
        }

        res+= str.charAt(i);
        findSubStrings(str, i+1, res);
        res = res.substring(0, res.length() - 1);
        findSubStrings(str, i+1, res);
    }

    static void main() {
        String str = "abc";
        findSubStrings(str, 0, "");
    }
}
