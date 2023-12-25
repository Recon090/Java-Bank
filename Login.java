import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Login {
	private double recentTrans;
	private ArrayList<String> feeType=new ArrayList<String>();
	private double fees;
	Scanner scanUser = new Scanner(System.in);
	private double balance;
	
	public void enterPass(Account acc){
		if(acc.getUserName().equals("Pawel1029") && acc.getPassword().equals("misterPawel")) {
			balance=acc.getBalance();
			loginOption();
		}
		else {
			System.out.println();
			String name = JOptionPane.showInputDialog("Incorrect User Info, please reenter"+ "\nLogin in by entering your name");
			String password = JOptionPane.showInputDialog("Enter your password");
			acc.setPassword(password);
			acc.setUserName(name);
			enterPass(acc);
		}
	}

	
	public void loginOption(){
		int option= Integer.parseInt(JOptionPane.showInputDialog("Please select an option" + "\n1: Make a Deposit"+
				"\n2: Make a withdrawal" + 
				"\n3: View recent transactions"+ 
				"\n4: View balance"+
				"\n5: View fees"));

		if(option==1) {
			deposit();
			goAgain();
			 
		}
		if(option==2) {
			withdraw();
			goAgain();

			  
		}
		if(option==3) {
			viewTrans();
			goAgain();

			  
		}
		if(option==4) {
			balance();
			goAgain();
  
		}
		if(option==5) {
			viewFees();
			goAgain();
		}
	}
	
	public boolean goAgain() {
		System.out.println("");//creates spacing between previous request
		System.out.println("Would you like to do anything else");//request users for what they want to do next
				System.out.println("Yes or no?");
				Scanner scanUser= new Scanner(System.in);
		String option = scanUser.nextLine().toLowerCase(); //takes in user Input as a string and prints it out
System.out.println(option); //prints out said input
		if(option.equals("yes")) {
			loginOption();
			return false;
		}
		else if(option.equals("no")) {
			System.out.println("Have a good day");
			return true;
		}
		else {
			System.out.println("Please enter a valid input");
			goAgain();
			return false;
		}
	}
	
	public void withdraw() {
		System.out.println("How much would you like to withdraw?");
		double amount=scanUser.nextDouble();
		balance-=amount;
		recentTrans=0-amount;
		System.out.println(amount+ " has been withdrawed");
		System.out.println("Your new balance is " + String.format("%.2f",balance));
		if(balance<0) {
			System.out.println("You have incurred an overdraft fee of 30 dollars");
			fees+=30;
			balance-=30;
			feeType.add("Overdraft fee");
		}
		
}
	
	
	public void deposit() {
		System.out.println("How much would you like to deposit?");
		double amount=scanUser.nextDouble();
		balance+=amount;
		recentTrans=0+amount;
		System.out.println(amount+ " has been deposited");
		System.out.println("Your new balance is " + String.format("%.2f",balance));
	}

	public void viewFees() {
		System.out.println("Here are your total fees amount: " + fees);
		System.out.println("Here is a list of what the fees are for:");
		for(int i=0;i<feeType.size();i++) {
			System.out.println((i+1) + ". " + feeType.get(i));
		}
	}
	
	public void viewTrans() {
		if(recentTrans>0) {
			System.out.println(recentTrans + " was deposited.");
		}
		else {
			System.out.println(Math.abs(recentTrans)+ " was withdrawed");
		}
	}
	
	public void balance(){
		System.out.println("Your balance is: " + String.format("%.2f",balance-fees));
	}

	
}
