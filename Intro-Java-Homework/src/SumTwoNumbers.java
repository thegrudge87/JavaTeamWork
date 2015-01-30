import java.util.Scanner;

public class SumTwoNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a = ");
		int a = in.nextInt();
		System.out.print("Enter b = ");
		int b = in.nextInt();
		in.close();
		System.out.println("Result is:" + (a + b));
	}
}
