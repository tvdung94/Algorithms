import java.util.Scanner;


public class SelectionSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		int swap;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (a[i] > a[j]) {
					swap = a[i];
					a[i] = a[j];
					a[j] = swap;
				}
		for (int i = 0; i < n; i++)
			System.out.printf("%d ", a[i]);
	}
}
