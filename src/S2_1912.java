import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1912 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		int sum =0;
		
		int max = Integer.MIN_VALUE;
		
		//문제 조건에서 정수가 100000까지 이므로 2중 for문을 사용하였을 경우 시간초과가 발생합니다.
		for(int i =0 ; i<N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			sum += num;
			
			
			max = Math.max(max, sum); //다음 값이 음수가 나올 경우 결과 값이 작아질 수 있기 때문에 각각의 최댓값을 저장합니다.
			
			if(sum<0) {
				sum =0;
			}//누적된 합을 계산할때 음수이면 큰 값이 나오지 않기 때문에 0으로 초기화 시킵니다. 
			
		}
		
		System.out.println(max);
		
		
		
	}
}
