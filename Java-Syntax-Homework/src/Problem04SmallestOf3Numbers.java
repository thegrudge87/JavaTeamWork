import java.text.DecimalFormat;
import java.util.Scanner;
public class Problem04SmallestOf3Numbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		double min = Math.min(a, b);
		min = Math.min(min, c);
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(min));
	}
}
