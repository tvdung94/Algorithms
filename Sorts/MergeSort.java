import java.util.Scanner;


public class MergeSort {
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] <  b[j]) {
				c[k] = a[i];
				i++;
			}
			else {
				c[k] = b[j];
				j++;
			}
			k++;
		}
		
		if (i == a.length  && j < b.length ) {
			for (int l = j; l < b.length; l++)
				c[k++] = b[l];
		}
		
		if (j == b.length && i < a.length ) {
			for (int l = i; l < a.length; l++)
				c[k++] = a[l];
		}
		return c;
	}
	public static int[] sort(int[] a,int start, int end) {
		if (start == end ) {
			int[] b = new int[1];
			b[0] = a[start];
			System.out.println(b[0]);
			return b;
		}
		int m = (start + end) / 2;
		int[] c = sort(a, start, m);
		int[] d = sort(a, m + 1, end);
		int[] b = merge(c,d);
		return b;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		int[] b = sort(a, 0, n - 1);
		for (int i = 0; i < b.length; i++)
			System.out.printf("%d ", b[i]);
	}
}
