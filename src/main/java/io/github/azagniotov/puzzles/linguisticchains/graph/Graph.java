package io.github.azagniotov.puzzles.linguisticchains.graph;

import io.github.azagniotov.puzzles.common.annotations.VisibleForTesting;
import io.github.azagniotov.puzzles.common.preconditions.Preconditions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static io.github.azagniotov.puzzles.common.Utils.removeCharAt;


public final class Graph {

    private final AtomicInteger longestChainLength;

    private final Map<String, Set<String>> processedChildrenToParents;
    private final Map<Integer, Set<String>> wordsByLength;
    private final Map<Integer, Set<String>> chainsByLength;

    public Graph(final Map<Integer, Set<String>> wordsByLength) {
        Preconditions.checkArgument(wordsByLength != null);

        this.wordsByLength = wordsByLength;
        this.processedChildrenToParents = new HashMap<>();
        this.chainsByLength = new HashMap<>();
        this.longestChainLength = new AtomicInteger(0);
    }

    public List<String> compute() {
        constructTree();
        return new ArrayList<>(chainsByLength.get(longestChainLength.get()));
    }

    @VisibleForTesting
    Node constructTree() {
        final Node root = new Node();
        final List<Integer> allLengths = new ArrayList<>(wordsByLength.keySet());
        for (int idx = wordsByLength.size() - 1; idx >= 0; idx--) {
            final int currentLongestLength = allLengths.get(idx);
            final Set<String> currentLongestWords = this.wordsByLength.get(currentLongestLength);

            for (final String word : currentLongestWords) {
                // If we previously processed the current word as a child of some parent, then
                // there no need to re-process the current word again as a start-word of a new chain.
                // This optimizes the algorithm by avoiding from re-creating shorter chains
                if (processedChildrenToParents.get(word) == null || processedChildrenToParents.get(word).isEmpty()) {
                    final Node child = constructNode(word, new Chain(word));
                    // We are not interested in the top level nodes without children (leafs).
                    // This makes the tree size smaller & prevents single word chains to be created.
                    if (!child.isLeaf()) {
                        root.addChild(child);
                    }
                }
            }
        }
        return root;
    }

    private Node constructNode(final String parentWord, final Chain chain) {
        final Node parent = new Node();

        char previouslyRemovedLetter = '0';
        for (int removeIdx = 0; removeIdx < parentWord.length(); removeIdx++) {
            final char letterToRemove = parentWord.charAt(removeIdx);

            // To avoid duplicated chains:
            // 'boot' -> 'oot', 'bot', 'bot', 'boo': we have 'bot' twice because we removed 'o' twice
            if (previouslyRemovedLetter == letterToRemove) {
                continue;
            }

            previouslyRemovedLetter = letterToRemove;
            final String currentChild = removeCharAt(removeIdx, parentWord);
            final int currentChildLength = currentChild.length();
            if (!wordsByLength.containsKey(currentChildLength)) {
                break;
            }

            if (wordsByLength.get(currentChildLength).contains(currentChild)) {
                if (!processedChildrenToParents.containsKey(currentChild)) {
                    processedChildrenToParents.put(currentChild, new HashSet<String>());
                }
                processedChildrenToParents.get(currentChild).add(parentWord);

                parent.addChild(constructNode(currentChild, chain.duplicate(currentChild)));
            }
        }

        if (parent.isLeaf()) {
            storeLongestWordChain(chain);
        }

        return parent;
    }

    private void storeLongestWordChain(final Chain currentChain) {
        if (currentChain.length() > longestChainLength.intValue()) {
            longestChainLength.set(currentChain.length());
        }

        final int currentLongestChainLength = longestChainLength.intValue();
        if (currentChain.length() >= currentLongestChainLength) {
            if (!chainsByLength.containsKey(currentLongestChainLength)) {
                chainsByLength.put(currentLongestChainLength, new HashSet<String>());
            }
            chainsByLength.get(currentLongestChainLength).add(currentChain.toPrettyString());
        }
    }
}
