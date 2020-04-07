package strategy2.modularization;
import strategy2.inter.EngineLow;
import strategy2.inter.FuelDiesel;
import strategy2.inter.Km20;
public class Accent extends Car{
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.print("¿¢¼¾Æ® ");
		super.shape();
	}
}
