package edu.alexey.solid.concrete;

import edu.alexey.solid.abstractions.Car;
import edu.alexey.solid.abstractions.GasStation;
import edu.alexey.solid.enums.CarType;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.GearType;

public class Harverster extends Car implements GasStation {

	static final CarType TYPE = CarType.TRUCK;
	static final int WHEELS = 6;

	public Harverster(String brand,
			String model,
			FuelType fuelType,
			GearType gearType,
			double engineCapacity) {

		super(brand, model, TYPE, fuelType, gearType, WHEELS, engineCapacity);
	}

	@Override
	public void drive() {
		System.out.println("Еду");
	}

	@Override
	public void maintenance() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean changeGear() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchHeadlights() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchWipers() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Подметать.
	 */
	public void sweeping() {
		System.out.println("Подметает улицу.");
	}

	// Реализация 

	@Override
	public void fuel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wipeMirrors() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wipeWindshield() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wipeLights() {
		// TODO Auto-generated method stub

	}

}
