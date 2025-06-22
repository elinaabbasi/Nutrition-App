import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Meal {
  
	String date;//Date of the meal
	String type;//Type of the meal
	double calories; 
	
	Map<String, Double> ingredients;//Ingredients of the meal
	
	//Creates an object meal
	public Meal(String date, String type, Map<String, Double> ingredients, double calories) {
	   this.date = date;
	   this.type = type;
	   this.ingredients = ingredients;
	   this.calories = calories;
	}
	
	public Meal() {
	
	}
	
   
	

	//sample userprofile
	private static UserProfile user = new UserProfile("Bobby", "Male", "1992-06-25", 173, 82, "Metric");
   
	public static void main(String[] args) {
   	
		//create a JFrame window titled Log Meal
       JFrame frame = new JFrame("Log Meal");
       
       //set the size of the window to be 400 by 250
       frame.setSize(400, 250);
       
       //set the layout to be 5 rows and 2 columns
       frame.setLayout(new GridLayout(5, 2));
       
       //create a text field for user to enter the date of their meal
       JTextField dateTextField = new JTextField();
       
       //create a drop down menu for choosing what type of meal it is
       JComboBox<String> mealType = new JComboBox<>(new String[]{"Breakfast", "Lunch", "Dinner", "Snack"});
       //create a text field for user to enter ingredients
       JTextField FoodItemTextField = new JTextField();
       JTextField caloriesField = new JTextField();
       //create button titled Log Meal
       JButton saveBtn = new JButton("Log Meal");
       
       frame.add(new JLabel("Date (YYYY-MM-DD):"));
       frame.add(dateTextField);
       
       frame.add(new JLabel("Meal Type (Breakfast, Lunch, Dinner, Snack):"));
       frame.add(mealType);
       frame.add(new JLabel("Food Item (name:quantity,name:quantity):"));
       frame.add(FoodItemTextField);
       frame.add(new JLabel(""));
       frame.add(saveBtn);
       
       //when the user clicks to save their meal, it should save the meal 
       saveBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Map<String, Double>  ingredients = new HashMap<>();//Storing the ingredients
               //Entering the data as :"food:quantity"
               //Separating each set of food and amount by a comma
               String[] foodsAndQuantities = FoodItemTextField.getText().split(",");
               for (String foodAndQuantity : foodsAndQuantities) {
            	   //split each item by a colon to get the name and the quantity
                   String[] parts = foodAndQuantity.split(":");
                   
                   //get the name of the food
                   String name = parts[0].trim();
                   //get the quantity of the food
                   double amount = Double.parseDouble(parts[1].trim());
                   
                   ingredients.put(name, amount); //put the name and the amount of the food in the ingredients Map
               }
               
              //The date of the meal
               String date = dateTextField.getText();
               //the type of the meal
               String type = (String) mealType.getSelectedItem();
               // Create a new Meal object
               double calories = Double.parseDouble(caloriesField.getText());
               Meal meal = new Meal(date, type, ingredients, calories);
               // Add meal to the user's list
               user.getMeals().add(meal);
               //End of operation
               //show user if their meal was logged
               JOptionPane.showMessageDialog(frame, "Meal logged successfully!");
           }
       });
       frame.setVisible(true);
   }
	
	 //Array that holds the Food info of ingredients
	   private ArrayList<FoodInfo> foodItems = new ArrayList<>();
	   
	  	//Adds the food item to the foodItems list
	   public void addItem(FoodInfo item) {
	   	foodItems.add(item);
	   }
	   
	  	//Replaces the food item in a meal
	   public void replaceItem(String Name, FoodInfo newItem) {
	       for (int i = 0; i < foodItems.size(); i++) {
	           if (foodItems.get(i).getName().equalsIgnoreCase(Name)) {
	           	foodItems.set(i, newItem);
	               break;
	           }
	       }
	   }
	   
	  	//Calculates and returns the total calorie of the meal
	   public int getTotalCalories() {
	       int TC = 0;
	       for (FoodInfo item : foodItems) {
	           TC += item.getCalories();
	       }
	       return TC;
	   }
	   
	   //Prints the description of the meal entered
	   public String getMealDescription() {
	       String info = "";
	       for (FoodInfo item : foodItems) {
	           info += item.toString() + "\n";
	       }
	       return info;
	   }
	
}