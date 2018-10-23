import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Mariah
 *
 */
public class CarLotApp {

	// making a static variable outside main means it can be shared by all the
	// methods
	private static List<Car> carMenu = new ArrayList<>();

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		carMenu.add(new UsedCar("Ford", "Fiesta", 2015, 23000.00, 15000.75));
		carMenu.add(new UsedCar("Chevrolet", "Volt", 2016, 45000.00, 65000.00));
		carMenu.add(new Car("Toyota", "Corolla", 2018, 23000.00));
		carMenu.add(new UsedCar("Chevrolet", "Impala", 1986, 25000.00, 85000.80));
		carMenu.add(new Car("Ford", "Mustang", 2019, 35000.99));
		carMenu.add(new Car("KIA", "Sorrento", 2019, 30000.00));

		boolean done = false;
		while (!done) {
			System.out.println("Select an option: (list, select, add, quit)");
			String option = userInput.nextLine();
			switch (option) {
			case "list":
				doListOption();
				break;
			case "select":
				doSelectOption();
				break;
			case "add":
				doAddOption();
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

	private static void doListOption() {
		for (int i = 0; i < carMenu.size(); i++) {
			System.out.println((i + 1) + ". " + carMenu.get(i));
		}
		System.out.println();
	}

	private static void doSelectOption() {

	}

	private static void doAddOption() {

	}

}
