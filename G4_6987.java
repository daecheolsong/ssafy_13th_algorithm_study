import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_6987 {

	static int[][] arr;
	static int[][] temp;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[6][3];
			answer = 0;
			
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			temp = new int[6][3];			
			
			check(0, 1);
			
			sb.append(answer).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static void check(int t1, int t2) {
		if (t1 == 6) {
			for (int i = 0; i < 6; i++) {
				int count = 0;
				for (int j = 0; j < 3; j++) {
					count += arr[i][j];
				}
				if (count != 5) {
					return;
				}
			}
			answer = 1;
			return;
		}
		
		if (t2 == 6) {	
			check(t1 + 1, t1 + 2);
			return;
		}
		
		// t1이 이길 경우
		if (temp[t1][0] + 1 <= arr[t1][0] && temp[t2][2] + 1 <= arr[t2][2]) {
			temp[t1][0]++;
			temp[t2][2]++;
			check(t1, t2 + 1);
			temp[t1][0]--;
			temp[t2][2]--;
		}
		
		// t2가 이길 경우
		if (temp[t1][2] + 1 <= arr[t1][2] && temp[t2][0] + 1 <= arr[t2][0]) {
			temp[t1][2]++;
			temp[t2][0]++;
			check(t1, t2 + 1);
			temp[t1][2]--;
			temp[t2][0]--;
		}
		
		// 무승부가 가능할 경우
		if (temp[t1][1] + 1 <= arr[t1][1] && temp[t2][1] + 1 <= arr[t2][1]) {
			temp[t1][1]++;
			temp[t2][1]++;
			check(t1, t2 + 1);
			temp[t1][1]--;
			temp[t2][1]--;
		}
	}
}
