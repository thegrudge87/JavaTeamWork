import java.util.Scanner;
//import java.util.Format;
public class Problem06FormattingNumbers {
	public static void main(String[] args) {
		System.out.println("Please enter 3 numbers:");
		Scanner input = new Scanner(System.in);
		
		// Read the input 
		System.out.print("a = ");
		int a = input.nextInt();
		System.out.print("b = ");
		double b = input.nextDouble();
		System.out.println("c = ");
		double c = input.nextDouble();
		
		// Converting the integer number "a" to Hex and Binary
		String aHex = Integer.toHexString(a).toUpperCase();
		
		// Converting the integer "a" to Binary with width 10 characters padded with zeros
		String aBinary = String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0");

		//Printout the output
		System.out.printf("|%-10s|%10s|%10.2f|%-10.3f|", aHex, aBinary, b, c);

	}
}
