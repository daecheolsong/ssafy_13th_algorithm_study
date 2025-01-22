package solution;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 입력값 읽기
		br.close();
        int count = 0;

        while (N >= 0) { 
            if (N % 5 == 0) { // 5로 나눠지면 3을 다쓰면 0이 남아서 if만족
                count += N / 5; //  봉지 개수 추가
                bw.write(count + "\n"); 
                bw.flush(); // 값 비우기
                return;
            }
            N -= 3; // 3kg 하나 사용
            count++; //카운터 세주기
        }

        bw.write("-1\n"); // 못 나누면
        bw.flush(); // 값 비우기
        bw.close(); // 닫기
    }
}
