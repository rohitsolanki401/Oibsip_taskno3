package ATMProject;
      
	import java.util.Scanner;

	public class ATMApp {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Users user = new Users("user123", "1234", 1000.0); // Sample user

	        System.out.println("Welcome to the ATM!");
	        System.out.print("Enter User ID: ");
	        String inputId = scanner.nextLine();
	        System.out.print("Enter PIN: ");
	        String inputPin = scanner.nextLine();

	        if (user.validateCredentials(inputId, inputPin)) {
	            BankingOperations operations = new BankingOperations(user);
	            boolean running = true;

	            while (running) {
	                System.out.println("\nATM Menu:");
	                System.out.println("1. Transactions History");
	                System.out.println("2. Withdraw");
	                System.out.println("3. Deposit");
	                System.out.println("4. Transfer");
	                System.out.println("5. Quit");
	                System.out.print("Select an option: ");
	                
	                int choice = scanner.nextInt();
	                switch (choice) {
	                    case 1:
	                        operations.showTransactionHistory();
	                        break;
	                    case 2:
	                        System.out.print("Enter amount to withdraw: ");
	                        double withdrawAmount = scanner.nextDouble();
	                        operations.withdraw(withdrawAmount);
	                        break;
	                    case 3:
	                        System.out.print("Enter amount to deposit: ");
	                        double depositAmount = scanner.nextDouble();
	                        operations.deposit(depositAmount);
	                        break;
	                    case 4:
	                        System.out.print("Enter amount to transfer: ");
	                        double transferAmount = scanner.nextDouble();
	                        System.out.print("Enter recipient user ID: ");
	                        String recipientId = scanner.next();
	                        operations.transfer(transferAmount, recipientId);
	                        break;
	                    case 5:
	                        running = false;
	                        System.out.println("Thank you for using the ATM. Goodbye!");
	                        break;
	                    default:
	                        System.out.println("Invalid option. Please try again.");
	                }
	            }
	        } else {
	            System.out.println("Invalid User ID or PIN. Access denied.");
	        }
	        scanner.close();
	    }
	}


