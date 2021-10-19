public class BankAccount {

    //instance variables
    private String name;
    private String passwd;
    private short pin;
    private int acctNum;
    private double balance;
    //---------------------------------------------
  
  
    //mutators
    public String setName( String newName ) {
      String oldName = name;
      name = newName;
      return oldName;
    }
  
    public String setPasswd( String newPasswd ) {
      String oldPasswd = passwd;
      passwd = newPasswd;
      return oldPasswd;
    }
  
    public short setPin( short newPin ) {
      short oldPin = pin;
      if ( (newPin >= 1000) && (newPin <= 9998) ){
        pin = newPin;
      } 
      else {
          pin = 9999;
          System.out.println("Invalid PIN number for account " + name + ": PIN number must be a 4 digit number between 1000 and 9998, inclusive.");
      }
      return oldPin;
    }
  
    public int setAcctNum( int newAcctNum ) {
      int oldAcctNum = acctNum;
      if ( (newAcctNum >= 100000000) && (newAcctNum <= 999999998) ){
          acctNum = newAcctNum;
      } 
      else {
          acctNum = 999999999;
          System.out.println("Invalid account number for account " + name + ": account number must be a 9 digit number between 100000000 and 999999998, inclusive.");
      }
      return oldAcctNum;
    }
  
    public double setBalance( double newBalance ) {
      double oldBalance = balance;
      balance = newBalance;
      return oldBalance;
    }
    //---------------------------------------------
  
  
    public void deposit( double depositAmount ) {
      balance = balance + depositAmount;
      System.out.println("$" + depositAmount + " was deposited in account " + name);
    }
  
    public boolean withdraw( double withdrawAmount ) {
        if (withdrawAmount > balance){
            System.out.println("Failed to withdraw " + "$" + withdrawAmount + ": insufficient funds in account " + name);
            return false;
        }
        else {
            balance = balance - withdrawAmount;
            System.out.println("$" + withdrawAmount + " was withdrawn from account " + name);
            return true;
        }
    }
  
  
    //overwritten toString()
    public String toString() {
      String retStr = "\nAccount info:\n=======================";
      retStr = retStr + "\nName: " + name;
      retStr = retStr + "\nPassword: " + passwd;
      retStr = retStr + "\nPIN: " + pin;
      retStr = retStr + "\nAccount Number: " + acctNum;
      retStr = retStr + "\nBalance: " + balance;
      retStr = retStr + "\n=======================";
      return retStr;
    }

    public boolean authenticate(String username, String password){
        if ( ( username.equals(name) ) && ( password.equals(passwd) ) ) {
            System.out.println("Valid username and password");
            return true;
        }
        else {
            System.out.println("Invalid username or password");
            return false;
        }
    }
  
    //main method for testing
    public static void main( String[] args ) {
        BankAccount ba = new BankAccount();
        ba.setName("ba");
        ba.setPasswd("password");
        ba.setPin((short) 1234);
        ba.setAcctNum(123456789);
        ba.setBalance(500);
        ba.deposit(200);
        ba.withdraw(100);
        String accInfoBa = ba.toString();
        System.out.println(accInfoBa);
        ba.authenticate("ba", "password");

        BankAccount ma = new BankAccount();
        ma.setName("ma");
        ma.setPasswd("password");
        ma.setPin((short) 12345);
        ma.setAcctNum(1234567890);
        ma.setBalance(500);
        ma.deposit(200);
        ma.withdraw(800);
        String accInfoMa = ma.toString();
        System.out.println(accInfoMa);
        ma.authenticate("not ma", "not password");
    }//end main()
  
  }//end class BankAccount