package model;

import java.util.ArrayList;
import java.util.List;

import hu.webarticum.treeprinter.TreeNode;

public class NonterminalNode extends Node {
    private List<TreeNode> children;

    public NonterminalNode() {
        children = new ArrayList<>();
    }

    public void addChild(Node n) {
        children.add(n);
    }

    public List<TreeNode> children() {
        return children;
    }

    public String toString() {
        String output = "{ Node: " + getName() + ", children: ";

        for (TreeNode n : children) {
            output += n.toString();
        }

        return output + " }";
    }
}