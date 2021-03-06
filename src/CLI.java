import java.util.Scanner;

public class CLI {
	Scanner intScanner = new Scanner(System.in); //for integer input
	Scanner textScanner = new Scanner(System.in); //for text, string input - separate scanners to avoid input issues
	World currentWorld;

	public static void main(String[] args) { //run program
		CLI cli = new CLI();
		cli.run();
	}
	
	public void run() {
		int input;
		
		System.out.println("Simple WorldGen");
		System.out.println("---------------");
		
		do {
			System.out.println("1. Generate world");
			System.out.println("2. Exit");
			
			if (this.currentWorldExists()) {
				System.out.println("3. Display current world");
			}
			
			input = intScanner.nextInt();
			this.processMenuInput(input);
		} while (input != 2);
		
		this.terminateCLI();
	}
	
	private void processMenuInput(int input) {
		switch (input) {
			case 1:
				this.runWorldGeneration();
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
	
	private void runWorldGeneration() {			
		int input;
		
		do {
			System.out.println("Auto-generate or define parameters?");
			System.out.println("1. Auto-generate");
			System.out.println("2. Define parameters");
			System.out.println("3. Cancel");
			input = intScanner.nextInt();
			
			if (input == 1) {
				System.out.println("Generating world...");
				currentWorld = new World();
			} else if (input == 2) {
				this.generateWorldFromParameters();
			} else if (input == 3) {
				System.out.println("Cancelling");
			} else {
				System.out.println("Invalid");
			}
		} while (input != 1 && input != 2 && input != 3);
	}
	
	private void generateWorldFromParameters() {
		int intInput;
		String strInput;
		
		String worldName;
		
		do {
			System.out.println("World name:");
			strInput = textScanner.nextLine();
		} while (strInput == null);
		
		worldName = strInput;
		
		System.out.println("Generating world...");
		currentWorld = new World(worldName);
	}
	
	private void terminateCLI() {
		if (intScanner != null) {
			intScanner.close();
		}
		
		if (textScanner != null) {
			textScanner.close();
		}
		
		System.exit(0);
	}
	
	private boolean currentWorldExists() {
		return currentWorld != null;
	}
}
