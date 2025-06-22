import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;

//this class has the information regarding food details and nutrients including calories, fiber, protein (implemented later)
class FoodInfo {
	
	//define private variables for the food including name and calories
    private String name;
    private int calories;

    //constructor to create FoodInfo objects
    public FoodInfo(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    
    
    //getter for the name of food
    public String getName() {
        return name;
    }

    
    //getter for the calories of the food
    public int getCalories() {
        return calories;
    }

    //toString method to display the name of the food and the amount of calories the food holds
    @Override
    public String toString() {
        return name + " (" + calories + " calories)";
    }
}



//this class has information about each food item the user inputs
public class FoodItem {
	

	public static void main(String[] args) {
		//call the method to do the meal swapping calculations
        mealSwapCalculation();
    }

	//define the method to do the meal swap calculation
    public static void mealSwapCalculation() {
    	
    	//create a JFrame Window titled Meal Swapping Calculator
        JFrame frame = new JFrame("Meal Swapping Calculator");
        
        //when the user clicks on the x button to close the window, close the entire application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set the size of the window to be 600 by 600
        frame.setSize(600, 600);
        
        //divide the JFrame container into 5 different sections: North, East, South, West, Center
        frame.setLayout(new BorderLayout());

        //create meal object
        Meal meals = new Meal();
        
        //create broccoli object of type FoodInfo that has 34 calories
        FoodInfo broccoli = new FoodInfo("Apples", 52);
        
        //create chicken object of type FoodInfo that has 239 calories
        FoodInfo chicken = new FoodInfo("Chicken", 239);
        
        //add broccoli to the meals
        meals.addItem(broccoli);
        
        //add chicken to the meals
        meals.addItem(chicken);

        
        //display the broccoli and chicken information including its calories
        JTextArea mealsTextArea = new JTextArea(meals.getMealDescription());
        //set background color to pink
        mealsTextArea.setBackground(Color.pink);
        
        //create an empty border with top size 20, bottom size 10, left size 20 and right size 10
        mealsTextArea.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        //make sure user isn't able to change and edit the meals
        mealsTextArea.setEditable(false);
        

        //Display the total calories of both food items
        JLabel LabelCalories = new JLabel("Total Calories: " + meals.getTotalCalories());
        
        //horizontally align the LabelCalories to be in the center
        LabelCalories.setHorizontalAlignment(SwingConstants.CENTER);
        
        //vertically align the LabelCalories to be in the center
        LabelCalories.setVerticalAlignment(SwingConstants.CENTER);
        
        //create an empty border with top size 20, bottom size 10, left size 20 and right size 10
        LabelCalories.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        //let the background be opague to show color
        LabelCalories.setOpaque(true);
        //set background color to pink
        LabelCalories.setBackground(Color.pink);
        

        //create temporary swap options for food items 
        String[] swapFoodOptions = {"Rice (130 calories)", "Beef (250 calories)", "Carrots (41 calories)"};
        
        //create a drop down menu of the food items the user can swap their own food with. 
        //They can select 1 item from the drop down list
        JComboBox<String> swapDropDownMenu = new JComboBox<>(swapFoodOptions);
        
        
        //Create a button for swapping the food
        JButton swapButton = new JButton("Swap");

        //when the user clicks the swap button, swap the first food item with the selected food item the user chooses
        swapButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		
        		//gets the users selected food item
                String select = (String) swapDropDownMenu.getSelectedItem();
                
                //define a new FoodItem variable
                FoodInfo newFoodItem;
    
                //check which food the user selected and assign it to the new FoodItem variable
                if (select.startsWith("Rice")) {
                	newFoodItem = new FoodInfo("Rice", 130);
                } else if (select.startsWith("Beef")) {
                	newFoodItem = new FoodInfo("Beef", 250);
                } else {
                	newFoodItem = new FoodInfo("Carrots", 41);
                }

                //replace the first food item with the new food item the user selected
                meals.replaceItem("Apples", newFoodItem);
                //update the text area to show the new food items and their respective calories 
                mealsTextArea.setText(meals.getMealDescription());
                
                //calculate the new total of calories all the foods contain
                LabelCalories.setText("Total Calories: " + meals.getTotalCalories());
            }
        });

        //create another container to make the drop down menu panel and add other components including the JButton and JComboBox
        JPanel controlFoodPanel = new JPanel();
        
        //create a text label to guide the user what their replacing the food item with
        controlFoodPanel.add(new JLabel("Replace Food Apples with:"));
        //set background color to pink
        controlFoodPanel.setBackground(Color.PINK);
        
        //add the swapping drop down menu to the food panel component/container
        controlFoodPanel.add(swapDropDownMenu);
        
        //add the swap button to the food panel component/container
        controlFoodPanel.add(swapButton);

        //add all components together on the JFrame window
        //add the JTextArea where the meals and their calories are in the center of the frame/window
        frame.add(mealsTextArea, BorderLayout.CENTER);
 
        //add the JPanel where the user chooses to swap their food at the top of the frame/window
        frame.add(controlFoodPanel, BorderLayout.NORTH);
        
        //add the JPanel where the total calories are displayed at the right side of the frame/window
        frame.add(LabelCalories, BorderLayout.EAST);
        //allow the window to be visible to the user 
        frame.setVisible(true);
    }
}
