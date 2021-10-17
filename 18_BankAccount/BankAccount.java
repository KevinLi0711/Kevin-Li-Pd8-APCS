//Team KLEH: Kevin Li and Eric He
//APCS
//HW18 -- CPA-One
//2021-10-14
//DISCO:
// - Strings are compared using the == operator. Using = gives an error
// - if you have an instance variable and a parameter of the same name, you can put this. in front of the instance variable to specify
// - When trying to list the accountnumber without having set it beforehand, it returns null. So then a String's default value is null.
//   We thought it'd just return an empty string
//QCC:
// - Is it better to name parameters and instance variables different names, or it it ok to use the same name if it's for better clarity?
//Team KLEH’s Latest and Greatest Q2 Response:
//Team KLEH’s Latest and Greatest Q3 Response:

public class BankAccount{
	private double balance;
	private String accountNumber;
	private String username;
	private String password;
	private String PIN;

    public BankAccount(String username, String password, String PIN, String accountNumber, double balance) {
        setUsername(username);
        setPassword(password);
        setPIN(PIN);
        setAccountNumber(accountNumber);
        setBalance(100);
    }

	public String setUsername(String newUsername){
		username = newUsername;
		return username;
	}

    public String setPassword(String newPassword){
        password = newPassword;
        return password;
    }

    public String setPIN(String fourDigitPIN){
        PIN = fourDigitPIN;
        return PIN;
    }

    public String setAccountNumber(String nineDigitNumber){
        accountNumber = nineDigitNumber;
        return accountNumber;
    }

    public double setBalance(double balance){
        this.balance = balance;
        return balance;
    }

	public void withdraw(double money,String password){
		balance = balance - money;
	}

    public void deposit(double money,String password){
        balance = balance + money;
    }

	public void showAccountInfo(String accountNumber, String username,String password){
		if ( (this.accountNumber == accountNumber) && (this.username == username) && (this.password == password) ) {
			System.out.println("account number: " + accountNumber);
                        System.out.println("PIN: " + PIN);
                        System.out.println("username: " + username);
                        System.out.println("password: " + password);
                        System.out.println("balance: " + balance);
		}
        else System.out.println("Incorrect username or password");
	}

    public static void main(String args[]){
        BankAccount KLEHBank = new BankAccount("KLEH", "duckies", "1234", "000111222", 100);
        KLEHBank.showAccountInfo("000111222", "KLEH", "duckies");
	}
}
