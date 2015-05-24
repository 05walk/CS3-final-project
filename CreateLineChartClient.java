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
import org.jfree.ui.RefineryUtilities; //these are all needed to create the charts

/**
 *based on code from http://www.tutorialspoint.com/jfreechart/jfreechart_bar_chart.htm
 *I used this tutorial website to learn jFreeChart. I used their code to help me understand it (what
 *is commented out below), and then I kept their constructor but modified it to be more compatible 
 *with my other files. 
 */ 
 
public class CreateLineChartClient 
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
    *@param month the array of Day objects
    */
   public static void createMonthChart(Day[] month)
   {
      DefaultCategoryDataset dataset = createDataSet(month);
      LineChart_AWT chart = new LineChart_AWT("This Month's Homework Chart", "Hours of Homework per Day",
       dataset, "Class", "Day");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true );
   }
   
   /** 
    *This is a private helper method to create the dataset. 
    *It adds a value to the dataset for each class. 
    *@param month the array of Day objects
    *@return the dataset. 
    */
   private static DefaultCategoryDataset createDataSet(Day[] month)
   {
      final DefaultCategoryDataset dataset=new DefaultCategoryDataset( );
      for(int i =0; i<month.length; i++)
      {
         if (month[i]!=null)
         {
            dataset.addValue(month[i].getTotal(), "month", "Day " + i); //parameters have to be in this order
            // for graph to work 
         }
      }
      return dataset;
   }
   
   /** 
    *This method creates a line chart of the total hours for eahc day during the month
    *It first calls the createDataSet method and then
    *calls the LineChart_AWT class to create the chart. 
    *@param classes the names of the classes.
    *@param hours the array of hours spent doing homework. 
    */
  //  public static void createLineChart(String[] , double total)
//    {
//       CategoryDataset dataset = createDataSet(classes, total);
//       //LineChart_AWT chart = new BarChart_AWT("Today's Homework Chart", "Hours of Homework per Class",
//        dataset, "Hours", "Class");
//       chart.pack( );        
//       RefineryUtilities.centerFrameOnScreen( chart );        
//       chart.setVisible( true );
//    }
   

}
