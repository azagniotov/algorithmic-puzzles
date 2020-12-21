package io.github.azagniotov.puzzles.bitwise;


class NextPowerOfTwoTake1 {

    public NextPowerOfTwoTake1() {

    }

    int nextPowerOfTwo(int number) {
        int nextPowerOfTwo = 1;
        while (nextPowerOfTwo <= number) {
            nextPowerOfTwo = nextPowerOfTwo << 1;
        }
        return nextPowerOfTwo;
    }
}
