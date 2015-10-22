package linguistic_chains.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Node in a graph
 */
class Node {
    private final List<Node> children;

    Node() {
        this.children = new LinkedList<>();
    }

    void addChild(final Node child) {
        children.add(child);
    }

    List<Node> getChildren() {
        return new LinkedList<>(children);
    }

    boolean isLeaf() {
        return children.isEmpty();
    }
}
