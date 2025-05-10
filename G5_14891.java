import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, K, action[][], gear[][], res;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
			init();
			go();
			System.out.println(res);
		

	}

	private static void go() {
		for (int i = 0; i < K; i++) {
			int startGear = action[i][0];
			int dir = action[i][1];
			visited = new boolean[5];
			rotate(startGear, dir);
		}
		
		for (int i = 1; i <= 4; i++) {
			if (gear[i][0] == 1) {
				if(i == 1) res += 1;
				else if(i == 2) res +=2;
				else if(i == 3) res +=4;
				else res += 8;
			}
		}
		
		
	}

	private static void rotate(int startGear, int dir) {
		visited[startGear] = true;
		
		// 오른쪽 기어 탐색
		if ((startGear == 1 || startGear == 2 || startGear == 3 )&& !visited[startGear + 1]) {
			if (gear[startGear][2] != gear[startGear + 1][6]) {
				int newDir = 0;
				if (dir == 1)
					newDir = -1;
				else
					newDir = 1;
				rotate(startGear + 1, newDir);
			}
		}
		
		// 왼쪽 기어 탐색
		if ((startGear == 2 || startGear == 3 || startGear == 4) && !visited[startGear - 1]) {
			if (gear[startGear][6] != gear[startGear - 1][2]) {
				int newDir = 0;
				if (dir == 1)
					newDir = -1;
				else
					newDir = 1;
				rotate(startGear - 1, newDir);
			}
		}

		if (dir == 1) { // 시계 방향
			int tmp = gear[startGear][7];
			for (int i = 7; i > 0; i--) {
				gear[startGear][i] = gear[startGear][i - 1];
			}
			gear[startGear][0] = tmp;
		} else { // 반시계 방향
			int tmp = gear[startGear][0];
			for (int i = 0; i < 7; i++) {
				gear[startGear][i] = gear[startGear][i + 1];
			}
			gear[startGear][7] = tmp;
		}

	}

	private static void init() throws IOException {
		
		gear = new int[5][8];
		
		for (int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = str.charAt(j) -'0';
			}
		}

		K = Integer.parseInt(br.readLine());
		res = 0;
	
		action = new int[K][2];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			action[i][0] = a;
			action[i][1] = b;
		}

	}

}
