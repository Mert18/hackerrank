package dev.m2t.problems;

import java.util.Scanner;
import java.util.Stack;

class JavaStack{

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            System.out.println(isBalanced(input));
        }
    }

    static boolean isBalanced(String parantheses) {
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<parantheses.length(); i++) {
            char c = parantheses.charAt(i);
            if(c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else if(stack.empty()){
                // First character is not an opening paranthesis, so return false.
                return false;
            } else {
                char popped = stack.pop();
                if((popped == '{' && c != '}') ||
                        (popped == '(' && c != ')') ||
                        (popped == '[' && c != ']')) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}

