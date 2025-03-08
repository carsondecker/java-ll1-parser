import java.util.Scanner;

import model.*;
import services.*;

import hu.webarticum.treeprinter.printer.traditional.TraditionalTreePrinter;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a math expression using numbers, variables, parentheses, +, -, *, and /:");
        String input = scanner.nextLine();
        input = input.replaceAll("\\s+", "");
        scanner.close();
        System.out.println("\nParse tree for your expression:");

        Tokenizer tokenizer = new Tokenizer(input);
        Parser parser = new Parser(tokenizer);
        NonterminalNode root = parser.parse();

        new TraditionalTreePrinter().print(root);
    }
}
