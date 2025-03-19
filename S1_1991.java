import java.util.*;
import java.io.*;
public class S1_1991 {

	static int N;
	static char[][] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new char[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = st.nextToken().charAt(0);
			list[i][1] = st.nextToken().charAt(0);
			list[i][2] = st.nextToken().charAt(0);
		}

		pre(0);
		System.out.println();
		ino(0);
		System.out.println();
		pos(0);
		System.out.println();
		

	}
	
	static void pre(int idx) {
		System.out.print(list[idx][0]);
		if (list[idx][1] != '.') {
			for (int i = 0; i < N; i++) {
				if (list[i][0] == list[idx][1]) pre(i);
			}
		}
		if (list[idx][2] != '.') {
			for (int i = 0; i < N; i++) {
				if (list[i][0] == list[idx][2]) pre(i);
			}
		}
	}
	
	static void ino(int idx) {
		if (list[idx][1] != '.') {
			for (int i = 0; i < N; i++) {
				if (list[i][0] == list[idx][1]) ino(i);
			}
		}

		System.out.print(list[idx][0]);
		
		if (list[idx][2] != '.') {
			for (int i = 0; i < N; i++) {
				if (list[i][0] == list[idx][2]) ino(i);
			}
		}
	}
	
	static void pos(int idx) {
		if (list[idx][1] != '.') {
			for (int i = 0; i < N; i++) {
				if (list[i][0] == list[idx][1]) pos(i);
			}
		}
		
		if (list[idx][2] != '.') {
			for (int i = 0; i < N; i++) {
				if (list[i][0] == list[idx][2]) pos(i);
			}
		}

		System.out.print(list[idx][0]);
	}

}
