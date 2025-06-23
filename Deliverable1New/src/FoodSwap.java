import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//Use of AI: Used AI to get a better understand of Java Swing classes and operations.

public class FoodSwap {
	//create a profile for a random user
    private static UserProfile user = new UserProfile("Emily", "Female", "2004-12-12", 120, 66, "Metric");

    public static void main(String[] args) {
        
    	//create a meal for the user with examples of food items
        Map<String, Double> exampleFood = new HashMap<>();
        //add rice as a food item with 100.0g
        exampleFood.put("Rice", 100.0);
        //add chicken as a food item with 150.0g
        exampleFood.put("Chicken", 150.0);
        //create an object for meal that gets added to the user's meal
        user.getMeals().add(new Meal("2025-06-21", "Dinner", exampleFood, 500));

        JFrame frame = new JFrame("Swap Food Item"); //make a window with the title "Swap Food Item"
        frame.setSize(400, 300); //set the size for the application
        frame.setLayout(new GridLayout(6, 2)); //create the grid layout with 6 rows and 2 columns

        //create the dropdown menu for showing the meals
        JComboBox<String> mealList = new JComboBox<>();
        //add items to populate the dropdown box with meals, include their date and type
        for (Meal m : user.getMeals()) {
            mealList.addItem(m.date + " - " + m.type);
        }

        //create a field for the swap
        JTextField oldFoodItem = new JTextField(); //this has the input for the food item to swap
        JTextField newFoodItem = new JTextField(); //this has the input for the new food item
        JTextField newAmount = new JTextField(); //this has the amount of the new food item
        JButton swapBtn = new JButton("Swap"); //name of the button for the action to occur

        //the fields for food item swapping
        frame.add(new JLabel("Select Meal:")); 
        frame.add(mealList); //input row for the meal to be swapped
        
        frame.add(new JLabel("Old Food Item:")); 
        frame.add(oldFoodItem); //input row for the old food item
        
        frame.add(new JLabel("New Food Item:")); 
        frame.add(newFoodItem); //input row for the new food item
        
        frame.add(new JLabel("New Amount in Grams:")); 
        frame.add(newAmount); //input row for the amount of the new food item
        
        frame.add(new JLabel("")); 
        frame.add(swapBtn); //row for the button
        

        swapBtn.addActionListener(new ActionListener() { //add an action listener to handle the food item replacement
        	@Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected meal from the list
                int mark = mealList.getSelectedIndex(); //get the index of the meal that has been selected
                Meal selected = user.getMeals().get(mark); 

                // read the values from the old and new input and the amount
                String old = oldFoodItem.getText().trim(); //food item that will be swapped
                String newIng = newFoodItem.getText().trim(); //food item that is new
                double amt = Double.parseDouble(newAmount.getText().trim());//input of the new amount

         
                //does the selected meal have the old food item
                if (selected.ingredients.containsKey(old)) {
                	//remove the old food item
                    selected.ingredients.remove(old);
                    //add the new food item with the given amount
                    selected.ingredients.put(newIng, amt);
                    //show that the swap has worked
                    JOptionPane.showMessageDialog(frame, "Food item swapped successfully!");
                } else {
                    // give a pop up if the food item does not exist
                    JOptionPane.showMessageDialog(frame, "Food item not found in meal.");
                }
            }
        });

        //make the frame visible for the user
        frame.setVisible(true);
    }
}
