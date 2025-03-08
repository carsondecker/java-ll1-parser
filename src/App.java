import java.util.Scanner;

import model.*;
import services.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a math expression (no spaces): ");
        String input = scanner.nextLine();
        scanner.close();


        Tokenizer tokenizer = new Tokenizer(input);
        /* Scanner test
        Token token = tokenizer.nextToken();
        while (token.type != TokenType.EOF) {
            System.out.println(token);
            token = tokenizer.nextToken();
        }        
        */

        Parser parser = new Parser(tokenizer);
        NonterminalNode root = parser.parse();

        System.out.println(root);
    }
}
