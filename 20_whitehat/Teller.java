/*
KLEH: Eric He and Kevin Li
APCS
HW20: External Audit
2021-10-19
QCC: 
DISCO: 
    - We withdrew a negative amount to increase the balance in p4
    - We set the balance to a negative number in p3
    - After depositing a double value in ba, the number of digits in the decimals increased from 2 to 12 and there was .000000000001 more dollars in there than we deposited so we may have caused a rounding error
    - We were able to copy the account info of ba into p6 because the mutator methods return the previous value of the instance variables
A good Q: What operations are possible from BankAccount’s main() method but not Teller’s?
*/

public class Teller{
	public static void main(String args[]){
		//Test
		BankAccount ba = new BankAccount();
    		ba.setName("A");
    		ba.setPassword("pass123");
    		ba.setPin(1111);
    		ba.setAccountNumber(123456789);
    		ba.setBalance(10000.11);
    		System.out.println(ba.toString());
    		ba.deposit(900.10);
    		System.out.println(ba.toString());
    		ba.withdraw(2000.90);
    		System.out.println(ba.toString());
		
		//Break
		BankAccount p1 = new BankAccount();
		p1.setName("p1");
		p1.setPin(999);
		p1.setAccountNumber(123456789);
		p1.setBalance(100);
		System.out.println(p1.toString());
		
		BankAccount p2 = new BankAccount();
		p2.setName("p2");
		p2.setPin(1111);
		p2.setAccountNumber(1111111111);
		p2.setBalance(100);
		System.out.println(p2.toString());
		
		BankAccount p3 = new BankAccount();
		p3.setName("p3");
		p3.setPin(1111);
		p3.setAccountNumber(123456789);
		p3.setBalance(-100);
		System.out.println(p3.toString());
		
		BankAccount p4 = new BankAccount();
		p4.setName("p4");
		p4.setPin(1111);
		p4.setAccountNumber(123456789);
		p4.setBalance(100);
		p4.withdraw(-100);
		System.out.println(p4.toString());
		
		BankAccount p5 = new BankAccount();
		p5.setName("p5");
		p5.setPin(1111);
		p5.setAccountNumber(123456789);
		p5.setBalance(100);
		p5.withdraw(200);
		System.out.println(p5.toString());

        BankAccount p6 = new BankAccount();
        p6.setName(ba.setName("abcd"));
        p6.setPin(ba.setPin(0000));
        p6.setPassword(ba.setPassword("abcd"));
        p6.setAccountNumber(ba.setAccountNumber(0));
        p6.setBalance(ba.setBalance(-100));
        System.out.println(p6.toString());
        System.out.println(ba.authenticate(ba.setAccountNumber(0), ba.setPassword("abcd")));
    }		
}