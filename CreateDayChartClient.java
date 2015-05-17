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
import org.jfree.ui.RefineryUtilities; 
public class CreateDayChartClient
{
   public static void main(String [] args)
   {
      String[]classes = {"Math", "English", "Chem", "CS", "History", "Spanish"};
      double[] hours= {1, 2, 0.5, 1, 1.5, 2};
      CategoryDataset dataset = createDataSet(classes, hours);
      BarChart_AWT chart = new BarChart_AWT("Today's Homework Chart", "Hours of Homework per Class",
       dataset, "Hours", "Class");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true );
   }
   
   public static void createDayChart(String[] classes, double[] hours)
   {
      CategoryDataset dataset = createDataSet(classes, hours);
      BarChart_AWT chart = new BarChart_AWT("Today's Homework Chart", "Hours of Homework per Class",
       dataset, "Hours", "Class");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true );
   }
   
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

//based on code from http://www.tutorialspoint.com/jfreechart/jfreechart_bar_chart.htm