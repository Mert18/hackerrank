package dev.m2t.problems;

import java.util.List;

public class JavaGenerics {

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + "\n");
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = new String[]{"Hello", "World"};

        printArray(intArray);
        printArray(stringArray);

    }
}
