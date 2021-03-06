package mountain;

import java.util.HashMap;
import java.util.Map;

import fractal.Fractal;
import fractal.Side;
import fractal.TurtleGraphics;

public class Mountain extends Fractal{
	private Point a, b, c;
	private double dev;
	private Map<Side, Point> side_map;

	/** Creates an object that handles Koch's fractal. 
	 * @param length the length of the triangle side
	 */
	public Mountain(Point a, Point b, Point c, double dev) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		side_map = new HashMap<Side, Point>();
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
	public String getTitle() {
		return "Bergfraktal";
	}

	/** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, a, b, c, dev);
	}
	
	/**
	 * Computes the average of two points and adds a random deviation.
	 * @param start point
	 * @param end point
	 * @return average point
	 */
	private Point computeAveragePoint(Point p1, Point p2, double dev){
		int x = (p1.getX() + p2.getX())/2;
		int y = (int)((p1.getY() + p2.getY())/2 + RandomUtilities.randFunc(dev));
		return new Point(x, y);
	}
	
	/**
	 * Returns the average point of two points.
	 * @param start point
	 * @param end point
	 * @return average point
	 */
	private Point getAveragePoint(Point p1, Point p2, double dev){
		Side s = new Side(p1, p2);
		Point m = side_map.get(s);
		
		if(m != null){
			// Remove average point from map if it exists (and return it.)
			side_map.remove(s);
		}else{
			// Oterwise computer the average (with deviation) and add it to the map.
			m = computeAveragePoint(p1, p2, dev);
			side_map.put(s, m);	
		}
		
		return m;
	}
	
	/* 
	 * Recursive method: Draws recursive triangles. 
	 */
	private void fractalTriangle(TurtleGraphics turtle, int order, Point p1, Point p2, Point p3, double dev){
		if(order == 0){
			// Draw triangle
			turtle.moveTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
		}else{
			// Get averges.
			Point m1 = getAveragePoint(p1,p2, dev);
			Point m2 = getAveragePoint(p2,p3, dev);
			Point m3 = getAveragePoint(p3,p1, dev);
			
			// Draw new triangles.
			fractalTriangle(turtle, order - 1, p1, m1, m3, dev/2);
			fractalTriangle(turtle, order - 1, m1, m2, m3, dev/2);
			fractalTriangle(turtle, order - 1, m3, m2, p3, dev/2);
			fractalTriangle(turtle, order - 1, m1, p2, m2, dev/2);
		}
	}
}
