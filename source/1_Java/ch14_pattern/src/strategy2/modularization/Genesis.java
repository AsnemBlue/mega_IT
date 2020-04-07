package strategy2.modularization;
import strategy2.inter.*;
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());//engine = new EngineHigh();
		setKm(new Km10());//km     = new Km10();
		setFuel(new FuelGasoline());//fuel   = new FuelGasoline();
	}
	
	@Override
	public void shape() {
		// "제네시스 차 모양은 door, sheet, handle로 이루어져 있다"
		System.out.print("제네시스 ");
		super.shape();
	} 
}
