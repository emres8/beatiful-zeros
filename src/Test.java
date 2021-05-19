import java.util.Scanner;

public class Test {

	private static Operations o;


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("Enter n: ");
			int n = scanner.nextInt();
			System.out.print("Enter k: ");
			int k = scanner.nextInt();
			o = new Operations(n, k);
			o.printString();
			while(true) {
				System.out.print("Flip (-1 to exit):");
				int i = scanner.nextInt();
				if(i == -1)
					break;
				o.change(i-1);
				o.printString();
			}
		}

	}
}
