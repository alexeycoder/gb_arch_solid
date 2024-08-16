package edu.alexey.solid.abstractions;

import java.util.NoSuchElementException;

import edu.alexey.solid.enums.WipablePart;

public interface CleaningService {

	/**
	 * Доступность сервиса по протирке указанной части.
	 * 
	 * @param wipable Протираемая часть.
	 * @return true, если предоставляется сервис по протирке указанной части, иначе
	 *         -- false.
	 */
	boolean canWipe(WipablePart wipable);

	/**
	 * Протереть указанную часть.
	 * 
	 * @param wipable Протираемая часть.
	 */
	default void wipe(WipablePart wipable) {

		if (!canWipe(wipable)) {
			throw new IllegalStateException();
		}

		switch (wipable) {
		case MIRROR -> System.out.println("Протираю зеркала");
		case WINDSHIELD -> System.out.println("Протираю лобовое стекло");
		case LIGHTS -> System.out.println("Протираю фары");
		default -> throw new NoSuchElementException();
		}

	}
}
