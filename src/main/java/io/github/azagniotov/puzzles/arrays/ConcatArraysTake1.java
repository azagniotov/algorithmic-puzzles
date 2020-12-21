package io.github.azagniotov.puzzles.arrays;


class ConcatArraysTake1 {

    ConcatArraysTake1() {

    }

    // Assumes that all three arrays have the same length
    char[] concat1(final char[] first, final char[] second, final char[] third) {
        int length = first.length;
        char[] flattened = new char[length * 3];

        for (int idx = 0; idx < length; idx++) {
            flattened[idx] = first[idx];
            flattened[idx + length] = second[idx];
            flattened[idx + (2 * length)] = third[idx];
        }

        return flattened;
    }

    // Assumes that all three arrays have different length
    char[] concat2(final char[] first, final char[] second, final char[] third) {
        int totalLength = first.length + second.length + third.length;

        char[] flattened = new char[totalLength];

        for (int idx = 0; idx < totalLength; idx++) {
            if (idx < totalLength - (second.length + third.length)) {
                flattened[idx] = first[idx];
            }
            if (idx < totalLength - (first.length + third.length)) {
                flattened[idx + first.length] = second[idx];
            }
            if (idx < totalLength - (first.length + second.length)) {
                flattened[idx + first.length + second.length] = third[idx];
            }
        }

        return flattened;
    }

    public static void main(String[] args) {
        final ConcatArraysTake1 concatArraysTake1 = new ConcatArraysTake1();

        char[] flattened1 = concatArraysTake1.concat1(new char[]{'a', 'b', 'c'}, new char[]{'d', 'e', 'f'}, new char[]{'g', 'i', 'h'});
        System.out.println(flattened1);

        char[] flattened2 = concatArraysTake1.concat2(new char[]{'a', 'b'}, new char[]{'c', 'd', 'e', 'f'}, new char[]{'g'});
        System.out.println(flattened2);
    }// 3,4,2
}
