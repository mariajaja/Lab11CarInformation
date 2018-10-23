import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Mariah
 *
 */
public class CarApp {

	/**
	 * This program takes in user information about however many cars they'd like to
	 * add and adds it to a list.
	 */

	private static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		List<Car> carMenu = new ArrayList<>();
		List<Car> carInformation = new ArrayList<>();

		System.out.println("Welcome to the Grand Circus Motors admin console!");

		// gets a car count for how many to enter
		int carCount = askForCarCount("How many cars are you entering: ", userInput);

		// calls method to loop and get input from user about each car
		for (int i = 0; i < carCount; i++) {
			createNewCarObject(i, userInput, carInformation);
		}

		// prints to console the car information provided by user
		printCarObject(carInformation);

		// call method to introduce new and used car menu
		carMenu = listOfCars(carMenu);

		System.out.println("Please choose a car from this list.");

		// menu to allow user to select a car
		printCarObject(carMenu);

		// prompts user to choose either remove, add, or quit
		makeADecision(carMenu);

		System.out.println("Have a wonderful day!");
	}

	public static int askForCarCount(String prompt, Scanner userInput) {
		int carCount = 0;
		boolean isValid = false;

		System.out.print(prompt);

		// TODO keeps running if exception hits;; need to fix
		while (!isValid) {
			try {
				carCount = userInput.nextInt();
				// clears input line
				userInput.nextLine();
				isValid = true;
			} catch (InputMismatchException ex) {
				System.out.println("Sorry! That's not a valid number.");
			}
		}
		return carCount;
	}

	// method that allows user to create a list of vehicle information
	public static void createNewCarObject(int i, Scanner userInput, List<Car> carInformation) {
		String carMake;
		String carModel;
		int carYear;
		double carPrice;

		System.out.print("Enter Car Make: ");
		carMake = userInput.nextLine();

		System.out.print("Enter Car Model: ");
		carModel = userInput.nextLine();

		System.out.print("Enter Car Year: ");
		carYear = userInput.nextInt();

		System.out.print("Enter Car Price: ");
		carPrice = userInput.nextDouble();

		// clears input line
		userInput.nextLine();

		carInformation.add(new Car(carMake, carModel, carYear, carPrice));
	}

	public static void createUsedCarObject(Scanner userInput, List<Car> carMenu) {
		String carMake;
		String carModel;
		int carYear;
		double carPrice;
		double mileage;

		// clears input line after coming from the previous next

		System.out.print("Enter Car Make: ");
		carMake = userInput.nextLine();

		System.out.print("Enter Car Model: ");
		carModel = userInput.nextLine();

		System.out.print("Enter Car Year: ");
		carYear = userInput.nextInt();

		System.out.print("Enter Car Price: ");
		carPrice = userInput.nextDouble();

		System.out.print("Enter Car Mileage: ");
		mileage = userInput.nextDouble();

		// clears input line
		userInput.nextLine();

		carMenu.add(new UsedCar(carMake, carModel, carYear, carPrice, mileage));
	}

	// method that prints the car information provided by user
	public static void printCarObject(List<Car> carInformation) {

		System.out.println("Current Inventory: ");
		int i = 0;
		// loop to print out each car added with the specific string pattern
		for (Car printCar : carInformation) {
			i++;
			System.out.println(i + ". " + printCar.toString());
		}
		System.out.println();
	}

	// list of cars created for Lab 11 Part 2 to allow user to select a car from a
	// predefined list
	public static List<Car> listOfCars(List<Car> carMenu) {
		carMenu.add(new UsedCar("Ford", "Fiesta", 2015, 23000.00, 15000.00));
		carMenu.add(new UsedCar("Chevrolet", "Volt", 2016, 45000.00, 65000.00));
		carMenu.add(new Car("Toyota", "Corolla", 2018, 23000.00));
		carMenu.add(new UsedCar("Chevrolet", "Impala", 1986, 25000.00, 85000.00));
		carMenu.add(new Car("Ford", "Mustang", 2019, 35000.00));
		carMenu.add(new Car("KIA", "Sorrento", 2019, 30000.00));

		return carMenu;
	}

	// method to give user a list of options and then follow through with request to
	// list cars, select a car, add a vehicle or quit
	public static void makeADecision(List<Car> carMenu) {
		boolean done = false;

		while (!done) {
			System.out.println("Select an option: (list, select, add, remove, look up, quit)");
			String option = userInput.nextLine();

			switch (option) {
			case "list":
				doListOption(carMenu);
				break;
			case "select":
				carMenu = doSelectOption(carMenu);
				break;
			case "add":
				carMenu = doAddOption(carMenu);
				break;
			case "remove":
				carMenu = doRemoveOption(carMenu);
				break;
			case "look up":
				System.out.println(doLookUpOption(carMenu));
				break;
			case "quit":
				done = true;
				break;
			default:
				System.out.println("Invalid choice...");
				break;
			}
		}
	}

	private static void doListOption(List<Car> carMenu) {
		for (int i = 0; i < carMenu.size(); i++) {
			System.out.println((i + 1) + ". " + carMenu.get(i));
		}
	}

	private static List<Car> doSelectOption(List<Car> carMenu) {

		System.out.print("Which car would you like? ");
		int selection = userInput.nextInt();
		// clears input line
		userInput.nextLine();
		selection -= 1;

		// prints the user's option before asking whether they'd like to delete it
		System.out.println(carMenu.get(selection));

		System.out.println("Would you like to buy this car? ");
		String buyCar = userInput.nextLine();

		// start process if user wants to buy car (remove car from list) or not
		if (buyCar.toLowerCase().startsWith("y")) {
			System.out.println("Excellent! Our finance department will be in touch shortly.");
			System.out.println();
			carMenu.remove(selection);
		}
		return carMenu;

	}

	private static List<Car> doAddOption(List<Car> carMenu) {

		System.out.println("Is the car new or used? ");
		String newOrUsed = userInput.nextLine();

		if (newOrUsed.toLowerCase().equals("new")) {
			createNewCarObject(0, userInput, carMenu);
		} else if (newOrUsed.toLowerCase().equals("used")) {
			createUsedCarObject(userInput, carMenu);
		}
		return carMenu;
	}

	private static List<Car> doRemoveOption(List<Car> carMenu) {
		System.out.print("Which car would you like to remove (type its number): ");
		int selection = userInput.nextInt();
		carMenu.remove(selection - 1);
		return carMenu;
	}

	private static Car doLookUpOption(List<Car> carMenu) {
		System.out.println("Which number would you like to see about (type its number): ");
		int selection = userInput.nextInt();
		return carMenu.get(selection - 1);
	}

}
