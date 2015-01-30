import java.util.Scanner;
public class Problem05DecimalToHex {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int decNumber = input.nextInt();
		
		// converting Decimal to Hex with method toHexString()
		String hexNum = Integer.toHexString(decNumber).toUpperCase();
		System.out.println(hexNum);
	}
	
}
