import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UserProfile {
	
	
	private String name;
	private String sex;
	private String dateOfBirth;
	private double height;
	private double weight;
	private String unit;

	//an ArrayList that stores Meal objects
	private ArrayList<Meal> meals = new ArrayList<>();
	
	//Constructor for creating UserProfile object
	public UserProfile(String name, String sex, String dateOfBirth, double height, double weight, String unit) {
		   this.setName(name);
		   this.setSex(sex);
		   this.setdateOfBirth(dateOfBirth);
		   this.setHeight(height);
		   this.setWeight(weight);
		   this.setUnit(unit);
		 
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getdateOfBirth() {
		return dateOfBirth;
	}
	public void setdateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public ArrayList<Meal> getMeals() {
		return meals;
	}
	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}
	
	//define a static Map to map a string (name of user) to a UserProfile object 
	private static Map<String, UserProfile> profiles = new HashMap<>();
	
	//define static variable currentProfile to hold the currently active user profile
    private static UserProfile currentProfile;


	//Main method - GUI Setup
    public static void main(String[] args) {
        JFrame frame = new JFrame("Create Profile");
        
        //set frame size to 400 by 300
        frame.setSize(400, 300);
        
        //when the user clicks on the button to close the window, the application should close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //create the grid layout with 7 rows and 2 columns
        frame.setLayout(new GridLayout(7, 2));


		//Create input fields for user data entry 
        JTextField nameField = new JTextField();
        JTextField sexField = new JTextField();
        JTextField dateOfBirthField = new JTextField();
        JTextField heightField = new JTextField();
        JTextField weightField = new JTextField();
        
       //create a dropdown menu for unit selection
        JComboBox<String> unitBox = new JComboBox<>(new String[]{"Metric", "Imperial"});
        
        JButton createBtn = new JButton("Create");

		//Add labels and input fields to the frame in pairs, creating a form layout
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Sex:"));
        frame.add(sexField);
        frame.add(new JLabel("Date of Birth: (YYYY-MM-DD)"));
        frame.add(dateOfBirthField);
        frame.add(new JLabel("Height:"));
        frame.add(heightField);
        frame.add(new JLabel("Weight:"));
        frame.add(weightField);
        frame.add(new JLabel("Unit:"));
        frame.add(unitBox);
        frame.add(new JLabel(""));
        frame.add(createBtn);

		//Handling the button click event by collecting all input values, and creating a 
		//new UserProfile object, storing it in the HashMap, and showing a confirmation message
        createBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            	// Get input values from the text fields and combo box
                String name = nameField.getText();
                String sex = sexField.getText();
                String dob = dateOfBirthField.getText();
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());
                String unit = (String) unitBox.getSelectedItem();

                // Create a new user profile with the input values
                currentProfile = new UserProfile(name, sex, dob, height, weight, unit);

                // Save the profile using the name as the key
                profiles.put(name, currentProfile);

                // Show a message to confirm the profile was created
                JOptionPane.showMessageDialog(frame, "Profile created for: " + name);
            }
        });

        // Show the window
        frame.setVisible(true);

    }
	
}