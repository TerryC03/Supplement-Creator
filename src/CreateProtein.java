import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
import java.util.Random;
public class CreateProtein {
	CreateProtein createProtein = new CreateProtein();
 static Scanner input = new Scanner(System.in); //Used for integers
 static Scanner input2 = new Scanner(System.in); //Used for strings
// Macronutrient Essentials
 
private static final double protein = 4; // kcal per gram
private static final double fats = 9; // kcal per gram
private static final double carbs = 4; // kcal per gram

// Protein Manufacturing Essentials
	static double proteinWeight;
	static String nameOfprotein;

	
	// Ergonomics Lab Codes:
	private static String labCode = "42135";
	private static String labCode_2 = "75881";
	private static String labCode_3 = "81223";
	private static String labCode_4 = "78114";

	
	
	
	
	private static void ergLabcode(){
		// Private 5 digit strings for Authorization Code:
		List<String> labCodes = new LinkedList<String>();
		labCodes.add("42135");
		labCodes.add("75881");
		labCodes.add("81223");
		labCodes.add("78114");
		labCodes.add("87112");
		Random rand = new Random();
		int randNum = rand.nextInt(labCodes.size());
		System.out.println(labCodes.get(randNum));
		System.out.println("Use this 5 digit as authorization from ergonomics lab to continue.");
		proteinWeight();
		// Private 5 digit strings for Authorization Code:
	}
		public static void nameOfprotein(){
			System.out.println("Creating Protein Type: ");
			System.out.println("Name of Protein: ");
			nameOfprotein  = input.nextLine();
			String nameOfproteinCheck = "[a-zA-Z  ]{1,77}";
			Pattern pattern = Pattern.compile(nameOfproteinCheck);
			Matcher patternMatcher = pattern.matcher(nameOfprotein);
			if (!patternMatcher.matches()){
				System.out.println("Incorrect input:\n"
						+ "1) Shorten the name of the protein less than 77 characters;\n"
						+ "2) Only alphabet characters are allowed.");
				nameOfprotein();
	}
		
		}
		
		
			
		public static void proteinWeight(){
	System.out.println("Desired Net Weight of Protein: (in pounds(lbs))  ");
	proteinWeight = input.nextDouble();
	if(proteinWeight == 000){
		ergLabcode();
	}
	else if (proteinWeight > 15){
	System.out.println("Please consult Ergonomics Lab for authorization. If you have consulted Ergonomics Lab\n"
			+ "please enter 5 digit authorization code; press \"q\" to cancel and choose another size.");
	String ergonomics = input.next();
	if (ergonomics.contains(labCode)||ergonomics.contains(labCode_2)||ergonomics.contains(labCode_3)
			||ergonomics.contains(labCode_4)){
		System.out.println("OK. You are now authorized to use the net weight of" + proteinWeight + "lbs.");
	}
	else if (ergonomics.contains("q") || ergonomics.contains("Q")){
		proteinWeight();
	}
		else {
			System.out.println("Incorrect input:\n"
					+ "1) Only a five (5) digit input is allowed; Please consult the Erogonomics Lab for the authorization code.\n"
					+ "2) If you want to cancel and return to weight input; please enter \"q\" now");
			String ergonomics_2 = input.next(); //Second Attempt
			if (ergonomics_2.contains(labCode)||ergonomics_2.contains(labCode_2)||ergonomics_2.contains(labCode_3)
					||ergonomics_2.contains(labCode_4)){
				System.out.println("OK. You are now authorized to use the net weight of" + proteinWeight + "lbs.");
			}
			else if (ergonomics_2.contains("q") || ergonomics_2.contains("Q")){
				proteinWeight();
		}
			else {
			System.out.println("Incorrect input:\n"
				+ "Only a five (5) digit input is allowed; Please consult the Erogonomics Lab for the authorization code.\n"
					+ "Returning to previous option...");
			proteinWeight();
			}
	}
	}
		
	
		
		}
		
		
		public static String[] addIngredients(){
			
			System.out.println("How many ingredients will you add? Enter whole number now:");
			int amount = input.nextInt();
			List<String> addedIngredients = new ArrayList<String>();
			System.out.println("Instructions:\n"
					+ "===========================\n"
					+ "1) First, enter the name of the desired ingredient in the protein, then press \"Enter\"\n"
					+ "2) Complete in this manner for each sequential item.");
			for (int i = 0; i < amount; i++){
			String addIngredients = input2.nextLine();
			addedIngredients.add(addIngredients);
			}
			System.out.println(addedIngredients.size());
			System.out.print(addedIngredients);
			String[] savedIngredients = addedIngredients.toArray(new String[amount]);
			System.out.println(Arrays.toString(savedIngredients));
			System.out.println(": Accept?\n 1 (Yes) / 2 (No)");
			choices(addedIngredients, amount);
			return savedIngredients;
		}
			public static  List<String> choices(List<String> addedIngredients, int amount){
				
			int choiceYes = input.nextInt();
			if (choiceYes == 1){
				System.out.println("Ingredients saved!");
				return addedIngredients;
			}
			else if (choiceYes == 2){
				System.out.println("What would you like to do?\n"
						+ "1) Edit\n"
						+ "2) Clear\n"
						+ "3) Cancel");
				int choiceNo = input.nextInt();
				if (choiceNo == 1){
				editIngredient(addedIngredients, amount);
			}
				else if (choiceNo == 2){
				clearIngredient(addedIngredients);
		}
				else if (choiceNo == 3){
					System.out.println("Canceling...");
					System.out.println("Enter \'1\' to save current ingredients or\n\'2\' for options.");
					choices(addedIngredients, amount);
				}
			}
			return addedIngredients;
				}
				private static List<String> clearIngredient(List<String> addedIngredients) {
					System.out.println("This will delete ALL input of ingredients\nAre you sure?");
					System.out.println("Type \'111\' or \'000\'");
					int clear = input2.nextInt();
					if (clear == 111){
						addedIngredients.clear();
						System.out.println(addedIngredients);
						System.out.println("Cleared.");
					}
					else if (clear == 000){
						System.out.println("Canceling...");
					}
					return addedIngredients;
			
		}
				public static void editIngredient(List<String> addedIngredients, int amount){
				System.out.println("=======\nEditing\n=======");
				System.out.println("Currently, you have " + addedIngredients.size() + " Ingredients:");
				System.out.print(addedIngredients + "\nHow many would you like to edit?");
				int amountEdit = input.nextInt();
					if (amount >= amountEdit){
						do{
							for (int i = 0; i <= amountEdit; i++){
						System.out.println(addedIngredients);
						System.out.println("Type the name of the ingredient of which you want to edit:");
						
						String findIngredient = input.nextLine();
						if (addedIngredients.contains(findIngredient)){
							System.out.println("Enter the new name of the ingredient that you want to use: ");
						String newIngredient = input.next();
						addedIngredients.remove(findIngredient);
						addedIngredients.add(newIngredient);
						}
						}
						} 
						while(amount <= amountEdit);
						System.out.println(addedIngredients);
						System.out.println("Are the new ingredient selection OK?");
						System.out.println("1 (Yes) / 2 (No)");
						choices(addedIngredients, amount);
					}
					
					else if (amountEdit > amount){
						do {
							System.out.println("You requested to edit more items than you initially entered.\n"
									+ "Please lower or equalize the desired number to that of your original formula.");
							editIngredient(addedIngredients, amount);
						}
							while (amountEdit <= amount);
						}
						
				}
}




