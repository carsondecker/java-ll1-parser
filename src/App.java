import model.*;
import services.*;

public class App {
    public static void main(String[] args) throws Exception {
        Tokenizer tokenizer = new Tokenizer("1+23*456/thisIsAVariable-7");
        Token token = tokenizer.nextToken();
        while (token.type != TokenType.EOF) {
            System.out.println(token);
            token = tokenizer.nextToken();
        }
    }
}
