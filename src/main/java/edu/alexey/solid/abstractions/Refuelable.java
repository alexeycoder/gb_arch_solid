package edu.alexey.solid.abstractions;

public interface Refuelable {

	void setGasStation(GasStation gasStation);

	/**
	 * Заправка.
	 */
	void fuel();
}
