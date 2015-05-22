//Sarah Walker

import java.util.*;
import java.io.*;

public class createRandomData
{
   public static final int DAYS = 31; 
   
   public static final int CLASSES = 6; 
   
   public static void main(String[] args)
   {
      Random r = new Random();
      PrintStream out=createOutputFile("output4.txt");
      writeToFile(r, out);
      
   }
   
   /**
    */
   public static PrintStream createOutputFile(String filename)
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
   
   private static void writeToFile(Random r, PrintStream output)
   {
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