import java.util.Scanner;
public class Problem02TriangleArea {
	public static void main(String[] args) {
		System.out.println("Please enter the coordinates: ");
		Scanner input = new Scanner(System.in);
		int ax = input.nextInt();
		int ay = input.nextInt();
		int bx = input.nextInt();
		int by = input.nextInt();
		int cx = input.nextInt();
		int cy = input.nextInt();
		
		/*
		 * This resource could help you: 
		 * http://www.mathopenref.com/coordtrianglearea.html
		 */

		double area = Math.abs((ax*(by-cy)+bx*(cy-ay)+ cx*(ay-by))/2.00);
		System.out.println((int)area);
	}
}
