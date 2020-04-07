package com.tj.ex6_vote;
import java.util.Random;
public class VoteTarget implements Runnable{
	private int count; // 개표율
	private Random random;
	private final int TARGETCOUNT = 100;
	private StringBuilder graph;
	public VoteTarget() {
		count = 0;
		random = new Random();
		graph = new StringBuilder();
	}
	@Override
	public void run() {
		while(true) {
			// count(개표율)을 random.nextInt(10)만큼 올리기
			count += random.nextInt(10);
			if(count>=TARGETCOUNT) {
				count = TARGETCOUNT;
				// count 만큼 별 만들기 ★★★★★...★★★
				graph.delete(0, graph.toString().length());  //graph 별 다 지우기
				for(int i = 0 ; i<count ; i++) {
					graph.append('★');
				}
				// 지역이름(쓰레드이름) count(개표율), graph(★)를 출력
				System.out.println(Thread.currentThread().getName()+"\t"+count+"% 개표 "+ graph);
				break;
			}
			// count 만큼 별 만들기
			graph.delete(0, graph.toString().length());  //graph 별 다 지우기
			for(int i = 0 ; i<count ; i++) {
				graph.append('★');
			}
			// 지역이름(쓰레드이름) count(개표율), graph(★)를 출력
			System.out.println(Thread.currentThread().getName()+"\t"+count+"% 개표 "+ graph);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}

















