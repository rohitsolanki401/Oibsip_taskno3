package ATMProject;

public class Users {

	    private String userId;
	    private String pin;
	    private double balance;

	    public Users(String userId, String pin, double balance) {
	        this.userId = userId;
	        this.pin = pin;
	        this.balance = balance;
	    }

	    public boolean validateCredentials(String inputId, String inputPin) {
	        return userId.equals(inputId) && pin.equals(inputPin);
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void updateBalance(double amount) {
	        balance += amount;
	    }

	    public String getUserId() {
	        return userId;
	    }
	}


