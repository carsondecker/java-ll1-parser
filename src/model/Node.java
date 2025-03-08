package model;

import java.util.ArrayList;
import java.util.List;

import hu.webarticum.treeprinter.TreeNode;
import hu.webarticum.treeprinter.text.PlainConsoleText;

public class Node implements TreeNode {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlainConsoleText content() {
        return new PlainConsoleText(name);
    }

    public List<TreeNode> children() {
        return new ArrayList<>();
    }
}
