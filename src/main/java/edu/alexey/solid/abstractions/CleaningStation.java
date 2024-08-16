package edu.alexey.solid.abstractions;

public interface CleaningStation extends CleaningServices {

	boolean canWipeMirrors();

	boolean canWipeWindshield();

	boolean canWipeLights();
}
