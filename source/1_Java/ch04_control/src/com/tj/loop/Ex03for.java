package com.tj.loop;
/*결과가 아래와 같은 for문을 작성하시오
 *
 **
 ***
 ****
 *****
 */
public class Ex03for {
	public static void main(String[] args) {
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<=i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
