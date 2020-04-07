package com.tj.student;
public class StudentDTO {
	private int rank;
	private String nameNo;
	private String mName;
	private int score;
	public StudentDTO(int rank, String nameNo, String mName, int score) {
		this.rank = rank;
		this.nameNo = nameNo;
		this.mName = mName;
		this.score = score;
	}
	@Override
	public String toString() {
		return rank + "µî\t" + nameNo + "\t" + mName + "\t" + score;
	}
}











