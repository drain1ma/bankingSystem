
import java.math.BigDecimal;

abstract class Account {
	private int accountNumber;
	private BigDecimal balance;

	/**
	 * @param accountNumber - account number of the person's account
	 * @param balance       - the balance of the person's account
	 */
	public Account(int accountNumber, BigDecimal balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	/**
	 * @param amount - allows for an amount that will go into the balance
	 */
	public abstract void deposit(BigDecimal amount);

	/**
	 * @param amount - the amount that will be taken out of the balance
	 */
	public abstract void withdraw(BigDecimal amount);

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}