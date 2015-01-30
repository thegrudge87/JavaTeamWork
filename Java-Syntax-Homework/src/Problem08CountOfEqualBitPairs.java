import java.util.Scanner;

public class Problem08CountOfEqualBitPairs {
	public static void main(String[] args) {
		System.out.print("n = ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String binaryN = Integer.toBinaryString(n);
		int counter = 0;
		
		for (int i = 0; i < binaryN.length()-1; i++) {
			char currBit = binaryN.charAt(i);
			char nextBit = binaryN.charAt(i+1);
			if (currBit == nextBit) {
				counter++;
			}
		}
		System.out.println("The count is: " + counter);
	}
}
