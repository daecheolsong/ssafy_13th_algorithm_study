package swea;
import java.util.*;
import java.io.*;

public class swea_5215 {
	static int tc;
	static int n;
	static int l;
	static int[] scores;
	static int[] calories;
	static int result;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/swea/input_swea5215.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		tc = Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=tc;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br, st);
			go(0,0,0);
			System.out.println(result);
		}		
	}
	
	static void go(int depth, int score, int calorie) {
		if(depth>=n) {
			if(calorie<=l) {	// 조합의 칼로리가 l000이하 일 때 
				result = Math.max(result, score);
			}
			return;
		}
		
		go(depth+1, score+scores[depth], calorie+calories[depth]);	// 먹었을 때
		go(depth+1, score, calorie);	// 안 먹었을 때 
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		scores = new int[n];
		calories = new int[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			scores[i] = Integer.parseInt(st.nextToken());
			calories[i] = Integer.parseInt(st.nextToken());
		}
		result =Integer.MIN_VALUE;
	}
}
