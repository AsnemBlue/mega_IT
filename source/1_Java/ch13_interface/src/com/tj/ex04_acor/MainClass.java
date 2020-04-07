package com.tj.ex04_acor;

public class MainClass {
	public static void main(String[] args) {
		IAcor[] models = {new AModel(), new BModel(), new CModel()};
		for(IAcor model : models) {
			model.dmbReceive();
			model.lte();
			model.tvRemoteControl();
			System.out.println("------------------");
		}
	}
}
