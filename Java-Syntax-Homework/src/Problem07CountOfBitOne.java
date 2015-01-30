import java.util.Scanner;

public class Problem07CountOfBitOne {
	public static void main(String[] args) {
		System.out.print("n = ");
		Scanner input = new Scanner(System.in);
		
		// reads the user input
		int n = input.nextInt();
		
		// prints the output
		System.out.println(Integer.bitCount(n));
	}
}
