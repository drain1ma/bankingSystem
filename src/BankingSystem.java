import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BankingSystem {

	private Map<String, ArrayList<Account>> database = new HashMap<String, ArrayList<Account>>();

	/**
	 * 
	 * @param person  - the person object
	 * @param account - the account object
	 * @return whether the account exists (true) or whether it does not exist
	 *         (false) verifyAccountExists method allows for a person object and an
	 *         account object and compares the accounts within the array list with
	 *         the account that was entered as a parameter to see if it exists.
	 */
	public boolean verifyAccountExists(Person person, Account account) {
		ArrayList<Account> accounts = database.get(person.getLicenseNumber());
		if (accounts != null) {
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getAccountNumber() == (account.getAccountNumber())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param person - the person object
	 * @return the person value addPerson object allows for a person to be added to
	 *         the hashmap
	 */
	public Person addPerson(Person person) {
		if (!database.containsKey(person.getLicenseNumber())) {
			database.put(person.getLicenseNumber(), new ArrayList<Account>());
			return person;
		}
		throw new PersonAlreadyExistsException("The person " + person + " already exists in the system.");
	}

	/**
	 * @param person - the person object
	 * @return the person value removePerson method checks if the person exists, and
	 *         if they do, they are removed from the system
	 */
	public Person removePerson(Person person) {
		if (database.containsKey(person.getLicenseNumber())) {
			database.remove(person.getLicenseNumber());
			return person;
		}
		throw new PersonNotFoundException("The person you were trying to remove was not found within the system.");
	}

	public void openAccount(Person person, Account account) {
		
		try {
			
			if (verifyAccountExists(person, account)) {
				throw new AccountAlreadyExistsException("The account " + account.getAccountNumber() + " already exists.");
			}
			
			database.get(person.getLicenseNumber()).add(account);
			
		} catch (AccountAlreadyExistsException e) {
			
			e.printStackTrace(); 
			
		}
		
	}

	/**
	 * @param person  - the person object
	 * @param account - the account object The closeAccount method takes in a person
	 *                and account, verifies whether it exists or not, and throws an
	 *                AccountDoesNotExistException when an account is not found
	 */
	public void closeAccount(Person person, Account account) {
		try {
			if (!verifyAccountExists(person, account)) {
				throw new AccountDoesNotExistException("The account does not exist."); 
			}
		} catch (AccountDoesNotExistException e) {
			e.printStackTrace(); 
		}
		
		
		if (verifyAccountExists(person, account)) {
			database.remove(person.getLicenseNumber()); 
		}
	}

	/**
	 * PersonNotFoundException allows input for when a person is not found
	 */
	class PersonNotFoundException extends RuntimeException {
		public PersonNotFoundException(String message) {
			super(message);
		}
	}

	/**
	 * AccountAlreadyExistsException allows input for when an account already exists
	 */
	class AccountAlreadyExistsException extends RuntimeException {
		public AccountAlreadyExistsException(String message) {
			super(message);
		}
	}

	/**
	 * PersonAlreadyExistsException allows input for when a person already exists
	 */
	class PersonAlreadyExistsException extends RuntimeException {
		public PersonAlreadyExistsException(String message) {
			super(message);
		}
	}

	/**
	 * AccountDoesNotExistException allows input for when an account does not exists
	 */
	class AccountDoesNotExistException extends RuntimeException {
		public AccountDoesNotExistException(String message) {
			super(message);
		}
	}
}