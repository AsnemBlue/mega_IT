package com.tj.ex5_lib;
public interface ILendable {
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL   = 0;
	public void checkOut(String borrower) throws Exception;
	public void checkIn() throws Exception;
}
