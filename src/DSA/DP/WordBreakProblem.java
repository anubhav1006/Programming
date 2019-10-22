package DSA.DP;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

    private static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {

        // array of strings to be added in dictionary set.
        String temp_dictionary[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};

        // loop to add all strings in dictionary set
        for (String temp : temp_dictionary) {
            dictionary.add(temp);
        }

        // sample input cases
        System.out.println(wordBreakDP("ilikesamsung"));
        System.out.println(wordBreakDP("iiiiiiii"));
        System.out.println(wordBreakDP(""));
        System.out.println(wordBreakDP("ilikelikeimangoiii"));
        System.out.println(wordBreakDP("samsungandmango"));
        System.out.println(wordBreakDP("samsungandmangok"));

    }

    private static boolean wordBreak(String str) {

        int len = str.length();
        if (str.length() == 0)
            return true;
        /*if(dictionary.contains(str))
            return true;*/
        for (int i = 1; i <= len; i++) {

            if (dictionary.contains(str.substring(0, i)) && wordBreak(str.substring(i)))
                return true;
        }
        return false;
    }

    private static boolean wordBreakDP(String str) {
        int len = str.length();
        boolean[] dp = new boolean[len + 1];

        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            if (dp[i] == false && dictionary.contains(str.substring(0, i)))
                dp[i] = true;

            if (dp[i]) {
                if (i == len)
                    return true;
                for (int j = i + 1; j <= len; j++) {
                    if (dp[j] == false && dictionary.contains(str.substring(i , j)))
                        dp[j] = true;
                    if (dp[j])
                        if (j == len)
                            return true;
                }
            }
        }
        return dp[len];
    }

}
