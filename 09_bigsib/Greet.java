//Kevin Li
//APCS
//HW8 -- Write a function called greet that gives a greeting to 3 hardcoded people, and call it in main
//2021-09-30
//DISCOVERIES
//	$cp <filename> <directory name> copies a file from the current directory into the named directory. 
//	The named directory has to be written as if you were decribing a path
//	Ex: ~/Kevin-Li-Pd8_APCS/08_hello_fxn
//UNRESOLVED QUESTIONS
//The instructions say to make a function with the signature: void greet(String) 
//but if we're making a new function, why is it that the only parameter in the parentheses is String, and it doesn't say to give a name
//the parameter makes it seem like that's how the function is called: it requires a string
public class Greet {
	public static void main(String[] args){
		BigSib.greet("Flounder");
		BigSib.greet("Kirby");
		BigSib.greet("Bo");
	}
}
