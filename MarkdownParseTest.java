import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testGetLinks() throws IOException {
        List<String> testFileLinks = List.of("https://something.com", 
                                            "some-thing.html");
        Path testFile = Path.of("test-file.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), testFileLinks);
    }

    @Test
    public void testBrackets() throws IOException {
        List<String> testFileLinks = new ArrayList<>();
        Path testFile = Path.of("test-brackets.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), testFileLinks);
    }

    @Test
    public void testNewLine() throws IOException {
        List<String> testFileLinks = List.of("https://google.com");
        Path testFile = Path.of("test-new-line.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), testFileLinks);
    }

    @Test
    public void testParentheses() throws IOException {
        List<String> testFileLinks = List.of("http://en.wikipedia.org/wiki/PC_Tools_(Central_Point_Software");
        Path testFile = Path.of("test-parentheses-in-link.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), testFileLinks);
    }
}