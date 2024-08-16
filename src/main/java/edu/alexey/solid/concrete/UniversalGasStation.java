package edu.alexey.solid.concrete;

import edu.alexey.solid.abstractions.GasStation;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.WipablePart;

public class UniversalGasStation implements GasStation {

	@Override
	public boolean hasFuel(FuelType fuelType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canWipe(WipablePart wipable) {
		return true;
	}

}
