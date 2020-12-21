package io.github.azagniotov.puzzles.strings;

import static io.github.azagniotov.puzzles.common.Utils.stdout;
import static io.github.azagniotov.puzzles.common.Utils.swapTwo;

/**
 * - The words in the string are unique, i.e.: solution does not eliminate duplicate permutations
 * - The time complexity of this solution is O(n!)
 */
class AllWordsPermutationsTake1 {

    AllWordsPermutationsTake1() {

    }

    // Permutes not in order
    void permuteWords(final String[] words) {
        permuteWords(words, words.length);
    }

    private void permuteWords(final String[] words, final int length) {
        if (length == 1) {
            stdout(words);
        } else {
            for (int idx = 0; idx < length; idx++) {
                swapTwo(words, idx, length - 1);
                permuteWords(words, length - 1);
                swapTwo(words, idx, length - 1);
            }
        }
    }

    public static void main(String[] args) {
        final AllWordsPermutationsTake1 allWordsPermutationsTake1 = new AllWordsPermutationsTake1();

        allWordsPermutationsTake1.permuteWords("hello happy world".split("\\s+"));
    }
}
