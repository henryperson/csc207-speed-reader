import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {
	public String filename;
	private Scanner textScanner;
	
	public int wordCount;
	public int sentenceCount;
	
	/**
	 * Constructor for word generator
	 * @param filename, a file name (String)
	 * @throws IOException, an exception
	 */
	public WordGenerator(String filename) throws IOException {
		this.textScanner = new Scanner(new File(filename));
		this.filename = filename;
		
		this.wordCount = 0;
		this.sentenceCount = 0;
	}
	
	/**
	 * Boolean for if there is another word in the file
	 * @return hasNext, a boolean
	 */
	public boolean hasNext() {
		return this.textScanner.hasNext();
	}
	
	/**
	 * Gets the next word in the file.
	 * @return next, a string
	 * Also increments word count and (where appropriate) sentence count.
	 */
	public String next() {
		String text = this.textScanner.next();
		
		char lastChar = text.charAt(text.length() - 1);
		if (lastChar == '.' || lastChar == '?' || lastChar == '!') {
			this.sentenceCount += 1;
		}
		this.wordCount += 1;
		return text;
	}
	
	/**
	 * Getter method for wordCount.
	 * @return count, an int
	 */
	public int getWordCount() {
		return this.wordCount;
	}
	
	/**
	 * Getter method for sentenceCount
	 * @return count, an int
	 */
	public int getSentenceCount() {
		return this.sentenceCount;
	}
		
	
}
