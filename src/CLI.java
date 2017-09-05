import java.util.Scanner;

public class CLI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //for input
		int input;
		
		System.out.println("Simple WorldGen");
		System.out.println("---------------");
		
		do {
			System.out.println("1. Generate world");
			System.out.println("2. Exit");
			
			input = scanner.nextInt();
			System.out.println(input);
		} while (input != 2);
		
		System.exit(0);
	}
	
	private void processInput(input) {
		
	}
}
