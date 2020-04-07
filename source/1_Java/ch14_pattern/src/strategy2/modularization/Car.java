package strategy2.modularization;

import strategy2.inter.IEngine;
import strategy2.inter.IFuel;
import strategy2.inter.IKm;

public class Car {
	private IEngine engine;
	private IKm     km;
	private IFuel   fuel;
	public void drive() {System.out.println("드라이브 할 수 있다");}
	public void shape() {System.out.println("차 모양은 door, sheet, handle로 이루어져 있다");}
	public void isEngine() { engine.engine(); }
	public void isKmPerLitter() {km.kmPerLetter();}
	public void isFuel() {fuel.fuel();}
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public void setKm(IKm km) {
		this.km = km;
	}
	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}
}
