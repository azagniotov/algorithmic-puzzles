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
        final Map<Character, Integer> firstCache = new HashMap<>();

        for (char current : firstChars) {
            int count = firstCache.containsKey(current) ? firstCache.get(current) : 0;
            firstCache.put(current, count + 1);
        }

        final char[] secondChars = second.toLowerCase().toCharArray();
        final Map<Character, Integer> secondCache = new HashMap<>();
        for (char current : secondChars) {
            if (!firstCache.containsKey(current)) {
                return false;
            } else {
                int count = secondCache.containsKey(current) ? secondCache.get(current) : 0;
                secondCache.put(current, count + 1);
            }
        }
        return firstCache.equals(secondCache);
    }
}
