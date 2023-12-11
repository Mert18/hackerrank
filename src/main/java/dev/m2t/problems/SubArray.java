package dev.m2t.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class SubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String numberOfItems = reader.readLine();
        String items = reader.readLine();

        // Convert from string input to integer list.
        String[] itemList = items.split("\\s+");
        List<Integer> itemListAsNumber = new ArrayList<>();

        for(String item: itemList) {
            itemListAsNumber.add(Integer.parseInt(item));
        }

        System.out.println(itemListAsNumber);

        int negativeSumCount = 0;
        // Calculate the subarrays
        for(int i=0; i<itemListAsNumber.size(); i++) {
            int y=i;
            while(y < itemListAsNumber.size()) {
                int localSum = 0;
                for(int z=i; z<=y; z++) {
                    localSum += itemListAsNumber.get(z);
                }
                if(localSum < 0) {
                    negativeSumCount++;
                }
                y++;
            }
        }

        System.out.println(negativeSumCount);

    }
}
