package com.zagniotov.puzzles.bitwise;


class PowerOfFourTake1 {

    public PowerOfFourTake1() {

    }

    /**
     * Power of 2 numbers: 1, 2, 4,  8,  16
     * Power of 4 numbers: 1, 4, 16, 64, 256
     */
    boolean isPowerOfFour1(int number) {
        // the first two conditions are for power of 2
        // the operator hierarchy places '-' above '&'
        return (number & number - 1) == 0 && number > 0 && (number - 1) % 3 == 0;
    }

    /**
     * Power of 2 numbers: 1, 2, 4,  8,  16
     * Power of 4 numbers: 1, 4, 16, 64, 256
     */
    boolean isPowerOfFour2(int number) {
        // the first two conditions are for power of 2
        // the operator hierarchy places '-' above '&'
        // binary representation of 5 is 0101. So 0x55555555 has 16 ones, 16 zeros and the ones,
        // zeros take alternate positions: 01010101010101010101010101010101
        return (number & number - 1) == 0 && number > 0 && (number & 0x55555555) != 0;
    }
}
