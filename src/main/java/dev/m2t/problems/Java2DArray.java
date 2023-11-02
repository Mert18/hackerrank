package dev.m2t.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java2DArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int biggestSum = -9999;
        for(int i=0; i<arr.size()-2; i++) {
            for(int y=0; y<4; y++) {
                int sum = arr.get(i).get(y) + arr.get(i).get(y+1) + arr.get(i).get(y+2)
                        + arr.get(i+1).get(y+1)
                        + arr.get(i+2).get(y) + arr.get(i+2).get(y+1) + arr.get(i+2).get(y+2);
                if(sum > biggestSum) {
                    biggestSum = sum;
                }
            }
        }

        System.out.println(biggestSum);

        bufferedReader.close();
    }
}