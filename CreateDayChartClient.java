//Sarah Walker
//CreateDayChartClient.java
//Final project
//17 May 2015

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; //these are all needed to create the bar chart

/**
 *based on code from http://www.tutorialspoint.com/jfreechart/jfreechart_bar_chart.htm
 *I used this tutorial website to learn jFreeChart. I used their code to help me understand it (what
 *is commented out below), and then I kept their constructor but modified it to be more compatible 
 *with my other files. 
 */ 
 
public class CreateDayChartClient 
{
      /** 
       *This main method is just used for unit testing. 
       *@param args not used for this program. 
       */
//    public static void main(String [] args)
//    {
//       String[]classes = {"Math", "English", "Chem", "CS", "History", "Spanish"};
//       double[] hours= {1, 2, 0.5, 1, 1.5, 2};
//       CategoryDataset dataset = createDataSet(classes, hours);
//       BarChart_AWT chart = new BarChart_AWT("Today's Homework Chart", "Hours of Homework per Class",
//        dataset, "Hours", "Class");
//       chart.pack( );        
//       RefineryUtilities.centerFrameOnScreen( chart );        
//       chart.setVisible( true );
//    }
   
   /** 
    *This method creates a bar chart of the hours spent this day doing homework. 
    *It first calls the createDataSet method and then
    *calls the BarChart_AWT class to create the chart. 
    *@param classes the names of the classes.
    *@param hours the array of hours spent doing homework. 
    */
   public static void createDayChart(String[] classes, double[] hours)
   {
      CategoryDataset dataset = createDataSet(classes, hours);
      BarChart_AWT chart = new BarChart_AWT("Today's Homework Chart", "Hours of Homework per Class",
       dataset, "Hours", "Class");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true );
   }
   
   /** 
    *This is a private helper method to create the dataset. 
    *It adds a value to the dataset for each class. 
    *@param classes the names of the classes the student is taking. 
    *@param hours the array of hours spent on homework that day
    *@return the dataset. 
    */
   private static CategoryDataset createDataSet(String[] classes, double[] hours)
   {
      final DefaultCategoryDataset dataset=new DefaultCategoryDataset( );
      for(int i =0; i<classes.length; i++)
      {
         dataset.addValue(hours[i], classes[i], "class");
      }
      return dataset;
   }

}
