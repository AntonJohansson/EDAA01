package fractal;

import mountain.Point;

public class Side {
	private Point a;
	private Point b;
	
	public Side(Point a, Point b){
		this.a = a;
		this.b = b;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Side) {
			Side s = (Side) obj;
			// Check endpoints independand of ordering.
			return (s.a == a && s.b == b) || (s.a == b && s.b == a);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return a.hashCode() + b.hashCode();
	}
}
