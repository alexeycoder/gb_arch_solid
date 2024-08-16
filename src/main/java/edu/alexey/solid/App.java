package edu.alexey.solid;

import edu.alexey.solid.abstractions.Car;
import edu.alexey.solid.abstractions.GasStation;
import edu.alexey.solid.concrete.FlyingCar;
import edu.alexey.solid.concrete.GasolineOnlyStation;
import edu.alexey.solid.concrete.Harverster;
import edu.alexey.solid.concrete.SportCar;
import edu.alexey.solid.concrete.UniversalGasStation;
import edu.alexey.solid.enums.FuelType;
import edu.alexey.solid.enums.GearType;
import edu.alexey.solid.enums.WipablePart;

/**
 * 1. Спроектировать абстрактный класс Car у которого должны быть свойства:
 * марка, модель, цвет, тип кузова, число колёс, тип топлива, тип коробки
 * передач, объём двигателя; методы: движение, обслуживание, переключение
 * передач, включение фар, включение дворников.
 * 
 * 2. Создать конкретный автомобиль путём наследования класса Car.
 * 
 * 3. Расширить абстрактный класс Car, добавить метод: подметать улицу. Создать
 * конкретный автомобиль путём наследования класса Car. Провести проверку
 * принципа SRP.
 * 
 * 4. Расширить абстрактный класс Car, добавить метод: включение противотуманных
 * фар, перевозка груза. Провести проверку принципа OCP.
 * 
 * 5.Создать конкретный автомобиль путём наследования класса Car, определить
 * число колёс = 3. Провести проверку принципа LSP.
 * 
 * 6. Создать конкретный автомобиль путём наследования класса Car, определить
 * метод «движение» - «полёт». Провести проверку принципа LSP.
 * 
 * 7. Создать интерфейс «Заправочная станция», создать метод: заправка топливом.
 * 
 * 8. Имплементировать метод интерфейса «Заправочная станция» в конкретный класс
 * Car.
 * 
 * 9. Добавить в интерфейс «Заправочная станция» методы: протирка лобового
 * стекла, протирка фар, протирка зеркал.
 * 
 * 10. Имплементировать все методы интерфейса «Заправочная станция» в конкретный
 * класс Car. Провести проверку принципа ISP. Создать дополнительный/е
 * интерфейсы и имплементировать их в конкретный класс Car. Провести проверку
 * принципа ISP.
 * 
 * 11. Создать путём наследования класса Car два автомобиля: с бензиновым и
 * дизельным двигателями, имплементировать метод «Заправка топливом» интерфейса
 * «Заправочная станция». Реализовать заправку каждого автомобиля подходящим
 * топливом. Провести проверку принципа DIP.
 */
public class App {
	public static void main(String[] args) {

		Harverster harverster = new Harverster("Bucher", "BKM 2020", FuelType.DIESEL, GearType.MANUAL, 1);
		SportCar sportCar = new SportCar("Polaris", "Slingshot SL", GearType.MANUAL, 1);
		FlyingCar flyingCar = new FlyingCar("Nonsence", "AA1000", GearType.AUTO, 4, 1);

		GasStation uniGasStation = new UniversalGasStation();
		GasStation gasGasStation = new GasolineOnlyStation();

		System.out.println("\nУборочная машина:");
		harverster.drive();
		System.out.println("Попытка заправки на станции, где нет диз.топлива:");
		harverster.fuel(gasGasStation);
		harverster.wipe(gasGasStation, WipablePart.LIGHTS, WipablePart.MIRROR);
		System.out.println("Стоимость обслуживания: " + calcMaintenance(harverster));

		System.out.println("\nСпортивная машина:");
		sportCar.drive();
		sportCar.fuel(gasGasStation);
		sportCar.wipe(gasGasStation, WipablePart.MIRROR, WipablePart.WINDSHIELD, WipablePart.LIGHTS);
		sportCar.drive();
		sportCar.fuel(uniGasStation);
		sportCar.wipe(uniGasStation, WipablePart.MIRROR, WipablePart.WINDSHIELD, WipablePart.LIGHTS);
		System.out.println("Стоимость обслуживания: " + calcMaintenance(sportCar));

		System.out.println("\nЛетающая машина:");
		flyingCar.drive();
		flyingCar.fuel(gasGasStation);
		flyingCar.wipe(gasGasStation, WipablePart.MIRROR, WipablePart.WINDSHIELD, WipablePart.LIGHTS);
		flyingCar.drive();
		flyingCar.fuel(uniGasStation);
		flyingCar.wipe(uniGasStation, WipablePart.MIRROR, WipablePart.WINDSHIELD, WipablePart.LIGHTS);
		System.out.println("Стоимость обслуживания: " + calcMaintenance(flyingCar));
	}

	static double calcMaintenance(Car car) {

		int wheelsCount = car.getWheelsCount();
		if (wheelsCount >= 6) {
			return 1500 * wheelsCount;
		} else {
			return 1000 * wheelsCount;
		}
	}
}
