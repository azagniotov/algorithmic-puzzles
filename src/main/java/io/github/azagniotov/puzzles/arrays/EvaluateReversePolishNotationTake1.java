package io.github.azagniotov.puzzles.arrays;

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

    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return Integer.parseInt(tokens[0]);
        } else {
            int[] stack = new int[length / 2 + 1]; //Only half would be operators
            int lastOffset = -1;
            for (final String token : tokens) {
                char firstChar = token.charAt(0);
                if (token.length() == 1 && '-' == firstChar) {
                    stack[--lastOffset] = stack[lastOffset] - stack[lastOffset + 1];
                    continue;
                } else if ('+' == firstChar) {
                    stack[--lastOffset] = stack[lastOffset] + stack[lastOffset + 1];
                    continue;
                } else if ('/' == firstChar) {
                    stack[--lastOffset] = stack[lastOffset] / stack[lastOffset + 1];
                    continue;
                } else if ('*' == firstChar) {
                    stack[--lastOffset] = stack[lastOffset] * stack[lastOffset + 1];
                    continue;
                }
                stack[++lastOffset] = Integer.parseInt(token);
            }
            return stack[0];
        }
    }
}
