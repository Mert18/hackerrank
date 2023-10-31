package dev.m2t.problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MinimumSwaps2 {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int size = arr.length;
        int swapCount = 0;

        Map<Integer, Integer> indexMap = new HashMap<>();

        // Populate the indexMap
        for (int i = 0; i < size; i++) {
            indexMap.put(arr[i], i);
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] != i + 1) {
                // Find the index of the element to swap with using the indexMap
                int swapIndex = indexMap.get(i + 1);

                // Swap the elements
                swap(arr, i, swapIndex);
                swapCount++;

                // Update the indexMap after the swap
                indexMap.put(arr[swapIndex], swapIndex);
                indexMap.put(arr[i], i);
            }
        }
        return swapCount;
    }

    static void swap(int[] arr, int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}