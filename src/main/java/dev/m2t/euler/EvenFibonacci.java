package dev.m2t.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EvenFibonacci {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    long n = Long.parseLong(bufferedReader.readLine().trim());
                    long f1 = 0;
                    long f2 = 2;

                    long sum = 0;

                    while(f2 <= n){
                        sum += f2;

                        // compute next even number in series
                        long f = 4*f2 + f1;

                        // set values for next iteration
                        f1 = f2;
                        f2 = f;
                    }

                    System.out.println(sum);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
    }
}
