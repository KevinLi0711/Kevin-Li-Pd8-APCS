import java.util.Scanner;

public class CtF{
	public static void main(String[] args){
		double Celsius;
		double Fahrenheit;
		Scanner scanner = new Scanner(System.in);

		System.out.println("How many degrees celsius?");
		Celsius = scanner.nextDouble();
		scanner.nextLine();
		Fahrenheit = Celsius * 9 / 5 + 32;
		System.out.printf("%.1f Celsius = %.1f Fahrenheit", Celsius, Fahrenheit);
		
	}
}