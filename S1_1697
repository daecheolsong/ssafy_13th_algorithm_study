import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_1697 {
 // 사전 지식: queue는 선입선출!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 수빈이 위치
		int K = sc.nextInt(); // 동생 위치
		int visited[] = new int[100001]; //각 위치의 방문 여부 및 초 저장 배열
		int count = 0;
		
		count = checkroad(N,K, visited);
		
		System.out.println(count);

}
	
	static int checkroad(int N, int K, int[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>(); // 큐 선언
		
		queue.add(N); // 초기 수빈이의 위치 add
		
		int index = N; 
		int n = 0;
		visited[index] = 1; // 수빈이 위치 1로 시작
		
		while(queue.isEmpty() == false) {
			n = queue.remove(); //queue 제거하며 각 위치의 -1, +1, *2값 다시 queue에 추가
			if (n == K) {
				return visited[n]-1; // 도착시 값 반환 ( 수빈이를 1로 시작했기 때문에 -1 하고 반환)
			}
			if (n-1 >= 0 && visited[n-1] == 0) {
				visited[n-1] = visited[n]+1; // 뒤로 한칸 갔을때 방문되지 않은 칸이라면 queue 추가
				queue.add(n-1);
			}
			if (n+1 <= 100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n]+1; // 앞으로 한칸 갓을때 방문되지 않은 칸이라면 queue 추가
				queue.add(n+1);
			}
			if (n*2 <= 100000 && visited[n*2] == 0) {
				visited[n*2] = visited[n]+1; // *2만큼 갔을때 방문되지 않은 칸이라면 queue 추가
				queue.add(n*2);
			}
		}
		return 0;
		}
	}
