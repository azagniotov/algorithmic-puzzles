package com.zagniotov.puzzles.linguisticchains.common.preconditions;


/**
 * Adopted from Google's Guava library. Static convenience methods that help a method or constructor check whether
 * it was invoked correctly - whether its preconditions have been met.
 */
public final class Preconditions {

    private Preconditions() {

    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param expression a boolean expression
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not
     * involving any parameters to the calling method.
     *
     * @param expression a boolean expression
     * @throws IllegalStateException if {@code expression} is false
     */
    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }
}
