package edu.alexey.solid.concrete;

import java.util.Set;

import edu.alexey.solid.abstractions.CleaningService;
import edu.alexey.solid.abstractions.GasService;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.WipablePart;

public class GasolineOnlyStation implements GasService, CleaningService {

	@Override
	public boolean hasFuel(FuelType fuelType) {
		return fuelType == FuelType.GASOLINE;
	}

	@Override
	public void fuel(FuelType fuelType) {

	}

	@Override
	public boolean canWipe(WipablePart wipable) {

		final Set<WipablePart> allowed = Set.of(WipablePart.WINDSHIELD, WipablePart.LIGHTS);

		return allowed.contains(wipable);
	}

}
