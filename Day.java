//Sarah Walker
//Final Project 
//Day.java
//Version 1
//10 May 2015

public class Day 
{
   /** 
    *This is the array of hours for the day. It is has as many ints as there are classes. 
    */
   private double[] hours;
   
   /** 
    *This is the total number of hours for the day.
    */
   private double total;
   
   /** 
    *This is the constructor for the Day object. 
    *It initializes the hours to be of length classes. 
    *total is initialized to 0. 
    *@param classes the number of classes the student is taking
    */
   public Day(int classes)
   {
      hours = new double[classes];
      total =0;
   }
   
   /**
    *This method adds time to a specific class. 
    *It also updates the total to include that time. 
    *@param classNum the number of the class for which the time is being recorded
    *@param time the amount of hours spent on that class
    */
   public void addTime(int classNum, double time)
   {
      hours[classNum]= time;
      total+=time;
   }
   
   /** 
    *This method returns the array of hours for this day. 
    */
   public double[] getHours()
   {
      return hours;
   }
   
   /** 
    *This method returns the total number of hours for this day.
    *It rounds it to two decimal places. 
    */
   public double getTotal()
   {
      return Math.round(total*100)/100.00;
   }

}