import java.util.Scanner;


public class QuickSortExample {
	
	public static void quickSort(int[] a, int start, int end) {
		if (start < end) {
			int m = (start + end) / 2;
			int key = a[m];
			int i = start;
			int j = end;
			int swap;
			while (i <= j) {
				while (a[i] < key)
					i++;
				while (a[j] > key)
					j--;
				if (i <= j) {
					swap = a[i];
					a[i] = a[j];
					a[j] = swap;
					i++;
					j--;
				}
			}
		/*for (int x = start; x <= end; x++)
			System.out.printf("%d ", a[x]);
		System.out.println();*/
		quickSort(a, start, m);
		quickSort(a, m + 1, end);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		quickSort(a, 0, n - 1);
		for (int i = 0; i < n; i++)
			System.out.printf("%d ", a[i]);
	}
}
