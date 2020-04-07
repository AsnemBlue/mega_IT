package com.tj.ex7_personinfo;
public class PersonInfoTestMain {
	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("È«±æµ¿", 20, 'm'),
							   new PersonInfo("È«±æ¼ø",19,'f')
		};
		for(PersonInfo p : person) {
			p.print();
		}
		for(int idx=0 ; idx<person.length ; idx++) {
			person[idx].print();
		}
		PersonInfo[] iperson = new PersonInfo[2];
		iperson[0] = new PersonInfo("È«±æµ¿", 20, 'm');
		iperson[1] = new PersonInfo("È«±æ¼ø",19,'f');
		for(PersonInfo p : iperson) {
			p.print();
		}
	}
}
