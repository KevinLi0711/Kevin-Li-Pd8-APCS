import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/*
Team Suspicious Oranges: Kevin Li, Hamim Seam, Weichen Liu
APCS
Lab 6 -- College Board Consumer Review Lab
2022-02-13
time spent: 2 hours
*/

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        //System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  public static double totalSentiment( String fileName ) {
  	String file = textToString(fileName);
  	int endIndex = 0;
    double total = 0;
    String word;
  	
  	while (file.length() > 0) {
        endIndex = file.indexOf(" ");

        if (endIndex == -1) {
            word = removePunctuation(file);
            total = total + sentimentVal(word);
            break;
        }

        word = file.substring(0, endIndex);
        word = removePunctuation(word);
        total = total + sentimentVal(word);
        file = file.substring(endIndex + 1);

  	}
  	
  	return total;
  }

  public static int starRating(String filename) {
      double sentiment = totalSentiment(filename);
      sentiment = sentiment / 3;
      
      if ((int)sentiment <= 0) {
          return 1;
      } else
      if ((int)sentiment > 5) {
        return 5;
      } else
      return (int)sentiment;
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }
  
    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
  
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
  
  public static String fakeReview(String input) {
  	String file = textToString(input);
    String output = "";
    String word;
    
    //find asterick
  	int startIndex = file.indexOf("*");

    while (startIndex != -1) {
        //add all text up to asterick
        output = output + file.substring(0, startIndex);

        //cut the string up to and including the asterick
  	    file = file.substring(startIndex + 1);
        startIndex = file.indexOf(" ");

        //add a random adjective
        if (startIndex != -1) {
            word = file.substring(0, startIndex);
        } else {
            word = file;
        }

        if (sentimentVal(word) <= 0) {
            output = output + randomPositiveAdj();
        } else {
            output = output + removePunctuation(word);
        }

        //adds existing punctuation
        if (startIndex != -1) {
            if (!Character.isAlphabetic(file.charAt(startIndex - 1))) {
                output = output + file.charAt(startIndex - 1);
            }
            output = output + " ";
        } else {
            output = output + getPunctuation(file);
        }

        //cut the word after the asterick
        file = file.substring(startIndex + 1);
        startIndex = file.indexOf("*");
    }

    return output;
  }
  
  public static void main(String[] args) {
  	System.out.println(sentimentVal("academy"));
  	System.out.println(sentimentVal("painful"));
  	System.out.println(sentimentVal("smart"));
    System.out.println(totalSentiment("SimpleReview.txt"));
    System.out.println(starRating("SimpleReview.txt"));
    System.out.println(fakeReview("SimpleReview.txt"));
  }
}
