import java.util.Scanner;


public class BinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		int key = in.nextInt();
		int position = -1; // "not found"
		int front = 0; 
		int rear = n - 1;
		int mid;
		while (front <= rear) {
			mid = (front + rear) / 2;
			if (a[mid] < key)
				front++;
			else
				if (a[mid] > key)
					rear--;
				else {
					position = mid;
					break;
				}
		}
		System.out.println(position);
	}
}
