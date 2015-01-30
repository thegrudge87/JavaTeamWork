import java.util.Scanner;
import java.util.Arrays;

public class SortArrayOfStrings {
	public static void main(String[] args) {
		
		/* The number of array inputs. */
		System.out.print("Number of inputs: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] inputArray = new String[n];
		
		// Fill the array values.
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = input.next();
		}
		input.close();
		
		// Print the array values.
		Arrays.sort(inputArray);
		for (String y : inputArray) {
			System.out.println(y);
		}	
	}
}