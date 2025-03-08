package model;

import java.util.ArrayList;

public class NonterminalNode extends Node {
    private ArrayList<Node> children;

    public NonterminalNode() {
        children = new ArrayList<Node>();
    }

    public void addChild(Node n) {
        children.add(n);
    }

    public String toString() {
        String output = "{ Node: " + getName() + ", children: ";

        for (Node n : children) {
            output += n.toString();
        }

        return output + " }";
    }
}