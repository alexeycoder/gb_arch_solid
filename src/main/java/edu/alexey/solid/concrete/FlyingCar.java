package edu.alexey.solid.concrete;

import edu.alexey.solid.abstractions.Car;
import edu.alexey.solid.enums.CarType;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.GearType;
import edu.alexey.solid.enums.MovementPrinciple;

public class FlyingCar extends Car {

	static final CarType TYPE = CarType.SPORT;
	static final FuelType FUEL_TYPE = FuelType.GASOLINE;

	public FlyingCar(String brand, String model, GearType gearType, int wheelsCount,
			double engineCapacity) {
		super(brand, model, TYPE, FUEL_TYPE, gearType, wheelsCount, engineCapacity);
	}

	@Override
	public MovementPrinciple getMovementPrinciple() {
		return MovementPrinciple.FLY;
	}

	@Override
	public void drive() {
		System.out.println("Лечу");
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
