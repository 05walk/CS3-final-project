//Sarah Walker
//Final Project
//HomeworkSuveyClient
//10 May 2015

import java.util.*;

public class HomeworkSurveyClient
{
   /** 
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
    *This is the maximum days in a month
    */
   public static final int maxDays = 31; 
   
   /** 
    *This is a string array of the classes the student is taking.
    */
   public static String[] classes;
   
   public static void main(String args[]) 
   {
      intro();
      Scanner input = new Scanner(System.in);
      setup(input);
      addTodaysHours(input);
      addTodaysHours(input);
      //addTodaysHours(input);
      printData();
   }
   
   public static void intro()
   {
      System.out.println("This program helps you track the hours you spend doing homework for each");
      System.out.println("class throughout the course of one month. After inputting the number of ours");
      System.out.println("for that day, you will have the option to display a graph from that day as");
      System.out.println("as well as the data so far from the month. At the end of the month, you will");
      System.out.println("be given the data from the entire month.\n");
   }
   
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
    *This method is used to collect all of the String inputs needed from the user. 
    *@param input the Scanner needed to interact with the user
    *@param prompt the prompt to display to the user
    *@return the String given by the user
    */
   public static String askUserString(Scanner input, String prompt)
   {
      System.out.print(prompt);
      return input.next();//can't accept more than one token, should fix!!!! (nextLine is a problem with int first)
   }
   
   /**
    *This method is used to collect all of the integer inputs needed from the user.
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
       input.next();//if this is input.nextLine(), when you give an int and then a letter, it asks reprompts twice 
                    //before getting an answer
                    //this will break if there is more than one token inputed by the user
       System.out.print(prompt);
      }
      number=input.nextInt();
      if (number<min||number>max){
         System.out.println("Input is not valid, you need to enter a number between " +min +" and "+ max +".");
         }
      if(number>=min&&number<=max){
         return number; 
         }
     }
   }
   
   public static void addTodaysHours(Scanner input)
   {
      int day = askUserInt(input, "What day of the month is it? ", 0, thisMonth.length);
      thisMonth[day]= new Day(classes.length);
      for(int i =0; i<classes.length; i++)
      {
         int time = askUserInt(input, "How many hours did you spend on " + classes[i] + "? ", 0, 12); //can spend max 12 hours
         thisMonth[day].addTime(i, time);
      }
      System.out.println();
   }
   
   public static void printData()
   {
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
