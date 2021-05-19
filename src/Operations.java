// 0 based indexing for background operations.
public class Operations {
	private int n, k;
	private int[] string;
	private int[] flips;
	private int[] changes;
	
	
	public Operations(int n, int k) {
		this.n = n;
		this.k = k;
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
		changes[i]++;
	}
	
	
	public void printString() {
		for(int i = 0; i < n; i++) {
			System.out.print(string[i]);
		}
		System.out.println();
	}
}
