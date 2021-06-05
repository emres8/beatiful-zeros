import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Test {

	private static final int TEST_COUNT = 5;
	private static boolean base = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		outerloop:
			while(true) {
				String current;
				if(base) current = "Base Algorithm";
				else current = "Improved Algorithm";
				System.out.println("\nEnter test option (-1 to exit):\n1) See our hand-written tests\n2) Do tests with random n, k and cost values (Does " + TEST_COUNT + " tests by default)\n"
						+ "3) Enter n, k and costs for custom test\n4) Switch mode to use improved or base algorithm (Current: " + current + ")\n5) Compare two algorithms on 100 random inputs");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					System.out.println("\nHand-written tests: ");
					handWrittenTest();
					break;
				case 2:
					System.out.println("\nDoing " + TEST_COUNT + " random tests: ");
					randomTest(TEST_COUNT);
					break;
				case 3:
					System.out.println("\nCustom test: ");
					customTest(scanner);
					break;
				case 4:
					if(base) System.out.println("\nChanging mode to improved algorithm.");
					else System.out.println("\nChanging mode to base algorithm.");
					base = !base;
					break;
				case 5:
					compareAlgorithms(100);
					break;
				case -1:
					break outerloop;
				default:
					System.out.println("\nInvalid input. Please enter 1, 2, or 3 (-1 to exit).");
					break;
				}
			}
		System.out.println("\nExiting.");
	}


	private static void handWrittenTest() {
		int minCost, fails = 0;
		long startTime, elapsedTime;
		System.out.println("\n///////////////////////////////\nOption 1: 2k+1|n-1\n///////////////////////////////\n");
		Operations o = new Operations(21, 2, new int[]{1, 5, 3, 2, 4, 6, 8, 4, 5, 1, 0, 2, 1, 3, 1, 1, 4, 7, 5, 1, 4});
		System.out.println("n: 21 k: 2");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 12, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 12)	fails++;
		o = new Operations(22, 3, new int[] {3, 5, 3, 2, 4, 6, 8, 4, 5, 1, 0, 2, 1, 3, 1, 1, 4, 7, 5, 1, 4, 6});
		System.out.println("n: 22 k: 3");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 14, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 14)	fails++;
		System.out.println("\n///////////////////////////////\nOption 2: n%(2k+1) < k+1\n///////////////////////////////\n");
		o = new Operations(17, 3, new int[] {4, 2, 9, 8, 4, 2, 6, 2, 9, 12, 14, 15, 18, 9, 0, 14, 17});
		System.out.println("n: 17 k: 3");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 6, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 6)	fails++;
		o = new Operations(11, 4, new int[]{2, 1, 11, 4, 7, 13, 6, 12, 21, 5, 11});
		System.out.println("n: 11 k: 4");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 7, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 7)	fails++;
		System.out.println("\n///////////////////////////////\nOption 3: n%(2k+1) = k+1\n///////////////////////////////\n");
		o = new Operations(18, 3, new int[] {4, 2, 5, 9, 1, 11, 4, 16, 8, 6, 5, 13, 1, 0, 1, 2, 14, 15});
		System.out.println("n: 18 k: 3");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 12, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 12)	fails++;
		System.out.println("\n///////////////////////////////\nOption 4: n%(2k+1) > k+1\n///////////////////////////////\n");
		o = new Operations(19, 3, new int[] {4, 2, 9, 8, 4, 2, 6, 2, 9, 12, 14, 15, 18, 9, 0, 14, 17, 14, 2});
		System.out.println("n: 19 k: 3");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 25, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 25)	fails++;
		o = new Operations(16, 4, new int[]{2, 1, 11, 4, 7, 13, 6, 12, 21, 5, 11, 5, 2, 4, 12, 2});
		System.out.println("n: 16 k: 4");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 6, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 6)	fails++;
		System.out.println("\n///////////////////////////////\nOption 5: n <= k+1\n///////////////////////////////\n");
		o = new Operations(20, 19, new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 0, 20, 30, 40, 50, 60, 70, 80, 90, 100});
		System.out.println("n: 20 k: 19");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 0, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 0)	fails++;
		o = new Operations(30, 29, new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100});
		System.out.println("n: 30 k: 29");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 9, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 9)	fails++;
		System.out.println("\n///////////////////////////////\nOption 6: k = 0\n///////////////////////////////\n");
		o = new Operations(10, 0, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		System.out.println("n: 10 k: 0");
		startTime = System.nanoTime();
		minCost = o.optionSolve(base);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("The minimum cost should be 55, and it is: " + minCost + "\nThe test took " + elapsedTime + " milliseconds.");
		if(minCost != 55)	fails++;
		if(fails == 0) System.out.println("\nAll tests passed successfully.\n");
		else System.out.println("\nThere were " + fails + " fails.\n");
	}
	private static void randomTest(int tries) {
		for(int i = 0; i < tries; i++) {
			int n = (int) (Math.random()*40+10);
			int k = (int) (Math.random()*17+3);
			System.out.println("\n\n\nTest #" + (i+1) + " n: " + n + " k: " + k+ ".");
			int[] costs = new int[n];
			for(int j = 0; j < n; j++) {
				costs[j] = (int) (Math.random()*100);	//Costs are randomized between 0 and 100;
				if( j != n-1) System.out.print(costs[j] + ", ");
				else System.out.println(costs[j]);
			}
			Operations o = new Operations(n, k, costs);
			long startTime = System.nanoTime();
			System.out.println("The minimum costs is: " + o.optionSolve(base));
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("The test took " + elapsedTime + " milliseconds.");
		}
	}
	
	private static void customTest(Scanner sc) {
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		System.out.println("Enter k: ");
		int k = sc.nextInt();
		System.out.println("Enter costs with a space in between: ");
		sc.nextLine();
		String costsStr = sc.nextLine();
		String[] tokens = costsStr.split(" ");
		while(tokens.length != n) {
			System.out.println("Invalid string length. Please enter a string of lenth n: ");
			costsStr = sc.nextLine();
			tokens = costsStr.split(" ");
		}
		int[] costs = new int[n];
		for(int i = 0; i < n; i++) {
			costs[i] = Integer.parseInt(tokens[i]);
		}
		Operations o = new Operations(n, k, costs);
		long startTime = System.nanoTime();
		System.out.println("The minimum costs is: " + o.optionSolve(base));
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("The test took " + elapsedTime + " milliseconds.");
	}
	private static void compareAlgorithms(int tries) {
		for(int i = 0; i < 100; i++) {
			int n = (int) (Math.random()*190+10);
			int k = (int) (Math.random()*27+3);
			int[] costs = new int[n];
			for(int j = 0; j < n; j++) {
				costs[j] = (int) (Math.random()*100);	//Costs are randomized between 0 and 100;
			}
			Operations o = new Operations(n, k, costs);
			if(!o.compareAlgorithms()) {
				System.out.println("The algorithms resulted in a different result at n: " + n + " k: " + k + " costs: " + Arrays.toString(costs));
				return;
			}
		}
		System.out.println("Two algorithms gave the same solution for all " + tries + " tests.");
	}
}
