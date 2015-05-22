//Sarah Walker
//createRandomData.java
//CS3 Final project
//Version 1
//21 May 2015

import java.util.*; //needed for the random object
import java.io.*; //needed to create the output file


public class createRandomData
{
   /** 
    *This is the number of days of data being created. 
    */
   public static final int DAYS = 31; 
   
   /** 
    *This is the number of classes the student is taking. 
    */
   public static final int CLASSES = 6; 
   
   /** 
    *This is an outline of the program. 
    *It makes a Random object and and printStream object and then
    *writes the random data to a file. 
    *@param args not used for this program. 
    */
   public static void main(String[] args)
   {
      Random r = new Random();
      PrintStream out=createOutputFile("output.txt");
      writeToFile(r, out);
      
   }
   
   /**
    *This method creates the Printstream on the output file. 
    *It uses a try/catch statement to make sure it is possible to put the prinstream on the file. 
    *@param filename the name of the output file 
    *@return the Prinstream object
    */
   private static PrintStream createOutputFile(String filename)
   {
   File f=new File(filename);
      PrintStream fileScan = null;
      try
      {
         fileScan = new PrintStream(f);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Error opening file " + filename);
         return null;
      }
      return fileScan;
   }
   
   /** 
    *This method writes randomly generated data to the file. 
    *@param r the Random object
    *@param output the Prinstream object needed to write to the file. 
    */
   private static void writeToFile(Random r, PrintStream output)
   {
      output.println("6");
      output.println("Math English Chem CS History Spanish");
      output.println("31");
      for (int i = 0; i<DAYS; i++)
      {
         String line="";
         for (int j=0; j<CLASSES; j++)
         {
            line += Math.round(r.nextDouble()*100)/20.00 + " ";
         }
         output.println(line);
      }
   }

}  