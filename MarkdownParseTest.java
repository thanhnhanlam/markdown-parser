import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {

    List<String> emptyString;

    private final static String TEST_FOLDER = "test-files/";
    private final static String LAB4_FOLDER = "lab-4-markdown-snippets/";

    @Before
    public void setUp() {
        emptyString = new ArrayList<>();
    }

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
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testBrackets() throws IOException {
        List<String> testFileLinks = new ArrayList<>();
        Path testFile = Path.of(TEST_FOLDER + "test-brackets.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testNewLine() throws IOException {
        List<String> testFileLinks = List.of("https://google.com");
        Path testFile = Path.of(TEST_FOLDER + "test-extra-line.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testParentheses() throws IOException {
        List<String> testFileLinks = List.of("http://en.wikipedia.org/wiki/PC_Tools_(Central_Point_Software)");
        Path testFile = Path.of(TEST_FOLDER + "test-parentheses-in-link.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }
    
    @Test
    public void testFile1() throws IOException {
        List<String> testFileLinks = List.of("https://something.com", "some-thing.html");
        Path testFile = Path.of("test-file.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testFile2() throws IOException {
        List<String> testFileLinks = List.of("https://something.com", "some-page.html");
        Path testFile = Path.of("test-file2.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testFile3() throws IOException {
        Path testFile = Path.of("test-file3.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(emptyString, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testFile4() throws IOException {
        Path testFile = Path.of("test-file4.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(emptyString, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testFile5() throws IOException {
        Path testFile = Path.of("test-file5.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(emptyString, MarkdownParse.getLinks(testFileContent));
    }
    
    @Test
    public void testFile6() throws IOException {
        List<String> testFileLinks = List.of("page.com");
        Path testFile = Path.of("test-file6.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testFile7() throws IOException {
        Path testFile = Path.of("test-file7.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(emptyString, MarkdownParse.getLinks(testFileContent));
    }
    
    @Test
    public void testFile8() throws IOException {
        List<String> testFileLinks = List.of("a link on the first line");
        Path testFile = Path.of("test-file8.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }
    
    @Test
    public void testSnippet1() throws IOException {
        List<String> testFileLinks = List.of("`google.com", "google.com", "ucsd.edu");
        Path testFile = Path.of(LAB4_FOLDER + "snippet1.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }
    
    @Test
    public void testSnippet2() throws IOException {
        List<String> testFileLinks = List.of("a.com", "a.com(())", "example.com");
        Path testFile = Path.of(LAB4_FOLDER + "snippet2.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }

    @Test
    public void testSnippet3() throws IOException {
        List<String> testFileLinks = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path testFile = Path.of(LAB4_FOLDER + "snippet3.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }
    
    @Test
    public void testos() {
        assertEquals("?",  System.get("os"));
    }
                     
}
