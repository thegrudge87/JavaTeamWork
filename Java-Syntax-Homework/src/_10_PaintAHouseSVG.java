
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
//import org.w3c.dom.DOMImplementation;
//import org.w3c.dom.Document;

public class _10_PaintAHouseSVG extends JPanel {
	// define array which will collects the coordinates of every point from the input
	public ArrayList<String> inputXYArrList = new ArrayList<String>();
	
	// a constructor that will work with the arraylist  
	public _10_PaintAHouseSVG(ArrayList<String> inputCoordinates){
		this.inputXYArrList = inputCoordinates;
	}
	
	public void paintCmpnt(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.white);
		
		Graphics2D g2 = (Graphics2D)g;
		int zoomScale = 40;
		
		// set the stroke width
		g2.setStroke(new BasicStroke(3f));
		// left rectangle
		Shape leftRctngl = new Rectangle2D.Double(12.5*zoomScale, 8.5*zoomScale, 5*zoomScale, 5*zoomScale);
		g2.setPaint(Color.lightGray);
		g2.fill(leftRctngl);
		g2.setPaint(Color.black);
		g2.draw(leftRctngl);
		
		// right rectangle
		Shape rightRctngl = new Rectangle2D.Double(20*zoomScale, 8.5*zoomScale, 2.5*zoomScale, 5*zoomScale);
		g2.setPaint(Color.lightGray);
		g2.fill(rightRctngl);
		g2.setPaint(Color.black);
		g2.draw(leftRctngl);
		
		// drawing the roof
		GeneralPath theRoof = new GeneralPath();
		// going the to point that we will start draw the triangle (the roof)
		// after that we are drawing a line from one angle to the other
		// and at the end we connect first with the last point closing the figure.
		theRoof.moveTo(12.5*zoomScale, 8.5*zoomScale);
		theRoof.lineTo(17.5*zoomScale, 3.5*zoomScale);
		theRoof.lineTo(22.5*zoomScale, 8.5*zoomScale);
		theRoof.closePath();
		
		g2.setPaint(Color.lightGray);
		g2.fill(theRoof);
		g2.setPaint(Color.black);
		g2.draw(theRoof);
		
		// drawing axes
		float[] dash = {2f, 3f};
		g.setColor(Color.cyan);
		BasicStroke basic = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10f, dash, 0f);
		g2.setStroke(basic);
		
		//draw axe Y
		// Set the start & end point of the vertical line.
		// The "step" is what will be the distance between the Y axes.
		double startX = 10;
		double startY = 2;
		double endX = 10;
		double endY = 17;
		double step = 2.5;
		
		// we will draw 6 lines
		for (int i = 0; i < 6; i++) {
			Shape axeY = new Line2D.Double(startX*zoomScale, startY*zoomScale, endX*zoomScale, endY*zoomScale);
			g2.draw(axeY);
			startX += step;
			endX += step;
		}
		
		// drawing axe X
		startX = 9;
		startY = 23.5;
		endX = 3.5;
		endY = 3.5;
		
		for (int i = 0; i < 6; i++) {
			Shape axeX = new Line2D.Double(startX*zoomScale, startY*zoomScale, endX*zoomScale, endY*zoomScale);
			startY += step;
			endY += step;
		}
		
		// draw coordinates text
		g.setColor(Color.black);
		g2.setFont(new Font("Times new roman", Font.PLAIN, zoomScale));
		
		float xTextLineY = 9.5f;
		float yTextLineY = 1.5f;
		for (int i = 0; i < 6; i++) {
			String[] textY = {"10","12.5", "15", "17.5", "20", "22.5"};
			g2.drawString(textY[i], xTextLineY*zoomScale, yTextLineY*zoomScale);
			xTextLineY +=2.5f;
		}
		
		float xTextLineX = 6.5f;
		float yTextLineX = 3.5f;
		for (int i = 0; i < 6; i++) {
			String[] textX = {"10","12.5", "15", "17.5", "20", "22.5"};
			g2.drawString(textX[i], xTextLineX*zoomScale, yTextLineX*zoomScale);
			yTextLineX += 2.5f;
		}
		
		// Draw points;
		g2.setStroke(new BasicStroke(2f));
		
		for (String string : inputXYArrList) {
			if (string.equals("stop")) {
				break;
			}
			
			String[] posPoint = string.split(" ");
			double pointX = Double.parseDouble(posPoint[0]);
			double pointY = Double.parseDouble(posPoint[1]);
			
			//String posPoint = 
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		Locale.setDefault(Locale.ROOT);
		ArrayList<String> inputCoordinates = new ArrayList<String>();		
		
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