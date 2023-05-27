package com.enigma.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Anagram {
    public static void main(String[] args) {
        String[] arr = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        List<List<String>> anagramGroups = new ArrayList<>();
        boolean[] visitedWord = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visitedWord[i]) {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(arr[i]);
            visitedWord[i] = true;

            for (int j = i + 1; j < arr.length; j++) {
                if (visitedWord[j]) {
                    continue;
                }

                if (isAnagram(arr[i], arr[j])) {
                    group.add(arr[j]);
                    visitedWord[j] = true;
                }
            }

            anagramGroups.add(group);
        }

        System.out.println(anagramGroups);
    }

    static boolean isAnagram(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}