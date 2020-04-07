package strategy2.modularization;

import strategy2.inter.EngineMid;
import strategy2.inter.FuelGasoline;
import strategy2.inter.Km15;
public class Sonata extends Car {
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.print("¼Ò³ªÅ¸ ");
		super.shape();
	}
}
