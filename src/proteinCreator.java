import java.util.Scanner;
public class proteinCreator {
	proteinCreator proteinCreator = new proteinCreator();
	private static double kg = .001; //Used for g --> kg conversion
	private static double mg = 1000; //Used for g --> mg conversion
//--Macronutrients--
	private static double protein = 4; //Grams per kcal
	private static double carbs = 4; //Grams per kcal
	private static double fats = 9; //Grams per kcal
//--Cost of Carbs/Protein--
	private static double costOfprotein = 0.55; //cost per gram
	private static double costOfcarbs = 0.07; // cost per gram
	private static double costOffats = 0.03;
//--EAA's--
	private static double isoleucine = 0.20; //Percentages
	private static double leucine = .10;
	private static double valine = .10;
//--BCAA's--
	private static double alanine = .04;
	private static double arginine = .05;
	private static double asparticAcid = 0.15;
	private static double cystine = .03;
	private static double histidine = .03;
	private static double lysine = .04;
	private static double methionine = .04;
	private static double phenylalanine = .01;
	private static double proline = .05;
	private static double serine = .05;
	private static double threonine = .04;
	private static double tryptophan = .04;
	private static double tyrosine = .03;
//--Servings Per Container--
	private static int fivePoundcontainer = 70;
	private static int tenPoundcontainer = 142;
	private static int fifteenPoundbag = 211;
	
	
	static Scanner input = new Scanner(System.in);
	
	public static int containerSize(){
		System.out.println("What size container do you want?\n5lb. (2.27kg)\n10lb. (4.54kg)\n15lb. (6.81kg)\n(Please enter in lbs:)");
		int containerSize = input.nextInt();
		if (containerSize == 5 || containerSize == 10 || containerSize == 15){
		System.out.println("OK!");
		}
		else {
			do{
				System.out.print("Incorrect input. Please enter, in lbs., 5, 10, or 15:");
				containerSize = input.nextInt();
			}
			while (containerSize != 5 && containerSize != 10 && containerSize != 15);
		}
		System.out.println("OK!");
		if (containerSize == 5){
			System.out.println("The serving size amount will be " + fivePoundcontainer);
		}
		else if (containerSize == 10){
		System.out.println("The serving size amount will be " + tenPoundcontainer);
	}
		
	else if (containerSize == 15){
		System.out.println("The serving size amount will be " + fifteenPoundbag);
	}
		return containerSize;
	}

	public static double protein(){
		System.out.println("You're now calculating the total calories of the product per scoop:");
		System.out.println("How many grams of protein do you want to use?");
		double gramsOfprotein = input.nextDouble();
		return gramsOfprotein;
	}
	public static void AAP(double gramsOfprotein){
		System.out.println("OK");
		System.out.println("This will be the typical Amino Acid profile of the supplement:");
		
		System.out.println("================================================================");
		
		System.out.println(" ");
		System.out.println("Isoleucine: " + isoleucine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Leucine: " + leucine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Valine: " + valine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Alanine: " + alanine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Arginine: " + arginine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Aspartic Acid " + asparticAcid * (gramsOfprotein*mg) + "mgs");
		System.out.println("Cystine: " + cystine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Histidine: " + histidine  * (gramsOfprotein*mg) + "mgs");
		System.out.println("Lysine: " + lysine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Methionine: " + methionine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Phenylalanine: " + phenylalanine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Proline: " + proline * (gramsOfprotein*mg) + "mgs");
		System.out.println("Serine: " + serine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Threonine: " + threonine * (gramsOfprotein*mg) + "mgs");
		System.out.println("Tryptophan: " + tryptophan * (gramsOfprotein*mg) + "mgs");
		System.out.println("Tyrosine: " + tyrosine * (gramsOfprotein*mg) + "mgs");
		System.out.println(" ");
		
		System.out.println("================================================================\n");
		System.out.println("This is the desired Amino Acid layout within Terry Labs LLC.\n"
				+ "Please consult the Nutritional Science R&D with any questions/concerns.");
		System.out.println("");
	}
		
	public static double carbohydrates(){ 
		System.out.println("How many grams of carbohydrates do you want to use?");
		double gramsOfcarbs = input.nextDouble();
		if (gramsOfcarbs > 5){
			do {
			System.out.println("You asked for " + gramsOfcarbs + " grams of carbohydrates.\n"
					+ "This exceeds the type of supplement product(s) you are trying to create.\n"
					+ "Please reduce the amount of grams of carbohydrates you want to use BELOW 5g:");
			 gramsOfcarbs = input.nextDouble();
		}
			while (gramsOfcarbs > 5);
		}
		System.out.println("OK!");
		return gramsOfcarbs;
	}
	public static int fiber(double gramsOfcarbs) {
		System.out.println("Pertaining to carbohydrates, how much of that is:\n"
				+ "--Dietary Fiber:");
		int fiber = input.nextInt();
		if (fiber > gramsOfcarbs){
				do{
				System.out.println("The requested amount of fiber, " + fiber + " is greater than\n"
						+ "the amount of carbohydrates, " + gramsOfcarbs + ". Please reduce the\n"
						+ "amount of fiber LOWER THAN the amount of carbohydrates.");
		fiber = input.nextInt();
				}
				while (fiber > gramsOfcarbs);
		}
		return fiber;
	}
		public static int insolubleFiber (double gramsOfcarbs, int fiber){
		System.out.println("--Insoluble Fiber:");
		int insolubleFiber = input.nextInt();
		if (insolubleFiber > gramsOfcarbs){
			do{
			System.out.println("The requested amount of Insoluble Fiber, " + insolubleFiber + "is greater than\n"
					+ "the amount of carbohydrates, " + gramsOfcarbs + ". Please reduce the\n"
					+ "amount of fiber LOWER THAN the amount of carbohydrates.");
	insolubleFiber = input.nextInt();
			}
			while (insolubleFiber > gramsOfcarbs);
			}
		else if (insolubleFiber + fiber > gramsOfcarbs){
			do{
				System.out.println("The requested amount of Insoluble Fiber, " + insolubleFiber + ", and\n"
					+ "soluble fiber, " + fiber + ", is greater than\n"
					+ "the amount of carbohydrates, " + gramsOfcarbs + ". Please reduce the\n"
					+ "amount of fiber LOWER THAN the amount of carbohydrates.");
		insolubleFiber = input.nextInt();
				}
				while (insolubleFiber > gramsOfcarbs);
		}
	System.out.println("OK!");
	return insolubleFiber;
	}
		public static double sugar(){
		System.out.println("--Sugars:");
		double sugars = input.nextDouble();
		if (sugars > 2){
			do {
			System.out.println("This is a Protein Dietary supplement; quality protein doesn't\n"
					+ "require over 3 grams. Our manufacturer is \"Terry Labs LLC.\",\n"
					+ "this is strictly prohibited!");
			System.out.println("Please input another value less than 2 grams:");
			sugars = input.nextDouble();
			}
			while (sugars > 2);
		}
		System.out.println("OK!");
		return sugars;
}
		public static int fat(){
		System.out.println("How many grams of fat do you want to use?");
		int gramsOffat = input.nextInt();
		 if (gramsOffat > 2){
				do {
				System.out.println("This is a Protein Dietary supplement; quality protein doesn't\n"
						+ "require over 2 grams. Our manufacturer is \"Terry Labs LLC.\",\n"
						+ "this is strictly prohibited!");
				gramsOffat = input.nextInt();
				}
				while (gramsOffat > 2);
			}
		 System.out.println("OK!");
		return gramsOffat;
		}
		 public static int satFats(int gramsOffat){
		 System.out.println("How much Saturated Fats:");
			int satFats = input.nextInt();
			System.out.println("Recall:\nTrans Fats are illegal. Please consult Nutritional Science R&D");
			if (satFats > gramsOffat || satFats + gramsOffat >= 2){
				do{
					System.out.println("The requested amount of saturated fats, " + satFats + " is greater than\n"
							+ "the amount of dietary fats, " + gramsOffat + ". Please reduce the\n"
							+ "amount of saturated fats LOWER THAN the amount of dietary fats.");
			satFats = input.nextInt();
					}
					while (satFats > gramsOffat || satFats + gramsOffat >= 2);
			}
			System.out.println("OK!");
			return satFats;
		}
		
		public static void nutritionFacts(double gramsOfprotein, double gramsOfcarbs, int fiber, int insolubleFiber, double sugars, double gramsOffat,
				double satFats, int containerSize){
			System.out.println("This will be the nutrition facts on the label of the protein supplement:");
			System.out.println("==============================================================================");
			System.out.println("");
			System.out.println("NUTRITION FACTS\n=====================\n");
			if (containerSize == 5){
				System.out.println("Serving Size: 1 Scoop (35g)\nServings Per Container: About " + fivePoundcontainer + "\n");
			}
			else if (containerSize == 10){
				System.out.println("Serving Size: 1 Scoop (35g)\nServings Per Container: About " + tenPoundcontainer + "\n");
			}
			else if (containerSize == 15){
				System.out.println("Serving Size: 1 Scoop (35g)\nServings Per Container: About " + fifteenPoundbag + "\n");
			}
			System.out.println("===============================================================================");
			System.out.println("AMOUNT PER SERVING:\n===================\n");
			System.out.println("Calories: " + (gramsOfprotein*protein + (gramsOfcarbs*carbs) + (gramsOffat*fats)));
			System.out.println("Calories from fat: " + gramsOffat*fats);
			System.out.println("===============================================================================\n");
			System.out.println("TOTAL FAT: " + gramsOffat + "g\nSaturated Fat: " + satFats + "g\nTrans Fat: 0g");
			System.out.println("Cholesterol: 32mg\nSodium: 180mg\nPotassium: 150mg");
			System.out.println("TOTAL CARBOHYDRATES: " + ((gramsOfcarbs+sugars)*carbs) + "g\nDietary Fiber:\n==========\nSoluble Fiber: " + fiber + "g\nInsoluble Fiber: " + insolubleFiber + "g");
			System.out.println("SUGARS: " + sugars + "g");
			System.out.println("PROTEIN: " + gramsOfprotein + "g\n\n====================================================");	
		}

		public static double cost(double gramsOfprotein, double gramsOfcarbs, double gramsOffat){
			double cost = (((gramsOfprotein*protein)*costOfprotein) + ((gramsOfcarbs*carbs)*costOfcarbs) + ((gramsOffat*fats)*costOffats));
			System.out.println("The TOTAL cost of production of this supplement:\n=====");
			System.out.printf("[$%.2f]"
					+ "",(((gramsOfprotein*protein)*costOfprotein) + ((gramsOfcarbs*carbs)*costOfcarbs) + ((gramsOffat*fats)*costOffats)));
			return cost;
			
		}
		
}			


		
	



