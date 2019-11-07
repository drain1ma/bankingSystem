import java.math.BigDecimal;

public class CheckingAccount extends Account {

	public CheckingAccount(int accountNumber, BigDecimal balance) {
		super(accountNumber, balance);
	}

	/**
	 * Withdraw method allows the amount to be taken out of the account, and is over
	 * drafted once the account reaches a negative number
	 */
	@Override
	public void withdraw(BigDecimal amount) {
		super.setBalance(super.getBalance().subtract(amount));
		System.out.println("");
		if (super.getBalance().compareTo(BigDecimal.ZERO) < 0) {
			System.out.println("The account was over drafted");
		}
		System.out.println("CHECKING ACCOUNT: Balance of " + super.getBalance());

	}

	/**
	 * Deposit method allows an amount to be placed into the account balance
	 */
	@Override
	public void deposit(BigDecimal amount) {
		super.setBalance(super.getBalance().add(amount));
		System.out.println("");
		if (super.getBalance().compareTo(BigDecimal.ZERO) < 0) {
			System.out.println("Account Accepted");
		}
		System.out.println("CHECKING ACCOUNT: Balance of " + super.getBalance());

	}


}