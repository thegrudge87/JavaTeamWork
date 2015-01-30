import java.util.Scanner;
public class Problem01RectangleArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Fill the input: ");
		int a = input.nextInt();
		int b = input.nextInt();
		int rectangle = a * b;
		
		System.out.println(rectangle);
	}
}
