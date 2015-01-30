import java.util.Scanner;

class Problem09PointsInsideTheHouse {
	public static void main(String[] args) {
		System.out.print("Insert point coordinates: ");
		Scanner input = new Scanner(System.in);
		double px = input.nextDouble();
		double py = input.nextDouble();
		
		if ((px >= 12.5) && (px <= 22.5) && (py >= 3.5) && (py <= 13.5)) {
			if ((py >= 8.5) && ((px <= 17.5)|| (px >= 20.0))) {
				System.out.println("Inside");
			} else {
				// The area of main triangle ABC
				double theTrngl = area(12.5, 8.5, 22.5, 8.5, 17.5, 3.5);
				// The area of triangle ABP
				double firstTrngl = area(12.5, 8.5, 22.5, 8.5, px, py);
				// The area of triangle APC
				double secondTrngl = area(12.5, 8.5, px, py, 17.5, 3.5);
				// The area of triangle PBC
				double thirdTrngl = area(px, py, 22.5, 8.5, 17.5, 3.5);
				
				// Check is sum of the areas of the 3 triangles is equal 
				// to the area of the big/main triangle; 
				if (theTrngl == firstTrngl + secondTrngl + thirdTrngl) {
					System.out.println("Inside");
				} else {
					System.out.println("Outside");
				}
			}
		} else {
			System.out.println("Outside");
		}
	}
	
	// function that calculates the area of the triangle
	// formed by (x1; y1), (x2; y2) and (x3; y3)
	public static double area (double x1, double y1, double x2, double y2, double x3, double y3){
		return Math.abs((x1*(y2-y3)+x2*(y3-y1)+ x3*(y1-y2))/2.00);		
	}
}
