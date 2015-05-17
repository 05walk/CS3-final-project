//Sarah Walker
//Final Project 
//Day.java
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
   
   public Day(int classes)
   {
      hours = new double[classes];
      total =0;
   }
   
   public void addTime(int classNum, double time)
   {
      hours[classNum]= time;
      total+=time;
   }
   
   public double[] getHours()
   {
      return hours;
   }
   
   public double getTotal()
   {
      return total;
   }

}