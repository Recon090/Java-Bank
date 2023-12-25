public class Account {
	private double balance;
	private String userName;
	private String password;


	
	public Account(String userName, String password, double balance) {
		this.userName=userName;
		this.password=password;
		this.balance=balance;
	}
	
	public String getPassword() {
		return this.password;
	}
	public String getUserName() {
		return this.userName;
	}
	public double getBalance() {
		return this.balance;
	}
	
	void setPassword(String password) {
		this.password=password;
	}
	void setUserName(String userName) {
		this.userName=userName;
	}
	
	void setBalance(double balance) {
		this.balance=balance;
	}
	
	@Override
	public String toString() {
		return "\nUser name: " + this.getUserName() +
				" \nPassword: " + this.getPassword() +
				" \nbalance: " + this.getBalance();
	}
}
