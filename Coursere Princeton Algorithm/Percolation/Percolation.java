
public class Percolation {
	private WeightedQuickUnionUF uf;
	private WeightedQuickUnionUF uf2;
	private boolean[][] grids;
	private int N;
	public Percolation(int N) {
		if (N<1) throw new java.lang.IllegalArgumentException();
		this.N = N;
		 uf = new WeightedQuickUnionUF(N*N + 2);
		 uf2 = new WeightedQuickUnionUF(N*N + 1);
		 grids = new boolean[N][N];
		 
		 
		 for (int i = 0; i < N; i++)
			 for (int j = 0; j < N; j++)
				 grids[i][j] = false;//blocked
	 }
	 public void open(int i, int j) {
		 if (i>N && j >N && i<1 && j<1) throw new java.lang.IndexOutOfBoundsException();
		 
		 grids[i - 1][j - 1] = true;
		 if (i==1) {
			 uf.union(0, j);
			 uf2.union(0, j);
		 }
		 if (i==N) uf.union(N*N + 1, (i-1)*N + j);
		 if (i - 1 >= 1 && isOpen(i-1, j)) {
			 uf.union((i-1)*N + j, (i-2)*N + j);
			 uf2.union((i-1)*N + j, (i-2)*N + j);
		 }
		 if (i + 1 <= N && isOpen(i+1, j)){
			 uf.union((i-1)*N + j, i*N + j);
			 uf2.union((i-1)*N + j, i*N + j);
			 
		 }
		 if (j + 1 <= N && isOpen(i, j + 1)) {
			 uf.union((i-1)*N + j, (i-1)*N + j + 1);
			 uf2.union((i-1)*N + j, (i-1)*N + j + 1);
		 }
		 if (j - 1 >= 1 && isOpen(i, j - 1)) {
			 uf.union((i-1)*N + j, (i-1)*N + j - 1);
			 uf2.union((i-1)*N + j, (i-1)*N + j - 1);
		 }
		 
	 } 
	 
	 public boolean isOpen(int i, int j) {
		 if (i>N || j >N || i<1 || j<1) throw new java.lang.IndexOutOfBoundsException();
		 return grids[i - 1][j - 1];
	 }
	 public boolean isFull(int i, int j) {
		 if (i>N || j >N || i<1 || j<1) throw new java.lang.IndexOutOfBoundsException();
		 return uf2.connected(0, (i-1)*N + j);
	 }    
	 public boolean percolates() {				
		 
		 return uf.connected(0, N*N+1);
	 }
	   
	/* public static void main(String[] args) {
		 Percolation p = new Percolation(4);
		 p.open(1,1);
		 p.open(1,2);
		 p.open(2,2);
		 p.open(3,2);
		 p.open(4,2);
		
		// p.uf.union(13, 17);
		 for (int i = 0; i < 4; i++) {
			 for (int j = 0; j < 4; j++) {
				 System.out.print(p.grids[i][j]);
			 }
			 System.out.println();
		 }
		 System.out.println(p.isOpen(4,1));
		 System.out.println(p.isFull(4,1));
		 System.out.println(p.percolates());
	 }*/
}
