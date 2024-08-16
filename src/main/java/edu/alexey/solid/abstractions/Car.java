package edu.alexey.solid.abstractions;

import java.awt.Color;

import edu.alexey.solid.enums.CarType;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.GearType;
import edu.alexey.solid.enums.MovementPrinciple;

public abstract class Car implements Refuelable, Cleanable {

	// ctor

	public Car(
			String brand,
			String model,
			CarType type,
			FuelType fuelType,
			GearType gearType,
			int wheelsCount,
			double engineCapacity) {

		this.brand = brand;
		this.model = model;
		this.type = type;
		this.fuelType = fuelType;
		this.gearType = gearType;
		this.wheelsCount = wheelsCount;
		this.engineCapacity = engineCapacity;
	}

	// properties

	private final String brand;
	private final String model;
	private final CarType type;
	private final FuelType fuelType;
	private final GearType gearType;
	private final int wheelsCount;
	private final double engineCapacity;

	private Color color;

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getWheelsCount() {
		return wheelsCount;
	}

	public double getEngineCapacity() {
		return engineCapacity;
	}

	public CarType getType() {
		return type;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public GearType getGearType() {
		return gearType;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	// methods

	public abstract void drive();

	public abstract void maintenance();

	public abstract boolean changeGear();

	public abstract boolean switchHeadlights();

	public abstract boolean switchWipers();

	//	/**
	//	 * Подметать.
	//	 * Нарушает принцип единственной ответственности (SRP).
	//	 */
	//	public abstract void sweeping();

	// Добавляем новую функциональность в уже существующий базовый тип Car
	// в виде публичного (неявно виртуального) метода, вместо абстрактного,
	// чтобы не нарушить принцип открытости-закрытости (OCP):

	private boolean fogLights = false;

	public boolean switchFogLights() {
		fogLights = !fogLights;
		return fogLights;
	}

	// Добавляем свойство принципа движения машины, чтобы расширить класс машин
	// разнообразными подвидами по типу передвижения не нарушая принципа
	// подстановки Барбары Лисков.

	// Чтобы не нарушать принцип OCP данное свойство добавлено не абстрактным,
	// а публичным методом-геттером с базовой реализацией, возвращающей значение
	// по-умолчанию, не финальным для возможности переопределения в подклассах:

	public static final MovementPrinciple MOVEMENT_PRINCIPLE_DEFAULT = MovementPrinciple.RIDE;

	public MovementPrinciple getMovementPrinciple() {
		return MOVEMENT_PRINCIPLE_DEFAULT;
	}

	// Refuelable

	protected GasStation gasStation;

	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}

	private void ensureGasStationIsSet() {
		if (gasStation == null) {
			throw new IllegalStateException("GasStation is unset.");
		}
	}

	public void fuel() {
		ensureGasStationIsSet();

		gasStation.fuel(this.fuelType);
	}

	// Cleanable

	protected CleaningStation cleaningStation;

	private void ensureCleaningStationIsSet() {
		if (cleaningStation == null) {
			throw new IllegalStateException("CleaningStation is unset.");
		}
	}

	@Override
	public void wipeMirrors() {
		ensureCleaningStationIsSet();

		if (cleaningStation.canWipeMirrors()) {
			cleaningStation.wipeMirrors();
		}
	}

	@Override
	public void wipeWindshield() {
		ensureCleaningStationIsSet();

		if (cleaningStation.canWipeWindshield()) {
			cleaningStation.wipeWindshield();
		}
	}

	@Override
	public void wipeLights() {
		ensureCleaningStationIsSet();

		if (cleaningStation.canWipeLights()) {
			cleaningStation.wipeLights();
		}
	}

}
