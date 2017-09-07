import java.util.Scanner;

public class CLI {
	World currentWorld;

	public static void main(String[] args) { //run program
		CLI cli = new CLI();
		cli.run();
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in); //for input
		int input;
		
		System.out.println("Simple WorldGen");
		System.out.println("---------------");
		
		do {
			System.out.println("1. Generate world");
			System.out.println("2. Exit");
			
			if (currentWorld != null) {
				System.out.println("3. Display current world");
			}
			
			input = scanner.nextInt();
			this.processInput(input);
		} while (input != 2);
		
		if (scanner != null) { //close scanner
			scanner.close();
		}
		
		System.exit(0);
	}
	
	private void processInput(int input) {
		switch (input) {
			case 1:
				System.out.println("Generating world...");
				currentWorld = new World();
				break;
			
			case 2:
				System.out.println("Goodbye");
				break;
				
			case 3: 
				if (currentWorldExists()) {
					System.out.println("Displaying world " + currentWorld.name + ":");
					break;
				} else {
					System.out.println("Invalid");
					break;
				}				
				
			default:
				System.out.println("Invalid");
				break;
		}
	}
	
	private boolean currentWorldExists() {
		return currentWorld != null;
	}
}
