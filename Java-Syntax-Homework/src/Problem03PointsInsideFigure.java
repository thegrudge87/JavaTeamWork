import java.util.Scanner;
public class Problem03PointsInsideFigure {
	public static void main(String[] args) {
		System.out.println("Please enter the coordinates of the point:");
		Scanner input = new Scanner(System.in);
		
		double ax = input.nextDouble();
		double ay = input.nextDouble();
		
		if ((ay >= 6) && (ay <= 13.5) && (ax >= 12.5) && (ax <=22.5)) {
			if (ay <= 8.5) {
				System.out.println("Inside");
			} else {
				if ((ax <= 17.5) || (ax >= 20 )) {
					System.out.println("Inside");
				} else {
					System.out.println("OutSide");
				}
			}
		} else {
			System.out.println("Outside");
		}
	}
}
