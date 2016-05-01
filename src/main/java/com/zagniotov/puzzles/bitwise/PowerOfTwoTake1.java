package com.zagniotov.puzzles.bitwise;


class PowerOfTwoTake1 {

    public PowerOfTwoTake1() {

    }

    boolean isPowerOfTwo(int number) {
        // the operator hierarchy places '-' above '&'
        return (number & number - 1) == 0;
    }
}
