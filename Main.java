import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to the Bank of Pawel");
		String name = JOptionPane.showInputDialog("Login in by entering your name");
		String password = JOptionPane.showInputDialog("Enter your password");
		Account myAccount = new Account(name,password,2000.00);
		Login L=new Login();
		
		L.enterPass(myAccount);
	}

}
