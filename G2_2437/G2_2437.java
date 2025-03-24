import java.util.*;
import java.io.*;


public class G2_2437 {

	static int n;
	static int [] c;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		c = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i ++) {
			c[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(c);
		int sum = 0;
		
		for(int i = 0; i < n; i ++) {
			// 현재까지 더한 값이 그 다음 큰값보다 1 작거나 같으면 -> 큰값을 더한 값까지추를 활용하여 측정가능
			// 1 1 2 3 6 7 30
			// 1 2 4 7 13 20 X 
			// 30 이  20보다 크므로  21부터 추를 활용하여 측정할 수 없다.
			if(sum + 1 >= c[i]) {
				sum += c[i];
			} else {
				break;
			}
		}
		System.out.println(sum + 1);
	}
	
}
