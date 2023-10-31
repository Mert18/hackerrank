package dev.m2t.problems;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RansomNote {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineWords = new HashMap();
        Map<String, Integer> noteWords = new HashMap();

        for(int i=0; i<magazine.size(); i++) {
            String magazineWord = magazine.get(i);
            if(magazineWords.containsKey(magazineWord)){
                magazineWords.put(magazineWord, magazineWords.get(magazineWord) + 1);
            }else {
                magazineWords.put(magazineWord, 1);
            }
        }

        for(int i=0; i<note.size(); i++) {
            String noteWord = note.get(i);
            if(noteWords.containsKey(noteWord)){
                noteWords.put(noteWord, noteWords.get(noteWord) + 1);
            }else {
                noteWords.put(noteWord, 1);
            }
        }

        for(String key: noteWords.keySet()) {
            if(magazineWords.get(key) == null ||
                    magazineWords.get(key) < noteWords.get(key)) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        List<String> note = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        checkMagazine(magazine, note);

        bufferedReader.close();
    }
}