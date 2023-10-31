package dev.m2t.problems;

import java.util.Scanner;

class Anagrams {

    static boolean isAnagram(String a, String b) {
        String orderedA = orderString(a.toLowerCase());
        String orderedB = orderString(b.toLowerCase());

        if (orderedA.compareTo(orderedB) == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Order a string alphabetically
    private static String orderString(String a) {
        String newString = "";

        while (a.length() > 0) {
            int i = 0;
            String lowestOrdered = a.substring(i, i + 1);
            for (int j = 0; j < a.split("(?!^)").length; j++) {
                if (lowestOrdered.compareTo(a.substring(j, j + 1)) > 0) {
                    lowestOrdered = a.substring(j, j + 1);
                }
            }
            a = a.substring(0, a.indexOf(lowestOrdered)) + a.substring(a.indexOf(lowestOrdered) + 1);
            newString = newString.concat(lowestOrdered);
        }
        return newString;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}