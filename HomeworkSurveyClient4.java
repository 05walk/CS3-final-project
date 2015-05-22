//Sarah Walker
//Final Project
//HomeworkSuveyClient
//Version 4
//10 May 2015

import java.util.*; 
import java.io.*;

public class HomeworkSurveyClient4
{
   /**
    *This is an array of Days for the month.  
    */
   public static Day[] thisMonth;
   
   /** 
    *This is the maximum number of classes a student can take. 
    */
   public static final int maxClasses=8;
   
   /** 
    *This is the minimum days in a month (February)
    */
   public static final int minDays = 28;
   
   /** 
    *This is the maximum days in a month.
    */
   public static final int maxDays = 31; 
   
   /** 
    *This is a string array of the classes the student is taking.
    */
   public static String[] classes;
   
   /** 
    *This is the outline of the program. 
    *It calls the intro which gives a brief overview of the program.
    *It creates a scanner to be used to interact with the user throughout the program. 
    *It then sets the program up for the month. 
    *The hours are added once a day. 
    *@param args not used for this program 
    */
   public static void main(String args[]) 
   {
      intro();
      Scanner input = new Scanner(System.in);
      Scanner fileScan=openFile("output4.txt");
      setup(input);
      if (fileScan!=null)
      {
         for (int i =0; i<thisMonth.length; i++)
         {
            addTodaysHours(i, fileScan);
         }
      }
      CreateLineChartClient.createMonthChart(thisMonth);
   }
   
   /** 
    *This is the intro to the program. 
    */
   public static void intro()
   {
      System.out.println("This program helps you track the hours you spend doing homework for each");
      System.out.println("class throughout the course of one month. After inputting the number of hours");
      System.out.println("for that day, you will have the option to display a graph from that day as");
      System.out.println("as well as the data so far from the month. At the end of the month, you will");
      System.out.println("be given the data from the entire month.\n");
   }
   
   /** 
    *This method sets up the program by asking the user for how many classes they are taking
    *and the names of those classes. 
    *It also asks for the amount of days in this month 
    *and initializes the array of days to be that size.
    *@param input the Scanner needed to interact with the user
    */
   public static void setup(Scanner input)
   {
      int numClasses = askUserInt(input, "How many classes are you taking? ", 0, maxClasses);
      classes= new String[numClasses];
      for (int i=1; i<=numClasses; i++)
      {
         classes[i-1]= askUserString(input, "Class " + i +" name? ");
      }
      System.out.println();
      int daysInMonth = askUserInt(input, "How many days are in this month? ", minDays, maxDays); 
      thisMonth = new Day[daysInMonth];     
      System.out.println();
   }
   
   /** 
    *This method opens the file and creates a Scanner on that file.
    *@param filename the file that is being opened
    *@return the Scanner on the file.
    */
   public static Scanner openFile(String filename)
   {
   File f=new File(filename);
      Scanner fileScan= null;
      try
      {
         fileScan = new Scanner(f);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Error opening file " + filename);
         return null;
      }
      return fileScan;
   }
   
   /**
    *This method reads the file and, if there is information on that name, returns that info.
    *It scans the entire file until it finds the name requested or it reaches the end of the file. 
    *It also prints out the name if it is found. 
    *@param fileScan the Scanner on the file
    *@param name the name the user wants information about
    *@return the information on the line following the name (or null if no info)
    */
   public static String readFile(Scanner fileScan)
   {
      if (fileScan.hasNextLine())
      {
         String line = fileScan.nextLine();
         return line;
      }
      return null;
   }

   

   
   /**
    *This method is used to collect all of the String inputs needed from the user. 
    *@param input the Scanner needed to interact with the user
    *@param prompt the prompt to display to the user
    *@return the String given by the user
    */
   public static String askUserString(Scanner input, String prompt)
   {
      System.out.print(prompt);
      return input.nextLine();//can't accept more than one token, should fix!!!! (nextLine is a problem with int first)
   }
   
   /**
    *This method is used to collect all of the integer inputs needed from the user.
    *It checks to make sure that before it returns the user has inputed an double 
    *within the appropriate range. 
    *@param input the Scanner needed to interact with the user
    *@param prompt the prompt to display to the user
    *@param min the minimum double that can be accepted
    *@param max the max double that can be accepted 
    *@return the double given by the user
    */
   public static double askUserDouble(Scanner input, String prompt,int min, int max)
   {
   while (true) 
      {
      System.out.print(prompt);
      double number =0; 
      while(!input.hasNextDouble())
      {
       System.out.println("Input is not valid, you need to enter a number.");
       input.nextLine();
       System.out.print(prompt);
      }
      number=input.nextDouble();
      input.nextLine();
      if (number<min||number>max){//will this still work? 
         System.out.println("Input is not valid, you need to enter a number between " +min +" and "+ max +".");
         }
      if(number>=min&&number<=max){
         return number; 
         }
     }
   }
   
   /**
    *This method is used to collect all of the double inputs needed from the user.
    *It checks to make sure that before it returns the user has inputed an integer 
    *within the appropriate range. 
    *@param input the Scanner needed to interact with the user
    *@param prompt the prompt to display to the user
    *@param min the minimum int that can be accepted
    *@param max the max int that can be accepted 
    *@return the integer given by the user
    */
   public static int askUserInt(Scanner input, String prompt,int min, int max)
   {
   while (true) 
      {
      System.out.print(prompt);
      int number =0; 
      while(!input.hasNextInt())
      {
       System.out.println("Input is not valid, you need to enter a number.");
       input.nextLine();//if this is input.nextLine(), when you give an int and then a letter, it asks reprompts twice 
                    //before getting an answer
                    //this will break if there is more than one token inputed by the user
       System.out.print(prompt);
      }
      number=input.nextInt();
      input.nextLine();
      if (number<min||number>max){
         System.out.println("Input is not valid, you need to enter a number between " +min +" and "+ max +".");
         }
      if(number>=min&&number<=max){
         return number; 
         }
     }
   }

   /** 
    *This method adds the hours for the current day. 
    *It asks the user what day it is and then how many hours they spent on each class. 
    *It then calls the askAboutTodaysChart method. 
    *If it is the end of the month, it will call the printData method. 
    *@param input the Scanner needed to interact with the user.
    */
   public static void addTodaysHours(int day,Scanner fileScan)
   {
      //int day = askUserInt(input, "What day of the month is it? ", 0, thisMonth.length);
      thisMonth[day]= new Day(classes.length);
      String line = readFile(fileScan);
      Scanner lineScan = new Scanner(line);
      int x =0; 
      while (lineScan.hasNextDouble())
      {
         double time = lineScan.nextDouble();
         thisMonth[day].addTime(x, time);
         x++;
      }
         //double time = askUserDouble(input, "How many hours did you spend on " + classes[i] + "? ", 0, 12); //can spend max 12 hours
      System.out.println();
      //askAboutTodaysChart(input,thisMonth[day-1].getHours());
      if((day+1)==thisMonth.length)
      {
         printData();
      }
      
   }
   
  /** 
   *This method asks the user if they want to see a chart for today's homework.  
   *If they do, then it calls the playGame method. 
   *@param input the Scanner needed to interact with the user
   *@param hours the array of hours from that day 
   */   
  public static void askAboutTodaysChart (Scanner input, double[] hours)
   {
      String answer= askUserString(input, "Would you like to see a graph of today's hours (yes/no)? ");
      if(answer.startsWith("y")||answer.startsWith("Y"))
      {
        CreateDayChartClient.createDayChart(classes, hours);
      }
   }
  
  /** 
   *This method prints the data from the entire month. 
   */ 
  public static void printData()
   {
      System.out.println("Here is the homework data from this month");
      for(int i = 0; i<thisMonth.length; i++)
      {
         if(thisMonth[i]!=null)
         {
            double[] time = thisMonth[i].getHours();
            for (int j = 0; j<classes.length; j++)
            {
               System.out.println(classes[j] + ": " + time[j] + " hours");
            }
            System.out.println("Total homework time: " + thisMonth[i].getTotal());
            System.out.println();
         }
      }
   }


}
