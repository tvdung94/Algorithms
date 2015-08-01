
public class PercolationStats {
	
	//private double T;
	private double results[];
	private double mean;
	private double stddev;
	private double Hi;
	private double Lo;
	public PercolationStats(int N, int T) {
		if (N<1 || T < 1) throw new java.lang.IllegalArgumentException();
		results = new double[T];
		int count = 0;
		double result;
		while (count < T) {
			int count_open = 0;
			result = 0.0;
			Percolation p = new Percolation(N);
			
			while (!p.percolates()) {
				//Open random grid 
				int row = StdRandom.uniform(N) + 1;
				int column = StdRandom.uniform(N) + 1;
				if (!p.isOpen(row, column)) {
					p.open(row, column);
					count_open++;
				}
				//System.out.println(row);
				//System.out.println(column);
				/*for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++)
						System.out.print(p.grids[i][j]);
					System.out.println();
				}
				System.out.println();*/
			}
			result = (double) count_open / (N*N);
			results[count]  = result;
			count++;
		}
		
		//Computing statistics
		double sum_mean = 0;
		double sum_dev = 0;
		
		for (int i = 0; i < T; i++)
			sum_mean += results[i];
		mean = sum_mean / T;
		
		for (int i = 0; i < T; i++)
			sum_dev = sum_dev + (results[i] - mean) * (results[i] - mean);
		
		stddev = sum_dev/(T - 1);
		stddev = Math.sqrt(stddev);
		
		Lo = mean - (1.96*stddev/Math.sqrt(T));
		
		Hi = mean + (1.96*stddev/Math.sqrt(T));
	}     
	   public double mean() {
		   return mean;
	   }                      
	   public double stddev() {
		   return stddev;
	   }                   
	   public double confidenceLo() {
		   return Lo;
	   }              
	   public double confidenceHi() {
		   return Hi;
	   }             

	   public static void main(String[] args) {
		  /* // test client (described below)
		   int N = Integer.parseInt(args[0]);
		   int T = Integer.parseInt(args[1]);
		   
		   PercolationStats ps = new PercolationStats(N, T);
		   System.out.printf("mean\t\t\t = %f\n", ps.mean());
		   System.out.printf("stddev\t\t\t = %f\n", ps.stddev());
		   System.out.printf("95%% confidence interval  = %f, %f\n", ps.confidenceLo(), ps.confidenceHi());*/
		   
	   }
}
