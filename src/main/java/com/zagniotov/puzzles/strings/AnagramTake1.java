package com.zagniotov.puzzles.strings;


import java.util.HashMap;
import java.util.Map;

class AnagramTake1 {

    AnagramTake1() {

    }

    boolean isAnagram(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        final char[] firstChars = first.toLowerCase().toCharArray();
        final Map<Character, Integer> firstMap = new HashMap<>();
        for (char ch : firstChars) {
            int count = firstMap.containsKey(ch) ? firstMap.get(ch) : 0;
            firstMap.put(ch, count + 1);
        }

        final char[] secondChars = second.toLowerCase().toCharArray();
        final Map<Character, Integer> secondMap = new HashMap<>();

        for (char ch : secondChars) {
            if (!firstMap.containsKey(ch)) {
                return false;
            } else {
                int count = secondMap.containsKey(ch) ? secondMap.get(ch) : 0;
                secondMap.put(ch, count + 1);
            }
        }

        return firstMap.equals(secondMap);
    }
}
