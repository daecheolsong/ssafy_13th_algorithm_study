package Day0310;

import java.io.*;
import java.util.*;

public class S4_2164 {
	static int N;
	static Queue<Integer> queue;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		queue = new LinkedList<>();
		
		// 1~N 카드더미 만들기
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		// 1장 남을 때까지 
		while(queue.size()>1) {
			queue.poll(); // 가장 위에 있는 카드를 버린다
			queue.add(queue.peek()); // 그 다음 가장 위 카트를 가장 밑으로 넣기
			queue.poll(); // 옮겼기 때문에 삭제
		}
		
		System.out.println(queue.peek());
	}

}
