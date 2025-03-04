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

		Result = 0;
		dna = new char[S];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;

		dna = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0) {
				checkSecret++;
			}
		}

		for (int i = 0; i < P; i++) {
			Add(dna[i]);
		}
		if (checkSecret == 4)
			Result++;

		// 슬라이딩 윈도우 처리부분

		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(dna[i]);
			Remove(dna[j]);
			if (checkSecret == 4)
				Result++;
		}
		System.out.println(Result);
		br.close();
	}

	private static void Add(char c) {
		switch(c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0])
				checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1])
				checkSecret++;
			break;
		case'G':
			myArr[2]++;
			if(myArr[2]==checkArr[2])
				checkSecret++;
			break;
		case'T':
			myArr[3]++;
			if(myArr[3]==checkArr[3])
				checkSecret++;
			break;
		}

	}

	private static void Remove(char c) {
		switch(c) {
		case 'A':
			if(myArr[0] == checkArr[0])
				checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
		case'G':
			if(myArr[2]==checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
		case'T':
			if(myArr[3]==checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
		}

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		// S = Integer.parseInt(st.nextToken());
		// P = Integer.parseInt(st.nextToken());
		
		// str = br.readLine();
		// dna = new char[S];
		// for (int i = 0; i < S; i++) { // O(n), n =1,000,000 
		// 	dna[i] = str.charAt(i);
		// }
		
		// st = new StringTokenizer(br.readLine());
		// A = Integer.parseInt(st.nextToken());
		// C = Integer.parseInt(st.nextToken());
		// G = Integer.parseInt(st.nextToken());
		// T = Integer.parseInt(st.nextToken());
		
		// sum=0;
		// start = 0; end = P-1;
		
		// while(end < S) { // O(n), n =1,000,000 
		// 	int cnt_a=0, cnt_c=0, cnt_g=0, cnt_t=0; // end 증가할 때마다 초기화
		// 	for(int i=start; i<=end; i++) { // O(n), n =1,000,000 -> O(n^2) 으로 시간초과
		// 		if(dna[i] == 'A') {
		// 			cnt_a++;
		// 		}
		// 		if(dna[i] == 'C') {
		// 			cnt_c++;
		// 		}
		// 		if(dna[i] == 'G') {
		// 			cnt_g++;
		// 		}
		// 		if(dna[i] == 'T') {
		// 			cnt_t++;
		// 		}
		// 	}
		// 	if(cnt_a>=A && cnt_c>=C && cnt_g>=G && cnt_t>=T) {
		// 		sum++; // 비밀번호 종류의 수 세기
		// 	}
		// 	end++; // while 문 탈출
		// }
		// System.out.println(sum);
	}
}
