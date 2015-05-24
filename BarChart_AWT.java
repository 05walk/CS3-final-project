//Sarah Walker
//Final project 

/**
 *based on code from http://www.tutorialspoint.com/jfreechart/jfreechart_bar_chart.htm
 *I used this tutorial website to learn jFreeChart. I used their code to help me understand it (what
 *is commented out below), and then I kept their constructor but modified it to be more compatible 
 *with my other files. 
 */ 

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; //all of these are needed for creating the chart 

public class BarChart_AWT extends ApplicationFrame
{
   public BarChart_AWT( String applicationTitle , String chartTitle, CategoryDataset dataset,
    String yTitle, String xTitle )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         xTitle,            
         yTitle,            
         dataset,       
         PlotOrientation.VERTICAL, //this means that the scaled axis is the y-axis          
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   //this is their example, but I created my own dataset in my client 
   // private CategoryDataset createDataset( )
//    {
//       final String fiat = "FIAT";        
//       final String audi = "AUDI";        
//       final String ford = "FORD";        
//       final String speed = "Speed";        
//       final String millage = "Millage";        
//       final String userrating = "User Rating";        
//       final String safety = "safety";        
//       final DefaultCategoryDataset dataset = 
//       new DefaultCategoryDataset( );  
// 
//       dataset.addValue( 1.0 , fiat , speed );        
//       dataset.addValue( 3.0 , fiat , userrating );        
//       dataset.addValue( 5.0 , fiat , millage ); 
//       dataset.addValue( 5.0 , fiat , safety );           
// 
//       dataset.addValue( 5.0 , audi , speed );        
//       dataset.addValue( 6.0 , audi , userrating );       
//       dataset.addValue( 10.0 , audi , millage );        
//       dataset.addValue( 4.0 , audi , safety );
// 
//       dataset.addValue( 4.0 , ford , speed );        
//       dataset.addValue( 2.0 , ford , userrating );        
//       dataset.addValue( 3.0 , ford , millage );        
//       dataset.addValue( 6.0 , ford , safety );               
// 
//       return dataset; 
//    }
  //  public static void main( String[ ] args )
//    {
//       // BarChart_AWT chart = new BarChart_AWT("Car Usage Statistics", "Which car do you like?");
// //       chart.pack( );        
// //       RefineryUtilities.centerFrameOnScreen( chart );        
// //       chart.setVisible( true ); 
//    }
}
