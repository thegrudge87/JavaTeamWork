import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


public class GeneratePdfByLib {
	public static void main(String[] args) {
		String[] cardPower = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		char[] cardSuit = {'\u2665', '\u2666', '\u2663', '\u2660'}; // Hearts, Diamonds, Clubs, Spades
		
		for (String power : cardPower) {
			for (char suit : cardSuit) {
				System.out.print(power + suit + " ");
			}
			System.out.println();
		}
		
	}
}
