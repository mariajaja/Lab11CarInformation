/**
 * 
 */

/**
 * @author Mariah
 *
 */
public class UsedCar extends Car {
	private double mileage;

	public UsedCar() {
	}

	public UsedCar(String carMake, String carModel, int carYear, double carPrice, double mileage) {
		super(carMake, carModel, carYear, carPrice);
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		// TODO figure out printf to add a "," in the price and to 2 decimal points
		return getCarYear() + " " + getCarMake() + " " + getCarModel() + " $" + getCarPrice() + " (Used) " + mileage
				+ " miles";
	}

}
