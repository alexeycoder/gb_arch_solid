package edu.alexey.solid.concrete;

import edu.alexey.solid.abstractions.Car;
import edu.alexey.solid.enums.CarType;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.GearType;
import edu.alexey.solid.enums.MovementPrinciple;

public class FlyingCar extends Car {

	public FlyingCar(String brand, String model, CarType type, FuelType fuelType, GearType gearType, int wheelsCount,
			double engineCapacity) {
		super(brand, model, type, fuelType, gearType, wheelsCount, engineCapacity);
	}

	@Override
	public MovementPrinciple getMovementPrinciple() {
		return MovementPrinciple.FLY;
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub

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

}
