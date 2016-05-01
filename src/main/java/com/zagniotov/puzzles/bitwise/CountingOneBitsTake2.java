package com.zagniotov.puzzles.bitwise;

class CountingOneBitsTake2 {

    CountingOneBitsTake2() {

    }

    int countOneBits1(int subject) {
        int total = 0;
        int mask = 1;
        for (int idx = 0; idx < 32; idx++) {
            if ((subject & mask) != 0) {
                total++;
            }
            mask = mask << 1;
        }
        return total;
    }

    int countOneBits2(int subject) {
        int total = 0;
        while (subject != 0) {
            subject = subject & subject - 1;
            total++;
        }
        return total;
    }
}
