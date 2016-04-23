package com.zagniotov.puzzles.math;

class CalculatePowerTake1 {


    CalculatePowerTake1() {

    }

    double pow(final int number, final int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1 || number == 1) {
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
