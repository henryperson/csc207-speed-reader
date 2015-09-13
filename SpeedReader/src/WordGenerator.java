import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {
	public String filename;
	private Scanner textScanner;
	
	public int wordCount;
	public int sentenceCount;
	
	public WordGenerator(String filename) throws IOException {
		this.textScanner = new Scanner(new File(filename));
		this.filename = filename;
		
		this.wordCount = 0;
		this.sentenceCount = 0;
	}
	
	public boolean hasNext() {
		return this.textScanner.hasNext();
	}
	
	public String next() {
		String text = this.textScanner.next();
		
		char lastChar = text.charAt(text.length() - 1);
		if (lastChar == '.' || lastChar == '?' || lastChar == '!') {
			this.sentenceCount += 1;
		}
		this.wordCount += 1;
		return text;
	}
	
	public int getWordCount() {
		return this.wordCount;
	}
	
	public int getSentenceCount() {
		return this.sentenceCount;
	}
		
	
}
