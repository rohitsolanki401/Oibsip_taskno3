package ATMProject;
	
	import java.util.ArrayList;
	import java.util.List;

	public class BankingOperations {
	    private Users user;
	    private List<String> transactionHistory;

	    public BankingOperations(Users user) {
	        this.user = user;
	        this.transactionHistory = new ArrayList<>();
	    }

	    public void withdraw(double amount) {
	        if (amount <= user.getBalance()) {
	            user.updateBalance(-amount);
	            recordTransaction("Withdrew: Rs." + amount);
	            System.out.println("Withdrawal successful. New balance: Rs." + user.getBalance());
	        } else {
	            System.out.println("Insufficient funds.");
	        }
	    }

	    public void deposit(double amount) {
	        user.updateBalance(amount);
	        recordTransaction("Deposited: Rs." + amount);
	        System.out.println("Deposit successful. New balance: Rs." + user.getBalance());
	    }

	    public void transfer(double amount, String recipientId) {
	        if (amount <= user.getBalance()) {
	            // For simplicity, we will not validate recipientId in this example
	            user.updateBalance(-amount);
	            recordTransaction("Transferred: Rs." + amount + " to " + recipientId);
	            System.out.println("Transfer successful. New balance: Rs." + user.getBalance());
	        } else {
	            System.out.println("Insufficient funds.");
	        }
	    }

	    public void showTransactionHistory() {
	        System.out.println("Transaction History:");
	        for (String transaction : transactionHistory) {
	            System.out.println(transaction);
	        }
	    }

	    private void recordTransaction(String transaction) {
	        transactionHistory.add(transaction);
	    }
	}



