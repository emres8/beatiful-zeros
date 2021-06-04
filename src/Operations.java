import java.util.Arrays;

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
		if(costs.length != n) System.out.println("Entered costs is not of size " + n + ". The program may encounter an ArrayIndexOutOfBoundsException.");
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
	 * @time 		O(k)
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
	 * @time			O(n)
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
	 * @time			O(n)
	 */
	public boolean solveAtP(int p, boolean print) {
		if(p < 0 || p >= n) {
			if(print) System.out.println("Out of bounds.");
			return false;
		}
		for(int j = p; j < n; j+=2*k+1) {
			change(j);
		}
		boolean solved = string[n-1] == 0; //No bit is changed twice, so if the last bit is 0, we have a solution.
		if(print) {
			if(!solved) {
				System.out.println("Could not solve at index " + (p+1));
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
	 * @time			O(nk)
	 */
	public int solve() {
		return solve(false);
	}
	
	/**
	 * Uses solveAtP at each index from 0 to k, finds 
	 * the minimum cost of all valid solutions.
	 * @param print		true to print information about steps
	 * @return			the minimum cost of the valid solutions
	 * @time			O(nk)
	 */
	public int solve(boolean print) {
		int minCost = Integer.MAX_VALUE;
		int bestIndex = 0;
		for(int i = 0; i < k+1; i++) {
			if(solveAtP(i, print)) {
				minCost = Math.min(minCost, totalCost);
				if(minCost == totalCost)
					bestIndex = i+1;
			}
			totalCost = 0;
		}
		if(print) System.out.println("Starting at " + bestIndex + " gives the best solution.");
		return minCost;
	}

	/**
	 * Uses prototype algorithm to get a solution. Similar to solve(), but faster.
	 * @return		the minimum cost of the valid solutions
	 * @time		Generally O(n), O(n/k) or O(k) for some inputs n, k.
	 */
	public int prototypeSolve() {
		if(n <= k+1) {	//Anything is a solution with a single change action, return the minimum of all costs. This option is O(n).
			int minCost = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {	//O(n).
				minCost = Math.min(minCost, costs[i]);
			}
			return minCost;
		}else if( n <= 2*k+1){ // n - 2*(n-k-1) <=> 2*k-n+2  many solutions, with a single flip. This option is O(k).
			int minCost = Integer.MAX_VALUE;
			for(int i = n-k-1; i < k+1; i++) 	//O(2k-n+2) for k < n < 2k+1, O(k) for worst n, k (n = 3k/2).
				minCost = Math.min(minCost, costs[i]);
			return minCost;
		}else if(n%(2*k+1) == 0) {	//There's only 1 solution and it starts with index k+1. This option is O(n/k).
			int totalCost = 0;
			int index = k;
			while(index < n) {	//O(n/k).
				totalCost += costs[index];
				index+=2*k+1;
			}
			return totalCost;
		}else {	//This option is O(n).
			int totalSolutions = n%(2*k+1);	// There are that many solutions.
			if(totalSolutions <= k+1) { // We have a solution starting with 1, and then 2, 3, 4, ..., totalSolutions. This option is O(n).
				int minCost = Integer.MAX_VALUE;
				for(int i = 0; i < totalSolutions; i++) {	// Find the cost of each solution and get the minimum, this loop is O(k)
					int currentCost = 0;
					for(int j = i; j < n; j+= 2*k+1) {	//O(n/k);
						currentCost += costs[j];
					}
					minCost = Math.min(minCost, currentCost);
				}
				return minCost;
			}else {	//We do not have a solution using the first bit. This option is also O(n).
				int firstIndex = totalSolutions-k;	//There are not really totalSolutions many solutions in this case, sorry for bad naming.
				int minCost = Integer.MAX_VALUE;
				for(int i = firstIndex-1; i < k+1; i++) {	//Iterate over the possible solutions, find the minimum. This loop is O(k).
					int currentCost = 0;
					for(int j = i; j < n; j+=2*k+1) { //O(n/k)
						currentCost += costs[j];
					}
					minCost = Math.min(minCost, currentCost);
				}
				return minCost;
			}
		}
	}
	/**
	 * Uses an algorithm to solve the problem, indicated by the input boolean.
	 * @param prototype
	 * @return
	 */
	public int optionSolve(boolean prototype) {
		if(prototype) 
			return prototypeSolve();
		return solve(true);
	}
	
	public boolean compareAlgorithms() {
		return solve() == prototypeSolve();
	}
}
