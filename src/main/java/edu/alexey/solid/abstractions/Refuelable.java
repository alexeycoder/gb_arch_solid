package edu.alexey.solid.abstractions;

import edu.alexey.solid.enums.FuelType;

public interface Refuelable {

	FuelType getFuelType();

	boolean fuel(GasService gasService);
}
