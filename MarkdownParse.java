//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            if (openBracket < 0) { break; }
            int closeBracket = markdown.indexOf("]", openBracket);
            if (closeBracket < 0) { break; }
            int openParen = markdown.indexOf("(", closeBracket);
            if (openParen < 0) { break; }
            if (openParen == closeBracket + 1) {
                int closeParen = markdown.indexOf(")", openParen);
                if (openParen < 0) { break; }
                int lastParen = closeParen + 1;
                while (lastParen < markdown.length()) {
                    if (markdown.substring(lastParen, lastParen + 1).equals(" ")) {
                        break;
                    }
                    if (markdown.charAt(lastParen) == '\n') {
                        break;
                    }
                    if (markdown.substring(lastParen, lastParen + 1).equals("/n")) {
                            break;
                    }
                    if (lastParen + 1 < markdown.length()) {
                        if (markdown.charAt(lastParen + 1) == '\n') {
                            break;
                        }
                        if (markdown.substring(lastParen + 1, lastParen + 2).equals("\n")) {
                            break;
                        }
                    }
                    lastParen = markdown.indexOf(")", lastParen);
                    if (lastParen < 0) { break; }
                    else { closeParen = lastParen; }
                    lastParen = closeParen + 1;
                }
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
            else {
                currentIndex = closeBracket + 1;
            }
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
    }
}
// a new comment
// a new line
