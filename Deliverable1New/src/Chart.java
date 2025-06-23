import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.*;

//Use of AI: Used AI to debug code and understand how to generate a bar chart using JFreeChart
//Used AI to understand classes and operations from JFreeChart to improve our visualization

public class Chart {
	
	//create a profile for a random user
    private static UserProfile user = new UserProfile("Elina", "Female", "2005-03-29", 163, 52, "Metric");

    
    public static void main(String[] args) {
        
    	//add meals to the users profile with example data including the date of the meal, the type of meal, food item, the grams and the calories
        user.getMeals().add(new Meal("2025-06-10", "Breakfast", Map.of("Rice", 52.3), 130));
        user.getMeals().add(new Meal("2025-04-12", "Lunch", Map.of("Ravioli", 93.5), 77));
        user.getMeals().add(new Meal("2025-05-21", "Dinner", Map.of("Shrimp", 111.1), 99));

        //create a bar chart using the DefaultCategoryDataset class, where the rows represent the calories and the columns represent the date 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //go through the user profiles meal to get the details of their meal including the calories, date and type 
        for (Meal m : user.getMeals()) {
            dataset.addValue(m.calories, "Calories", m.type + " (" + m.date + ")");
        }

        
        /* create a bar chart and title it "Calories in Meal"
         * the x-axis represents meal and is called "Meal"
         * the y-axis represents the calories and is called "Calories"
         * the dataset is used to create the bar chart
         */
        JFreeChart chart = ChartFactory.createBarChart("Calories in Meal", "Meal", "Calories", dataset);

        
        //display the bar chart to show on the screen/window
        ChartPanel chartPanel = new ChartPanel(chart);

        //create a JFrame Window titled "Calorie Bar Chart"
        JFrame frame = new JFrame("Calorie Bar Chart");
        //when the user clicks on the x button to close the window, close the entire application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the window size to be 600 by 400
        frame.setSize(600, 400);
        //add the chart panel to the frame
        frame.add(chartPanel);
        //allow the window to be visible to the user
        frame.setVisible(true);
    }
}
