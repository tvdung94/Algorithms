import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Fast {
	/*private static void sort(List<Point> p, int lo, int hi) {
		
	}*/
	public static void main(String[] args) {
		Scanner in;
		try {
			StdDraw.setXscale(0, 32768);
	        StdDraw.setYscale(0, 32768);
	        
	        StdDraw.setPenRadius(0.01);
			in = new Scanner(new File(args[0]));
		
			int N = in.nextInt();
			
	        
			Point[] a = new Point[N];
			Point[] b = new Point[N];
			int x;
			int y;
			for (int i = 0; i < N; i++) {
				 x = in.nextInt();
				 y = in.nextInt();
				 a[i] = new Point(x,y);
				 b[i] = a[i];
				 b[i].draw();
			}
			Point origin;
			StdDraw.show(0);
	        // reset the pen radius
	        StdDraw.setPenRadius();
			for (int i = 0; i < N; i++) {
				origin = b[i];
				//Quicksort
				Arrays.sort(a);
				
				Arrays.sort(a, origin.SLOPE_ORDER);
				/*for (int j = 0; j < N; j++)
					System.out.println(a[j].toString() + a[j].slopeTo(origin));*/
				Point start = a[0];
				boolean check;
				double c,d,e;
				String result ="";
				for (int j = 0; j < N; j++) {
					check = false;
					
					if (j+2 <N) {
						c = a[j].slopeTo(origin);
						d = a[j + 1].slopeTo(origin);
						e = a[j + 2].slopeTo(origin);
						if (c==d && d==e) {
							
							check = true;
							if ((j - 1 < 0 || a[j - 1].slopeTo(origin) != c) ) {
								result += origin.toString() + " -> ";
								start = a[j];
							}
							result+=a[j].toString() + " -> ";
						}
					}
					
					if (!check) {
						if (j + 1 < N && j - 1 >= 0) {
							c = a[j-1].slopeTo(origin);
							d = a[j].slopeTo(origin);
							e = a[j+1].slopeTo(origin);
							if (c==d && d==e) {
								check = true;
								result+= a[j].toString() + " -> ";
							}
						}
					}
					if (!check) {
						if (j - 2 >= 0) {
							c = a[j-2].slopeTo(origin);
							d = a[j-1].slopeTo(origin);
							e = a[j].slopeTo(origin);
							if (c==d && d==e) {
								result+= a[j].toString();
								if (origin.compareTo(start) == -1) {
									System.out.println(result);
									result = "";
									origin.drawTo(a[j]);
								}
							}
						}
					}
				}
						
			}
						
			
			StdDraw.show();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
