package Strings;

import java.util.Scanner;

public class ReverseWordString {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while (t > 0) {
            t--;
            String word = in.nextLine();
            String[] words = word.split("\\.");
            for (int i = words.length - 1; i >= 0; i--) {
                System.out.print(words[i] + ".");
            }
            System.out.println("");
        }
    }
}
