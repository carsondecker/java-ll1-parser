package model;

public class TerminalNode extends Node {
    Token token;

    public TerminalNode(Token token) {
        this.token = token;
        setName(token.lexeme);
    }

    public String toString() {
        return "{ Node: " + getName() + " }";
    }
}
