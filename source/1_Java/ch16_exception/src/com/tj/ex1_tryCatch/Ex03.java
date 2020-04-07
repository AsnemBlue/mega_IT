package com.tj.ex1_tryCatch;
public class Ex03 {
	public static void main(String[] args) {
		int[] iArr = {0,1,2};
		for(int idx=0 ; idx<iArr.length ; idx++) {
			try {
				System.out.println("iArr["+idx+"] = "+iArr[idx]);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("예외메세지 : "+e.getMessage());
				// e.printStackTrace();
			}finally {
				System.out.println("try절 실행후에도 이부분하고 catch절 실행후에도 이부분은 꼭 실행");
			}
		}//for
	}//main
}//class
