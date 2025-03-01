package BOJ;

import java.io.*;
import java.util.*;

public class Main_12891_신규원 {
	
	static int S, P, A, C, G, T, start, end, sum;
	static char[] dna;
	static String str;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		dna = new char[S];
		for (int i = 0; i < S; i++) { // O(n), n =1,000,000 
			dna[i] = str.charAt(i);
		}
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		sum=0;
		start = 0; end = P-1;
		
		while(end < S) { // O(n), n =1,000,000 
			int cnt_a=0, cnt_c=0, cnt_g=0, cnt_t=0; // end 증가할 때마다 초기화
			for(int i=start; i<=end; i++) { // O(n), n =1,000,000 -> O(n^2) 으로 시간초과
				if(dna[i] == 'A') {
					cnt_a++;
				}
				if(dna[i] == 'C') {
					cnt_c++;
				}
				if(dna[i] == 'G') {
					cnt_g++;
				}
				if(dna[i] == 'T') {
					cnt_t++;
				}
			}
			if(cnt_a>=A && cnt_c>=C && cnt_g>=G && cnt_t>=T) {
				sum++; // 비밀번호 종류의 수 세기
			}
			end++; // while 문 탈출
		}
		System.out.println(sum);
	}
}
