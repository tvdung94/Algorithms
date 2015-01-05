import java.util.Scanner;


public class QuickSortv2 {
	public static int parition(int[] a, int start, int end) {
		int left = start; 
		int swap;
		for (int right = start; right < end; right++ )
			if  (a[right] < a[end]) { 
				 swap = a[right];
				 a[right] = a[left];
			 	 a[left] = swap;
			 	 left++;
			}
		swap = a[left];
		a[left] = a[end];
		a[end] = swap;
		return left;
	}
	public static void qsort(int[] a, int start, int end) {
		if (start < end) { 
			int m = parition(a, start, end);
			qsort(a, start, m - 1);
			qsort(a, m + 1, end);
		}
		
	}
	public static void main(String[] args) {
		
		//Input
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		
		//Execute
		qsort(a, 0, n - 1);
		//Output
		for (int i = 0; i < n; i++)
			System.out.printf("%d ", a[i]);
	}
}
