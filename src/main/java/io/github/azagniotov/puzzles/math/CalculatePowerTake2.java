package io.github.azagniotov.puzzles.math;

class CalculatePowerTake2 {


    CalculatePowerTake2() {

    }

    double pow(final int number, final int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (number == 1 || exponent == 1) {
            return number;
        } else {
            final double result = number * pow(number, Math.abs(exponent) - 1);
            if (exponent < 0) {
                return 1 / result;
            } else {
                return result;
            }
        }
    }
}
