package edu.alexey.solid.abstractions;

import java.awt.Color;
import java.util.Objects;

import edu.alexey.solid.enums.CarType;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.GearType;
import edu.alexey.solid.enums.MovementPrinciple;
import edu.alexey.solid.enums.WipablePart;

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

	@Override
	public boolean fuel(GasService gasService) {

		if (Objects.requireNonNull(gasService).hasFuel(fuelType)) {
			gasService.fuel(fuelType);
			return true;
		}
		return false;
	}

	// Cleanable

	/**
	 * У машины "по-умолчанию" имеются все протираемые части.
	 */
	@Override
	public boolean hasWipable(WipablePart wipable) {
		return true;
	}

	@Override
	public void wipe(CleaningService cleaningService, WipablePart... wipables) {
		Objects.requireNonNull(cleaningService);
		if (wipables == null || wipables.length == 0) {
			throw new IllegalArgumentException("wipables");
		}

		for (WipablePart wipable : wipables) {

			if (this.hasWipable(wipable) && cleaningService.canWipe(wipable))
				cleaningService.wipe(wipable);

		}
	}

}
