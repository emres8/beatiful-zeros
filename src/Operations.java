// 0 based indexing for background operations.
public class Operations {
	private int n, k;
	private int[] string;
	private int[] costs;
	int totalCost;
	
	
	public Operations(int n, int k, int[] costs) {
		totalCost = 0;
		this.n = n;
		this.k = k;
		this.costs = costs;
		fillArray();
	}
	
	private void fillArray() {
		string = new int[n];
		for(int i = 0; i < n; i++) {
			string[i] = 1;
		}
	}
	
	/**
	 * Flips the bits on the range [i-k, i+k]. Does nothing
	 * if i is out of bounds. Adds to the totalCost the
	 * cost of changing i.
	 * @param i		the center index
	 */
	public void change(int i) {
		if(i < 0 || i >= n) {
			System.out.println("Out of bounds.");
			return;
		}
		int left = Math.max(0, i-k);
		int right = Math.min(n-1, i+k);
		for(int j = left; j <= right; j++) {
			string[j] = 1 - string[j];
		}
		totalCost+=costs[i];
	}
	
	
	private void printString() {
		for(int i = 0; i < n; i++) {
			System.out.print(string[i]);
		}
		System.out.println();
	}
	
	/**
	 * Uses our algorithm starting at index p and changes indexes
	 * p + (2k+1)*t <= n, for t = 1, 2, 3, ...
	 * Restores the string to all 1s afterwards.
	 * Does not print anything.
	 * @param p			First index to be changed
	 * @return			Whether starting with p gives a solution
	 */
	public boolean solveAtP(int p) {
		return solveAtP(p, false);
	}
	
	/**
	 * Uses our algorithm starting at index p and changes indexes
	 * p + (2k+1)*t <= n, for t = 1, 2, 3, ...
	 * Restores the string to all 1s afterwards.
	 * @param p			First index to be changed
	 * @param print		true to print information about steps
	 * @return			Whether starting with p gives a solution
	 */
	public boolean solveAtP(int p, boolean print) {
		if(p < 0 || p >= n) {
			System.out.println("Out of bounds.");
			return false;
		}
		for(int j = p; j < n; j+=2*k+1) {
			change(j);
		}
		boolean solved = string[n-1] == 0; //No bit is changed twice, so if the last bit is 0, we have a solution.
		if(print) {
			if(!solved) {
				System.out.println("Could not solve at index " + p);
				printString();
			}
		}
		for(int i = 0; i < n; i++) {
			string[i] = 1;
		}
		return solved;	
	}
	
	/**
	 * Uses solveAtP at each index from 0 to k, finds 
	 * the minimum cost of all valid solutions.
	 * Does not print anything.
	 * @return			the minimum cost of the valid solutions
	 */
	public int solve() {
		return solve(false);
	}
	
	/**
	 * Uses solveAtP at each index from 0 to k, finds 
	 * the minimum cost of all valid solutions.
	 * @param print		true to print the string after *each* alteration
	 * @return			the minimum cost of the valid solutions
	 */
	public int solve(boolean print) {
		int minCost = Integer.MAX_VALUE;
		for(int i = 0; i < k+1; i++) {
			if(solveAtP(i, print)) {
				minCost = Math.min(minCost, totalCost);
			}
			totalCost = 0;
		}
		return minCost;
	}

}
