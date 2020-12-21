package io.github.azagniotov.puzzles.bitwise;


class PowerOfThreeTake1 {

    PowerOfThreeTake1() {

    }

    boolean isPowerOfThree1(int number) {
        if (number == 0) {
            return false;
        }

        while (number % 3 == 0) {
            number /= 3;
        }
        return number == 1;
    }
}
