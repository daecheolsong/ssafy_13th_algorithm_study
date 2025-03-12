import java.io.*;
import java.util.*;

public class Main {
	static int L, C; // L = 암호 자릿수 , C = 문자의 종류
	static char[] input, pw;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		pw = new char[L]; // 암호 자릿 수 만큼 배열 생성
		input = new char[C]; // C 개 문자들을 입력 받는 배열 생성
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0); 
		}
		// 입력 받은 알파벳이 증가하는 순서로 정렬 a c i s t w
		Arrays.sort(input); 
				
		perm(0,0); // 순서가 정해져 있으므로 조합
	}

	private static void perm(int cnt, int start) {
		// 최소 한 개의 모음, 최소 두 개의 자음으로 구성일 때 return		
		if(cnt==L) { // 암호 자릿수 만큼 도달하면
			int mo_count = 0,  ja_count = 0;
			for (int i = 0; i < L; i++) { // 해당 조합 중 자음과 모음 카운트
				if(pw[i] == 'a' || pw[i] == 'e' || pw[i] == 'i' || pw[i] == 'o' || pw[i] == 'u') mo_count++;
				else ja_count++;
			}
			if(mo_count>=1 && ja_count>=2) {
				for (int i = 0; i < L; i++) {
					System.out.print(pw[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			pw[cnt] = input[i];
			perm(cnt+1, i+1);
		}
	}
}
