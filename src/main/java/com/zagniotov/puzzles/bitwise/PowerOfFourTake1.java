package com.zagniotov.puzzles.bitwise;


public class PowerOfFourTake1 {

    public PowerOfFourTake1() {

    }

    /**
     * Power of 2 numbers: 1, 2, 4,  8,  16
     * Power of 4 numbers: 1, 4, 16, 64, 256
     */
    boolean isPowerOfFour(int number) {
        // the operator hierarchy places '-' above '&'
        return (number & number - 1) == 0 && number > 0 && (number - 1) % 3 == 0;
    }
}
