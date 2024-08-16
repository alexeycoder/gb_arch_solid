package edu.alexey.solid.concrete;

import edu.alexey.solid.abstractions.CleaningService;
import edu.alexey.solid.abstractions.GasService;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.WipablePart;

public class UniversalGasStation implements GasService, CleaningService {

	@Override
	public boolean hasFuel(FuelType fuelType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fuel(FuelType fuelType) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canWipe(WipablePart wipable) {
		return true;
	}

}
