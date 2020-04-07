public class Exvars {
	public static void main(String[] args) {
		System.out.println(sum(10,20));
		System.out.println(sum(10,20,30));
		System.out.println(sum(10,20,30,40));
		System.out.println(sum(10,20,30,40,50));
		System.out.println(sum(10,20,30,40,50,60));
	}
	private static int sum(int...su) { // 가변인자함수
		int total=0;
		for(int s : su) {
			total += s;
		}
//		for(int idx=0 ; idx<su.length ; idx++) {
//			total += su[idx];
//		}
		return total;
	}
}
