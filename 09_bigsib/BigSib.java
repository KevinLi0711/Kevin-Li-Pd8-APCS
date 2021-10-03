//Kevin Li and Kirby
//APCS
//HW9 -- Write class BigSib to call it in Greet.java to have the same output as before
//2021-10-03
//DISCOVERIES
//	You can call one class in the file of a different class because Java is a compile language
//  You don't need the main function in a file if the file is not going to be executed
//  Classname.method is how you use a method in another file
//UNRESOLVED QUESTIONS
//  Are you able to use classes from different directories?

public class BigSib{
    public static void greet(String name){
        System.out.println("Why, hello there, " + name + ". How do you do?");
    }
}