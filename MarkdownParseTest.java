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
}