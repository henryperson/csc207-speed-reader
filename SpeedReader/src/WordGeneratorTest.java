import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class WordGeneratorTest {

	@Test
	public void testGetWordCount() throws IOException {
		WordGenerator wg = new WordGenerator("WGtestfile.txt");
		assertEquals("wg.getWordCount = 0", 0, wg.getWordCount());
		for (int i = 1; wg.hasNext(); i++) {
			wg.next();
			assertEquals("wg.getWordCount = " + i, i, wg.getWordCount());
		}
	}
	
	@Test
	public void testGetSentenceCount() throws IOException {
		WordGenerator wg = new WordGenerator("WGtestfile.txt");
		assertEquals("wg.getSentenceCount = 0", 0, wg.getSentenceCount());
		wg.next();
		wg.next();
		assertEquals("wg.getSentenceCount = 1", 1, wg.getSentenceCount());
		
		while (wg.hasNext()) {
			wg.next();
		}
		assertEquals("wg.getSentenceCount = 2", 2, wg.getSentenceCount());
	}
}
