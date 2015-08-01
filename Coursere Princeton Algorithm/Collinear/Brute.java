import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Brute {
	public static void main(String[] args) {
		try {
			StdDraw.setXscale(0, 32768);
	        StdDraw.setYscale(0, 32768);
	        
	        StdDraw.setPenRadius(0.01);
			Scanner in = new Scanner(new File(args[0]));
			int N = in.nextInt();
			List<Point> p = new ArrayList<Point>();
			Point[] a = new Point[N];
			int x;
			int y;
			for (int i = 0; i < N; i++) {
				 x = in.nextInt();
				 y = in.nextInt();
				 a[i] = new Point(x,y);
				 a[i].draw();
			}
			StdDraw.show(0);

	        // reset the pen radius
	        StdDraw.setPenRadius();
			Arrays.sort(a);
			double slope1;
			double slope2;
			double slope3;
			for (int i = 0; i < N - 3; i++)
				for (int j = i + 1; j < N - 2; j++) {
					slope1 = a[i].slopeTo(a[j]);
					for (int k = j + 1; k < N - 1; k++) {
						slope2 = a[i].slopeTo(a[k]);
						if (slope1 == slope2)
							for (int l = k + 1; l < N; l++) {
								slope3 = a[i].slopeTo(a[l]);
								if (slope1==slope3) {
									System.out.printf(a[i].toString() + " -> " + a[j].toString()
										+ " -> " + a[k].toString() + " -> " + a[l].toString() + "\n");
									a[i].drawTo(a[l]);
								}
							}
					}
				}
			StdDraw.show(0);
							
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
