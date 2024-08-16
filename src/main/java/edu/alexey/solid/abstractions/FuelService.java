package edu.alexey.solid.abstractions;

import edu.alexey.solid.enums.FuelType;

public interface FuelService {

	/**
	 * Имеется ли в службе заправки указанное топливо.
	 * 
	 * @param fuelType Тип топлива.
	 * @return true -- имеется, false -- не имеется.
	 */
	boolean hasFuel(FuelType fuelType);

	/**
	 * Заправить машину указанным типом топлива.
	 * 
	 * @param fuelType Тип топлива.
	 */
	default void fuel(FuelType fuelType) {

		if (!hasFuel(fuelType)) {
			throw new IllegalStateException();
		}

		System.out.println("Заправляю машину (" + fuelType.toString() + ")");
	}

}
