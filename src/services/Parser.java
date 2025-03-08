package services;

import model.*;

public class Parser {
    Tokenizer tokenizer;
    Token currentToken;
    
    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        currentToken = tokenizer.nextToken();
    }

    public NonterminalNode parse() {
        if (currentToken.type == TokenType.EOF) {
            return null;
        }
        return expr();
    }

    private NonterminalNode expr() {
        NonterminalNode exprNode = new NonterminalNode();
        exprNode.setName("expr");

        exprNode.addChild(term());

        while (currentToken.type == TokenType.ADD || currentToken.type == TokenType.SUB) {
            exprNode.addChild(new TerminalNode(currentToken));
            updateCurrentToken();
            exprNode.addChild(term());
        }

        return exprNode;
    }

    private NonterminalNode term() {
        NonterminalNode termNode = new NonterminalNode();
        termNode.setName("term");

        termNode.addChild(factor());

        while (currentToken.type == TokenType.MUL || currentToken.type == TokenType.DIV) {
            termNode.addChild(new TerminalNode(currentToken));
            updateCurrentToken();
            termNode.addChild(factor());
        }

        return termNode;
    }

    private NonterminalNode factor() {
        NonterminalNode factorNode = new NonterminalNode();
        factorNode.setName("factor");
        
        if (currentToken.type == TokenType.LPAREN) {
            factorNode.addChild(new TerminalNode(currentToken));
            updateCurrentToken();
            factorNode.addChild(expr());
            if (currentToken.type != TokenType.RPAREN) {
                throw new RuntimeException("Parentheses not closed");
            }
            factorNode.addChild(new TerminalNode(currentToken));
            updateCurrentToken();
        } else {
            factorNode.addChild(var());
        }

        return factorNode;
    }

    private NonterminalNode var() {
        NonterminalNode varNode = new NonterminalNode();
        varNode.setName("var");

        if (currentToken.type == TokenType.NUMBER || currentToken.type == TokenType.ID) {
            varNode.addChild(new TerminalNode(currentToken));
            updateCurrentToken();
        } else {
            throw new RuntimeException("Token \"" + currentToken.lexeme + "\" is not a valid variable");
        }

        return varNode;
    }

    private void updateCurrentToken() {
        currentToken = tokenizer.nextToken();
    }
}