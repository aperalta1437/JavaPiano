import java.util.Random;         // To import the Random class and get access to it.
import java.util.Set;            // To import the Set interface and get access to it.
import java.util.HashSet;        // To import the HashSet class and get access to it.
import java.util.List;           // To import the List interface and get access to it.
import java.util.Arrays;         // To import the Arrays class and get access to it.
import java.util.ArrayList;      // To import the ArrayList class and get access to it.
/**
 * <b>AngelPeraltaNote.java</b>
 * <p>
 * <h1>AngelPeraltaNote</h1>
 * The AngelPeraltaNote program implements several aplications that help identify keys 
 * characteristics in an 88-keys piano keyboard.
 * <p>
 * @author Angel Peralta
 * @since 25SEP2018 20:11 EST.
 */
public class AngelPeraltaNote    // Class definition.
{
   // Declaring instance variables.
   private double[][] value_Hertz = new double[2][88];               // Creating a two-D array object to hold the keys values and Hertz.
   private String[][] letter_Color_Length = new String[3][88];       // Creating a two-D array object to hold the keys letter name, color, and length.
   private int value;                                                // To hold the pressed key value number.
   private ArrayList<Integer> numbers = new ArrayList<> ();          // Creating an ArrayList of integers objects to hold the keys numbers corresponding to the piano keyboard keys.
   private Set<Integer> set = new HashSet<Integer> ();               // Creating a Set object to hold HashSet of integers. 
   private List<Integer> list = Arrays.asList ( 1, 4, 6, 9, 11, 13, 16, 18, 21, 23, 25, 28, 30,    /* Creating a List of integers objects to hold the numbers */
                                                33, 35, 37, 40, 42, 45, 47, 49, 52, 54, 57, 59,    /* corresponding to the Sharp keys.                        */
                                                61, 64, 66, 69, 71, 73, 76, 78, 81, 83, 85 );       
   private Set<Integer> set2 = new HashSet <Integer> ();                            // Creating a Set object to hold HashSet of integers.
   private List<Integer> list2 = Arrays.asList ( 10, 22, 34, 46, 58, 70, 82 );      // Creating a List of integers objects to hold the numbers corresponding to the G's keys.      
   private List<String> length = Arrays.asList ( "Sixteenth note", "Eight note", "Quarter note", "Half note", "Whole note" ); /* Creating a List of String objects to hold */
   private Random rand = new Random ();         // Creating a Random object to generate random numbers.                       /* the possible lengths of the keys.         */
   
   /**
    * The costructor of the AngelPeraltaNote class to create the keys numbers that will 
    * be used to identify the keys on the piano keyboard.
    */                                             
   public AngelPeraltaNote ()
   {
      // The for loop to assign the numbers that will be used to identify the keys. 
      for ( int index = 1; index <= 88; index ++ )
      {
         numbers.add ( index );   
      } 
   }
   /**
    * The assigningValues method to assign the corresponding values to their corresponding keys.
    * @return Nothing.
    */
   public void assigningValues ()
   {
      double number = -48.0;        // To hold the first key number value.
      
      // The for loop to assign values to their corresponding keys.
      for ( int index = 0; index < value_Hertz[0].length; index ++ )
      {
         value_Hertz[0][index] = number;
         number ++;        // Increasing the number value by one per for-loop iteration.
      }
   }
   /**
    * The assigningHertz method to assign the hertz quantity that corresponds to the 
    * each note on the piano keyboard based on the given value. 
    * @return Nothing.
    */
   public void assigningHertz ()
   {  
      // The for loop to assign a hertz quantity to the corresponding piano key number.
      for ( int index = 0; index < value_Hertz[1].length; index ++ )
      {
         value_Hertz[1][index] = 440.0 * Math.pow ( 2.0, ( value_Hertz[0][index] / 12.0 ) );
      }
   }
   /**
    * The assigningLetter method to assign the corresponding note's letter name to
    * its corresponding piano key.
    * @return Nothing.
    */
   public void assigningLetter ()
   {   
      set2.addAll ( list2 );        // Assigning the values in list2 to set2.
      int number = 65;              // To hold the number that corresponds to the letter "A".
      int number2 = 0;              // To hold the octave number.
      
      // The for loop to assign the corresponding note's letter.
      for ( int index = 0; index < letter_Color_Length[0].length; index ++ )
      {
         // The if-statement to assign Empty to the Sharp(black) keys.
         if ( set.contains ( index ) )
         {
            letter_Color_Length[0][index] = "Empty";
         }
         else
         {
            letter_Color_Length[0][index] = Character.toString ( ( char ) number ) + Integer.toString ( number2 );
            number ++; 
         }
         if ( letter_Color_Length[0][index].equals ( "B" + Integer.toString ( number2 ) ) )
         {
            number2 ++;             // Increasing the number of octave by one.
         }
         
         // The if-statement to reset the letter number each time it gets to letter "G".
         if ( set2.contains ( index ) )
         {
            number = 65;
         }
      }
      // The for loop to assign the Sharp's keys letter name.
      for ( int index = 0; index < letter_Color_Length[0].length; index ++ )
      {
         if ( set.contains ( index ) )
         {
            letter_Color_Length[0][index] = 
                  letter_Color_Length[0][index - 1] + "#(" + letter_Color_Length[0][index - 1] +
                  "-Sharp) or " + letter_Color_Length[0][index + 1] + "b(" + letter_Color_Length[0][index + 1] + "-Flat)"; 
         }
      }
   }
   /**
    * The assigningColor method to assign the key type or color to each of their corresponding keys.
    * @return Nothing.
    */
   public void assigningColor ()
   {
      set.addAll ( list );
              
      for ( int index = 0; index < letter_Color_Length[1].length; index ++ )
      {
         letter_Color_Length[1][index] = "Natural(White)";
         
         if ( set.contains ( index ) )
         {
            letter_Color_Length[1][index] = "Sharp(Black)";
         }
      }
   }
   /**
    * The assigningLength method assigns a length to each key on the piano keyboard.
    * @return Nothing.
    */
   public void assigningLength ()
   {
      for ( int index = 0; index < letter_Color_Length[2].length; index ++ )
      {
         // Assigning a random key length to each key on the piano keyboard.
         letter_Color_Length[2][index] = length.get ( rand.nextInt ( 5 ) );   
      }
   }
   /**
    * The getHertz method to get hertz amount based on the pressed key's number.
    * @param keyNumber The pressed key's number.
    * @return The hertz quantity that corresponds to the pressed key's number. 
    */
   public double getHertz ( int keyNumber )
   {
      return value_Hertz[1][keyNumber];
   }
   /**
    * The setValue method to set the key's value with the value of the key that was pressed.
    * @param value The value that corresponding to the key that was pressed.
    * @return Nothing.
    */
   public void setValue ( int value )
   {
      this.value = value;
   }
   /**
    * The getValue method to get the value of the key that was just pressed.
    * @return The value of the key that was just pressed.
    */
   public double getValue ()
   {
      return value;
   }
   /**
    * The printNoteInfo to print the program's data out on the screen.
    * @return Nothing.
    */
   public void printNoteInfo ()
   {
      System.out.printf ( "Note's letter name:\t\t\t\t\t%s%nNote's key type or color:  \t\t%s%n" +
                          "Note's frequency:  \t\t\t\t\t%,.2f hertz.%nNote's length:\t\t\t\t\t\t\t%s%n%n", 
                          letter_Color_Length[0][numbers.indexOf ( value )], letter_Color_Length[1][numbers.indexOf ( value )], 
                          value_Hertz[1][numbers.indexOf ( value )], letter_Color_Length[2][numbers.indexOf ( value )] );
   }
}