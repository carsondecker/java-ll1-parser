package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.*;

public class Tokenizer {
    private String input;
    private int pos;
    private Pattern numPattern;
    private Pattern idPattern;

    public Tokenizer(String input) {
        this.input = input;
        pos = 0;
        numPattern = Pattern.compile("\\d+");
        idPattern = Pattern.compile("[a-zA-Z][a-zA-Z\\d]*");
    }

    public Token nextToken() {
        if (pos >= input.length()) {
            return new Token(TokenType.EOF, "");
        }

        Matcher numMatcher = numPattern.matcher(input.substring(pos));
        if (numMatcher.lookingAt()) {
            String num = numMatcher.group();
            pos += num.length();
            return new Token(TokenType.NUMBER, num);
        }

        Matcher idMatcher = idPattern.matcher(input.substring(pos));
        if (idMatcher.lookingAt()) {
            String id = idMatcher.group();
            pos += id.length();
            return new Token(TokenType.ID, id);
        }

        char nextChar = input.charAt(pos);
        pos++;
        switch (nextChar) {
            case '+':
                return new Token(TokenType.ADD, "+");
            case '-':
                return new Token(TokenType.SUB, "-");
            case '*':
                return new Token(TokenType.MUL, "*");
            case '/':
                return new Token(TokenType.DIV, "/");
            case '(':
                return new Token(TokenType.LPAREN, "(");
            case ')':
                return new Token(TokenType.LPAREN, ")");
            default:
                throw new RuntimeException("Unexpected character: \"" + nextChar + "\"");
        }
    }
}