import java.nio.file.Path;
import java.io.*;
import java.util.*;

/**
 * Write a Java complete class that accepts a word from the user as a potential password,
 * and then tells the user if it is a good password by checking it a few different ways
 * described below.
 * 
 * @author Gage Poling
 * @version 11/11/2021
 */
public class PassCheck
{
    // instance variables
    static ArrayList<String> dictionary = new ArrayList<String>();
    static boolean backwards;
    static boolean unique;
    static boolean reflected;
    /**
     * Constructor for objects of class PassCheck
     */
    public PassCheck()
    {
        // initialise instance variables
        
    }

    /**
     * This is the main function- should be able to run from the Command line.
     */
    public static void main(String[] args)
    {
        readFile();
        checkBadPass(inputPassword());
        
    }
    
    /**
     * This method reads a text file and creates an ArrayList with all the words in the file
     * and then prints out the file read-time in nanoseconds using nanoTime().
     * 
     * (10 points) Copy the attached file (the dictionary or the lexicon) down to your
     * computer and read it in as input to an ArrayList implementation as part of your class.
     * It is set up with one word per line. Use the System.nanoTime() method as shown in class
     * and in Section 3.2.1 of the book to calculate how long it takes to read the file
     * completely into the ArrayList and print that value out.
     * 
     * @throws UncheckedIOException if the filepath is incorrect for some reason
     * 
     */
    public static void readFile()
    {
        try (Scanner readFile = new Scanner(Path.of("C:/Users/Gage/Desktop/bluej code/wordlist70k.txt"))){ // NOTE: I no longer have the wordlist
            long startTime = System.nanoTime();
            while (readFile.hasNextLine()){
                dictionary.add(readFile.nextLine());
            }
            long endTime = System.nanoTime();
            System.out.println("File read-time: " + (endTime - startTime) + " nanoseconds.");
        }
        catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
    
    /**
     * This method counts how many words are in the ArrayList and responds to the user.
     * 
     * (5 points) Include a method for returning how many words are currently in the
     * dictionary, with an appropriate response to the user.
     * 
     * @return size of the dictionary ArrayList
     */
    public int getWordCount()
    {
        System.out.println("There are " + dictionary.size() + " words in the password dictionary.");
        return dictionary.size();
    }
    
    /**
     * This method adds a new word to the dictionary, but only if the word isn't already there.
     * 
     * (5 points) Include a method for adding a word to the dictionary, but only if the word
     * is not already in it.
     */
    public void addUniqueWord(String newWord)
    {
        if(dictionary.contains(newWord))
        {
            System.out.println("'" + newWord + "' is already in the dictionary.");
        }
        else
        {
            dictionary.add(newWord);
        }
    }
    
    /**
     * This takes a user input and returns the input.
     * 
     * @return the password the user inputs
     */
    public static String inputPassword()
    {
        Scanner passCheck = new Scanner(System.in);
        System.out.println("Enter password: ");
        String password = passCheck.nextLine();
        return password;
    }
    
     /**
     * (10 points) Compare a user-entered password against the dictionary of "bad" passwords.
     * These passwords are considered bad since they are actually IN the dictionary, and
     * therefore easily guessable. Again, use the nanoTime() method to calculate how long it
     * takes to search the list for a given word.
     */
    public static void checkBadPass(String password)
    {
        checkBackwardsPass(password);
        checkUniquePass(password);
        checkMirrorPass(password);
        if (backwards == true || unique == false || reflected == true)
        {
            System.out.println("Sorry!");
            if (backwards == true)
            {
                System.out.println("This password is just a backwards word.");
            }
            if (unique == false)
            {
                System.out.println("This password isn't unique.");
            }
            if (reflected == true)
            {
                System.out.println("This password is just mirroring itself.");
            }
            System.out.println("Pick something stronger!");
            checkBadPass(inputPassword());
        }
        else
        {
            System.out.println("This password is good!");
        }
    }
    
    /**
     * Checks if the password is the inverse of an existng word in the list or not.
     * 
     * (5 points) Check for the inverse of the dictionary words (i.e. "rosseforp" instead
     * of "professor").
     * 
     * @return whether the password is backwards or not
     */
    public static boolean checkBackwardsPass(String password)
    {
        String backpass = "";
        for (int i = 0; i < password.length(); i++)
        {
            char letter = password.charAt(i);
            backpass = letter + backpass;
        }
        if (dictionary.contains(backpass))
        {
            backwards = true;
            return backwards;
        }
        else
        {
            backwards = false;
            return backwards;
        }
    }
    
    /**
     * Checks if the password is unique compared to the list or not.
     * 
     * @return whether the password is unique or not
     */
    public static boolean checkUniquePass(String password)
    {
        if (dictionary.contains(password))
        {
            unique = false;
            return unique;
        }
        else
        {
            unique = true;
            return unique;
        }
    }
    
    /**
     * Checks if the password is a mirrored password.
     * 
     * (5 points) Check for the reflections of dictionary words, where the dictionary word
     * is first, followed immediately by the reverse of the word (i.e. "doggod")
     * 
     * @return whether the password is mirrored or not
     */
    public static boolean checkMirrorPass(String password)
    {
         String mirror = "";
         for (int i = 0; i < (password.length()/2); i++)
         {
             char letter = password.charAt(i);
             mirror = mirror + letter;
         }
         if (dictionary.contains(mirror))
         {
             reflected = true;
             return reflected;
         }
         else
         {
             reflected = false;
             return reflected;
         }
    }
}
