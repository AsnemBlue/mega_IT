package com.tj.ex5_car;

import com.tj.cons.CarSpecs;

public class CarMain {
	public static void main(String[] args) {
		Car lowCar = new LowGradeCar(CarSpecs.COLOR_GRAY, CarSpecs.TIRE_NORMAL, 
				CarSpecs.DISPLACEMENT_1500, CarSpecs.HANDLE_POWER);
		Car highCar = new HighGradeCar(CarSpecs.COLOR_GRAY, CarSpecs.TIRE_WIDE, 
				CarSpecs.DISPLACEMENT_2000, CarSpecs.HANDLE_POWER);
		lowCar.getSpec();
		highCar.getSpec();
	}
}
