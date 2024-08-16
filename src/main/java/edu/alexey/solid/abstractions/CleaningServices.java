package edu.alexey.solid.abstractions;

public interface CleaningServices {
	/**
	 * Протирка зеркал.
	 */
	void wipeMirrors();

	/**
	 * Протирка лобового стекла.
	 */
	void wipeWindshield();

	/**
	 * Протирка фар.
	 */
	void wipeLights();
}
