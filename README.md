# java-ll1-parser
A LL(1) parser for simple expressions written in Java. It's a recursive descent parser, but it might not exactly fit the criteria of an LL(1) parser. The whole project was written from scratch except for this [tree printing library](https://github.com/davidsusu/tree-printer/tree/v3.2.1) used to format the output as a tree.

## What does this project do?
This project creates and displays a parse tree for user input, which is derived from the following grammar I wrote:
- <expr> &#8594; <term> {(+ | -) <term>}
- <term> &#8594; <factor> {(* | /) <factor>}
- <factor> &#8594; <var> | (<expr>)
- <var> &#8594; number | identifier

## Why did you build this project?
I am taking a programming languages class where we are exploring tokenizers and parsers, so I decided to write one from scratch in Java to further my understanding of how parsers work, practice using regex, and demonstrate my knowledge of Java.
