import java.awt.*;
import java.io.File;
import java.io.IOException;


public class SpeedReader {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		String filename = args[0];
		int width = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		int fontsize = Integer.parseInt(args[3]);
		int wpm = Integer.parseInt(args[4]);
		
		Graphics g = initializeDisplay(width, height, fontsize);
		WordGenerator wg = new WordGenerator(filename);
		printStaggered(wg, g, wpm, width, height);
	}
	
	/**
	 * Driver function for displaying words on the panel at wpm speed.
	 * @param wg, a WordGenerator
	 * @param g, a Graphics instance
	 * @param wpm, an int for speed
	 * @param width, an int for the width of the panel
	 * @param height, an int for the height of the panel
	 * @throws InterruptedException
	 */
	public static void printStaggered(WordGenerator wg, Graphics g, 
			int wpm, int width, int height) 
			throws InterruptedException {
		FontMetrics fm = g.getFontMetrics();
	    while(wg.hasNext()) {
	    	String word = wg.next();
	    	g.setColor(Color.black);
	        g.drawString(word, getWordX(word, fm, width), getWordY(fm, height));
	        Thread.sleep(getMilliseconds(wpm));
	        g.setColor(Color.white);
	        g.fillRect(0, 0, width, height);
	    }
	}
	
	/**
	 * Converts wpm to milliseconds
	 * @param wpm, an int
	 * @return milliseconds, an int
	 */
	public static int getMilliseconds(int wpm) {
		return 60000 / wpm;
	}
	
	/**
	 * Creates a panel with give font, width, height
	 * @param width, an int for the width
	 * @param height, an int for the height
	 * @param fontsize, an int for the font size
	 * @return g, a Graphics instance
	 */
	public static Graphics initializeDisplay(int width, int height, int fontsize) {
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontsize);
		g.setFont(f);
		return g;
	}
	
	/**
	 * Returns the x-position of word so it is centered
	 * @param word, a String for the word we are centering
	 * @param fm, a FontMetrics for the graphics instance
	 * @param windowWidth, an int for the width of the window
	 * @return x, an int for the x-position
	 */
	public static int getWordX(String word, FontMetrics fm, int windowWidth) {
		int stringWidth = fm.stringWidth(word);
		return (int) ((windowWidth - stringWidth) / 2);
	}
	
	/**
	 * Returns the y-position of word so it is centered
	 * @param fm, a FontMetrics for the graphics instance
	 * @param windowHeight, an int for the height of the window
	 * @return y, an int for the y-position
	 */
	public static int getWordY(FontMetrics fm, int windowHeight) {
		int stringHeight = fm.getHeight();
		return (int) ((windowHeight - stringHeight) / 2);
	}
}
