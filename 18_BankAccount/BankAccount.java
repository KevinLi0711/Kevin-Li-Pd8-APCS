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
// - I found this part in the textbook for the summer hw. It is referring to the use of == to compare Strings 
//      This code compiles and runs, and most of the time it gets the answer right. But it is not correct, 
//      and sometimes it gets the answer wrong. The problem is that the == operator checks whether the two 
//      variables refer to the same object (by comparing the references). If you give it two different strings 
//      that contain the same letters, it yields false.
//   We originally used == for comparison in showAccountInfo, but I changed it after reading this. But == was working before, so in what scenario
//   would == return an error for showAccountInfo
//   
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
        if (checkDigits(fourDigitPIN, 4)) {
            PIN = fourDigitPIN;
            return PIN;
        }else return "Invalid PIN";
    }

    public String setAccountNumber(String nineDigitNumber){
        if (checkDigits(nineDigitNumber, 9)) {
            accountNumber = nineDigitNumber;
            return accountNumber;
        }else return "Invalid number";
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

	public void showAccountInfo(String accountNumber, String PIN, String username,String password){
		if ((this.accountNumber == accountNumber) && 
            (this.username == username) && 
            (this.password == password) &&
            (this.PIN == PIN)
            ) {
			    System.out.println("account number: " + this.accountNumber);
                    System.out.println("PIN: " + this.PIN);
                    System.out.println("username: " + this.username);
                    System.out.println("password: " + this.password);
                    System.out.println("balance: " + this.balance);
            } else System.out.println("Incorrect or invalid credentials");
    }

    public static boolean checkDigits(String number, int digits){
        Double doubleNumber = Double.parseDouble(number);
        Double reducedNumber = doubleNumber / (Math.pow(10, digits));
        String format = "%." + digits + "f";
        String formattedNumber = String.format(format, reducedNumber);
        String decimalNumber = "0." + number;
        
        if (decimalNumber.equals(formattedNumber)){
            return true;
        } else return false;
    }

    public static void main(String args[]){
        BankAccount KLEHBank = new BankAccount("KLEH", "duckies", "5234", "000111222", 100);
        KLEHBank.showAccountInfo("000111222", "5234", "KLEH", "duckies");
	}
}
