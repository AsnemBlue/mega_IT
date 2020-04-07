package com.tj.supermarket;
public class CustomerDto {
	private String ctel;
	private String cname;
	private int    cpoint;
	private int    camount;
	private String levelname;
	private int levelup;
	public CustomerDto(String ctel, String cname, int cpoint, int camount, String levelname, int levelup) {
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelname = levelname;
		this.levelup = levelup;
	}
	@Override
	public String toString() {
		return ctel + "\t" + cname + "\t" + cpoint + "\t" + camount
				+ "\t" + levelname + "\t" + levelup + "\n";
	}	
}
