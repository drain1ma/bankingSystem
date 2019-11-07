import java.math.BigDecimal;

public class SavingsAccount extends Account {

	public SavingsAccount(int accountNumber, BigDecimal balance) {
		super(accountNumber, balance);
	}

	/**
	 * Withdraw method allows the amount to be taken out of the account, and is over
	 * drafted once the account reaches a negative number
	 */
	@Override
	public void deposit(BigDecimal amount) {
		super.setBalance(super.getBalance().add(amount));
		System.out.println("");
		System.out.println("SAVINGS ACCOUNT: Balance of " + super.getBalance());
	}
	

	/**
	 * Deposit method allows an amount to be placed into the account balance
	 */
	@Override
	public void withdraw(BigDecimal amount) {

		super.setBalance(super.getBalance().subtract(amount));
		System.out.println("");
		if (super.getBalance().compareTo(BigDecimal.ZERO) < 0) {
			throw new NotEnoughFundsException("Not enough funds"); // throw exception for when the savings account
																		// does not have enough funds
		}
		System.out.println("SAVINGS ACCOUNT: Balance of " + super.getBalance());
	}

	/**
	 * NotEnoughFundsException allows a message to be passed for when there are not
	 * enough funds in certain methods.
	 */
	class NotEnoughFundsException extends RuntimeException {
		public NotEnoughFundsException(String message) {
			super(message);
		}
	}
}