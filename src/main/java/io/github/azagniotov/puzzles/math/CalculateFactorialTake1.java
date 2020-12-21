package io.github.azagniotov.puzzles.math;

class CalculateFactorialTake1 {


    CalculateFactorialTake1() {

    }

    int factorial(final int number) {
        if (number == 1) {
            return number;
        } else {
            return number * factorial(number - 1);
        }
    }
}
