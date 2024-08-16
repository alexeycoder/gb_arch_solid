package edu.alexey.solid.abstractions;

import edu.alexey.solid.enums.FuelType;

public interface GasStation {

	/**
	 * Заправить автомобиль.
	 */
	void fuel(FuelType fuelType);

}
