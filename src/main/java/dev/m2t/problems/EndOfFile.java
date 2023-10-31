package dev.m2t.problems;

import java.util.Scanner;

class EndOfFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int line = 0;
        while (scan.hasNext()) {
            String data = scan.nextLine();
            line++;
            System.out.println(line + " " + data);
        }
        scan.close();
    }
}