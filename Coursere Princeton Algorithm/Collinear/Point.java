import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
    	public int compare(Point q, Point r) {
            /* YOUR CODE HERE */
    		double slopeq = slopeTo(q);
    		double sloper = slopeTo(r);
    		if (slopeq < sloper)
    			return -1;
    		else if (slopeq == sloper)
    				return 0;
    		return 1;
        }
    };       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    	double dx = that.x - x;
    	double dy = that.y - y;
    	if (dy == 0)
    		if (dx != 0)
    			return 0.0;
    		else
    			return Double.NEGATIVE_INFINITY;
    	else if (dx == 0)
    			return Double.POSITIVE_INFINITY;
    	return dy/dx;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    	if (y < that.y) 
    		return -1;
    	else if (y == that.y)
    			if (x < that.x) 
    				return -1;
    			else if (x > that.x)
    					return 1;
    				else
    					return 0;
    	return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}