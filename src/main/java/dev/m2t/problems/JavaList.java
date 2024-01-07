package dev.m2t.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JavaList {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            List<Integer> elements = new ArrayList<>();

            int numberOfElements = Integer.parseInt(bufferedReader.readLine());
            String[] inputElements = bufferedReader.readLine().split("\\s+");
            int numberOfOperations = Integer.parseInt(bufferedReader.readLine());

            // Initialize java List.
            for(String element: inputElements) {
                elements.add(Integer.parseInt(element));
            }

            // Perform operations
            for(int i=0; i<numberOfOperations; i++) {
                String operation = bufferedReader.readLine();
                switch(operation) {
                    case "Insert":
                        String[] insertValues = bufferedReader.readLine().split("\\s+");
                        int indexToInsert = Integer.parseInt(insertValues[0]);
                        int valueToInsert = Integer.parseInt(insertValues[1]);
                        elements.add(indexToInsert, valueToInsert);
                        break;
                    case "Delete":
                        int indexToDelete = Integer.parseInt(bufferedReader.readLine());
                        elements.remove(indexToDelete);
                        break;
                    default:
                        System.out.println("Unknown Operation");
                }
            }

            StringBuilder result = new StringBuilder();
            for(int i=0; i<elements.size(); i++) {
                if(i == elements.size() -1) {
                    result.append(elements.get(i));
                }else {
                    result.append(elements.get(i)).append(" ");
                }
            }

            System.out.println(result);
        } catch(IOException e) {
            System.out.println("IO Exception!" + e);
        }
    }
}