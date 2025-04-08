package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		int count = Integer.MAX_VALUE;
		
		//길이가 같은 경우
		if (A.length() == B.length()) {
			int temp = 0;
			//다른 수 세기
			for (int i = 0; i < A.length(); i++) {
				if(A.charAt(i) != B.charAt(i)) {
					temp += 1;
				}
			}
			count = Math.min(temp, count);
		// 길이가 다른경우
		}else {
			//A길이의 사이즈만큼 뽑기
			int size = A.length();
			//B길이 - size 만큼 돌기 
			for(int i = 0; i <= B.length() - size; i++) {
				//A랑 같은 길이만큼 뽑기
				String substr = B.substring(i, i+size);
				int temp = 0;
					//다른 수 세기
				for (int j = 0; j < A.length(); j++) {
					if(A.charAt(j) != substr.charAt(j)) {
						temp += 1;
					}
					
				}
				count = Math.min(temp, count);
				}
			}System.out.println(count);
		}
	}