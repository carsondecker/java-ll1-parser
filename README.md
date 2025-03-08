# Simple Java LL(1) Parser
An LL(1) parser for simple expressions written in Java. It's a recursive descent parser, but it might not exactly fit the exact criteria of an LL(1) parser. The whole project was written from scratch except for this [tree printing library](https://github.com/davidsusu/tree-printer/tree/v3.2.1) used to format the output as a tree.

## What does this project do?
This project creates and displays a parse tree for user input, which is derived from the following grammar I wrote:

- `<expr>` → `<term>` {(+ | -) `<term>`}
- `<term>` → `<factor>` {(* | /) `<factor>`}
- `<factor>` → `<var>` | (`<expr>`)
- `<var>` → number | identifier

## Why did you build this project?
I am taking a programming languages class where we are exploring tokenizers and parsers, so I decided to write one from scratch in Java to further my understanding of how parsers work, practice using regex, and demonstrate my knowledge of Java.

## How do I run this project?
- Download the JRE from [here](https://www.java.com/en/download/), choose the correct one based on your OS, click on it and follow the installation instructions.
- Open your command line and run `java -version` to make sure you have java installed. It should give you details on your installation.
- Go to the releases tab on this github page and download the .jar file.
- Open your command line and run `cd FILEPATH`. Go to your file explorer and locate the .jar file, then copy and paste the filepath next to cd, don't just paste in FILEPATH.
- Run `java -jar java-ll1-parser.jar`.
