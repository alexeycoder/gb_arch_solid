package edu.alexey.solid.abstractions;

import edu.alexey.solid.enums.WipablePart;

public interface Cleanable {

	/**
	 * Проверка наличия указанной протираемой части.
	 * 
	 * @param wipable Протираемая часть.
	 * @return true если такая часть имеется, иначе -- false.
	 */
	boolean hasWipable(WipablePart wipable);

	void wipe(CleaningService cleaningService, WipablePart... wipables);
}
