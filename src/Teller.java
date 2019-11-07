import java.math.BigDecimal;

public class Teller {

	private Person person;
	private BankingSystem bankingSystem;

	/**
	 * @param firstName     - allows for the teller's first name
	 * @param lastName      - allows for the teller's last name
	 * @param licenseNumber - allows for the teller's license number the constructor
	 * 
	 *                      Allows for the creation of another person, which is the
	 *                      teller, as well as creates a new banking system upon
	 *                      creation
	 */
	public Teller(String firstName, String lastName, String licenseNumber) {
		this.person = new Person(firstName, lastName, licenseNumber);
		this.bankingSystem = new BankingSystem();
	}

	/**
	 * @param person  - the person object
	 * @param account - the account object
	 * @param amount  - the amount to be withdrawn
	 * 
	 *                The withdraw method allows the teller to withdraw money from
	 *                the account by checking whether the account exists or not
	 */
	public void withdraw(Person person, Account account, BigDecimal amount) {
		if (bankingSystem.verifyAccountExists(person, account) == false) {
			throw new AccountDoesNotExistException("The person " + person.getFirstName() + " with account "
					+ account.getAccountNumber() + " does not exist.");
		}
		account.withdraw(amount);
	}

	/**
	 * @param person  - the person object
	 * @param account - the account object
	 * @param amount  - the amount to be deposited
	 * 
	 *                The deposit class allows for the teller to deposit money into
	 *                the account by checking if the account exists or not
	 */
	public void deposit(Person person, Account account, BigDecimal amount) {
		if (bankingSystem.verifyAccountExists(person, account) == false) {
			throw new AccountDoesNotExistException("The person " + person.getFirstName() + " with account "
					+ account.getAccountNumber() + " does not exist.");
		}
		account.deposit(amount);
	}

	/**
	 * @param person - the person object
	 * @return the person value
	 * 
	 *         The addUser method allows the teller to add a person by calling to
	 *         the banking system's addPerson method
	 */
	public Person addUser(Person person) {
		bankingSystem.addPerson(person);
		return person;
	}

	/**
	 * @param person - the person object
	 * @return the person value
	 * 
	 *         The removeUser method allows the teller to remove a user by calling
	 *         to the removePerson method in the banking system
	 */
	public Person removeUser(Person person) {
		bankingSystem.removePerson(person);
		return person;
	}

	/**
	 * @param person  - the person object
	 * @param account - the account object
	 * 
	 *                The openAccount method allows the teller to open an account by
	 *                calling to the openAccount method in the banking system
	 */
	public void openAccount(Person person, Account account) {
		bankingSystem.openAccount(person, account);
	}

	/**
	 * @param person  - the person object
	 * @param account - the account object
	 * 
	 *                The closeAccount method allows the teller to close an account
	 *                by calling to the closeAccount method in the banking system
	 */
	public void closeAccount(Person person, Account account) {
		bankingSystem.closeAccount(person, account);
	}

	public Person getPerson() {
		return person;
	}

	/**
	 * AccountDoesNotExistException allows a message input for when an account is
	 * not found
	 */
	class AccountDoesNotExistException extends RuntimeException {
		public AccountDoesNotExistException(String message) {
			super(message);
		}
	}

}