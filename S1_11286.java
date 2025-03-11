import java.io.*;
import java.util.*;

public class Main {
	static int N, x;
	static PriorityQueue<Integer> q;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		q = new PriorityQueue<>(new NumberComparator());
		
		
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(br.readLine());
			if(x==0) { 
				if(q.isEmpty()) System.out.println(0); // 배열이 비어있는 경우 0 출력
				else System.out.println(q.poll());; // 배열에서 절댓값이 가장 작은 값 출력
			}
			else {
				q.add(x);
			}
		}
	}

}

class NumberComparator implements Comparator<Integer> {
	
	@Override
	public int compare(Integer o1, Integer o2) {
		if (Math.abs(o1) == Math.abs(o2)) { // 절댓값이 같을 때 작은 수 우선순위
			return o1 - o2;
		}else { // 절댓값이 같지 않을 때 절댓값이 작은 값 우선순위
			return (int)Math.abs(o1) - (int)Math.abs(o2);
		}
	}
	
}
