import java.util.Scanner;


public class InsertionSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		//Sort
		int key;
		int j;
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			while (j > -1 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
		//Print
		for (int i = 0; i < n; i++) 
			System.out.printf("%d ", a[i]);
	}
}
