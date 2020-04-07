package com.tj.ex.dto;
public class ProductDto {
	private int pno;
	private String pname;
	private int pstock;
	public ProductDto() {}
	public ProductDto(int pno, String pname, int pstock) {
		this.pno = pno;
		this.pname = pname;
		this.pstock = pstock;
	}
	public int getPno() {return pno;}
	public void setPno(int pno) {this.pno = pno;}
	public String getPname() {return pname;}
	public void setPname(String pname) {this.pname = pname;}
	public int getPstock() {return pstock;}
	public void setPstock(int pstock) {this.pstock = pstock;}
	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pstock=" + pstock + "]";
	}
}
