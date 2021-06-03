import java.util.Scanner;

public class Test {



	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		while(true) {
//			System.out.print("Enter n: ");
//			int n = scanner.nextInt();
//			System.out.print("Enter k: ");
//			int k = scanner.nextInt();
//			o = new Operations(n, k);
//			o.printString();
//			while(true) {
//				System.out.print("Flip (-1 to exit):");
//				int i = scanner.nextInt();
//				if(i == -1)
//					break;
//				o.change(i-1);
//				o.printString();
//			}
//			o.solve();
//		}
		randomTest(10);

	}
	
	public static void randomTest(int tries) {
		for(int i = 0; i < tries; i++) {
			int n = (int) (Math.random()*190+10);
			int k = (int) (Math.random()*17+3);
			System.out.println("\n\n\nTest #" + (i+1) + " n: " + n + " k: " + k+ ".");
			int[] costs = new int[n];
			for(int j = 0; j < n; j++) {
				costs[j] = (int) (Math.random()*100);	//Costs are randomized between 0 and 100;
			}
			Operations o = new Operations(n, k, costs);
			System.out.println("The minimum costs is: " + o.solve(true));
		}
	}
}
