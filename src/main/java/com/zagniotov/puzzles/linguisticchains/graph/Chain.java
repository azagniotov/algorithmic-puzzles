package com.zagniotov.puzzles.linguisticchains.graph;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Holds the state of a word chain
 */
final class Chain {

    private static final String SEPARATOR = " => ";

    private final AtomicInteger linkCounter;
    private final StringBuilder linkBuilder;

    Chain(final String link) {
        this.linkBuilder = new StringBuilder();
        this.linkCounter = new AtomicInteger(0);
        addLink(link);
    }

    private Chain(final String link, final StringBuilder linkBuilder, final AtomicInteger linkCounter) {
        this.linkBuilder = linkBuilder;
        this.linkCounter = linkCounter;
        addLink(link);
    }

    private void addLink(final String link) {
        this.linkBuilder.append(link).append(SEPARATOR);
        this.linkCounter.incrementAndGet();
    }

    Chain duplicate(final String link) {
        return new Chain(link, new StringBuilder(linkBuilder), new AtomicInteger(linkCounter.intValue()));
    }

    Integer length() {
        return linkCounter.intValue();
    }

    String toPrettyString() {
        this.linkBuilder.delete(this.linkBuilder.toString().lastIndexOf(SEPARATOR), this.linkBuilder.toString().length());
        return linkBuilder.toString();
    }
}
