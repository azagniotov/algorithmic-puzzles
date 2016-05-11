package com.zagniotov.puzzles.arrays;

/**
 * Evaluate the value of an arithmetic expression in http://en.wikipedia.org/wiki/Reverse_Polish_notation
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
class EvaluateReversePolishNotationTake1 {

    int evalRPN(String[] tokens) {
        int length = tokens.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return Integer.parseInt(tokens[0]);
        } else {
            int[] stack = new int[length / 2 + 1]; //Only half would be operators
            int lastOffset = -1;
            for (String token : tokens) {
                if (isOperator(token)) {
                    int first = stack[lastOffset - 1];
                    int last = stack[lastOffset];
                    if ("+".equals(token)) {
                        stack[--lastOffset] = first + last;
                    } else if ("-".equals(token)) {
                        stack[--lastOffset] = first - last;
                    } else if ("*".equals(token)) {
                        stack[--lastOffset] = first * last;
                    } else {
                        stack[--lastOffset] = first / last;
                    }
                } else {
                    stack[++lastOffset] = Integer.parseInt(token);
                }
            }
            return stack[0];
        }
    }

    private boolean isOperator(final String token) {
        return token.length() == 1 && "+-/*".indexOf(token.charAt(0)) != -1;
    }
}
