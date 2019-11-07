import java.math.BigDecimal;

/**
 * @author drain1ma Matthew Drain Professor Ripke March 19, 2019
 */

public class Main {

	public static void main(String[] args) {
		// Test 1
		Person person = new Person("Matt", "Drain", "28491");
		Teller teller = new Teller("Teller", "Something", "236545");

		// Test 2
		teller.addUser(person);

		// Test 3
		// teller.addUser(person);

		// Test 4
		CheckingAccount checkingAccount = new CheckingAccount(12, BigDecimal.valueOf(100));

		teller.openAccount(person, checkingAccount);

		// Test 5
		// teller.openAccount(person, checkingAccount);

		// Test 6
		SavingsAccount savingsAccount = new SavingsAccount(13, BigDecimal.valueOf(50));
		teller.openAccount(person, savingsAccount);

		// Test 7
		teller.withdraw(person, checkingAccount, BigDecimal.valueOf(50)); 
		teller.withdraw(person, checkingAccount, BigDecimal.valueOf(75));
		//Test 8
		teller.deposit(person, checkingAccount, BigDecimal.valueOf(50));

		//Test 9
		teller.withdraw(person, savingsAccount, BigDecimal.valueOf(50));
	
		// teller.withdraw(person, savingsAccount, BigDecimal.valueOf(50));


	}

}