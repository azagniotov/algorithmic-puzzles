package io.github.azagniotov.puzzles.math;


class IsPrimeTake1 {


    IsPrimeTake1() {

    }

    boolean isPrime(final int number) {
        final int root = (int) Math.sqrt(number);
        for (int idx = root; idx >= 2; idx--) {
            if (number % idx == 0) {
                return false;
            }
        }
        return true;
    }
}
