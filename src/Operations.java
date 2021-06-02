// 0 based indexing for background operations.
public class Operations {
	private int n, k;
	private int[] string;
	private int[] flips;
	private int[] changes;
	private int[] costs;
	int totalCost;
	
	
	public Operations(int n, int k, int[] costs) {
		totalCost = 0;
		this.n = n;
		this.k = k;
		this.costs = costs;
		fillArrays();
	}
	
	private void fillArrays() {
		string = new int[n];
		flips = new int[n];
		changes = new int[n];
		for(int i = 0; i < n; i++) {
			string[i] = 1;
			flips[i] = 0;
			changes[i] = 0;
		}
	}
	
	/**
	 * Flips the bits on the range [i-k, i+k] and records the flips.
	 * Does nothing if i is out of bounds.
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
			flips[j]++;
		}
		totalCost+=costs[i];
		changes[i]++;
	}
	
	
	public void printString() {
		for(int i = 0; i < n; i++) {
			System.out.print(string[i]);
		}
		System.out.println();
	}
	
	public void solve() {
		int minCost = Integer.MAX_VALUE;
		int bestFirstIndex = 0;
		for(int i = 0; i < k+1; i++) {
			for(int j = 0; j < n; j+=2*k+1) {
				change(j);
			}
			if(string[n-1] == 0) {
				minCost = Math.min(minCost, totalCost);
				if(minCost == totalCost) {
					bestFirstIndex = i;
				}
				System.out.println("Try #" + (i+1) + " solves.\nTotal cost is: " + totalCost + ".\nThe string after solution (should be all 0): ");
				printString();
				totalCost = 0;	//Reset cost
				for(int j = 0; j < n; j++) {
					string[j] = 1;	//Reset string
				}
			}
		}
		System.out.println("The minimum cost is " + minCost + " and it is achieved when the first index to be changed is " + bestFirstIndex);
	}
}
