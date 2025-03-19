package Day0307;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 1) 문제 지문 분석 및 이해하기
 * 2) 분석한 내용을 큰 코드 구조부터 분리해보기 (2차원 배열 요소 하나씩 탐색하는 로직? 요소 하나마다 깊이 우선 탐색?
 * 3) 코드 구조 채우기 (입력받기, 2차원 배열 순회 로직, dfs 기본 구조 작성해보기)
 * 4) 채워놓은 기본 코드 구조를 파악한 문제 조건에 맞게 추가/변형해보기 (2차원 배열 순회 범위? 방향키 설정? 탐색 종료 조건?)
 *
 * 
 * 생각/연습해볼것들
 * 
 * 1.구현:
 * 		1) 기본형 변수 및 참조형 변수 선언 및 인덱스 참조 숙달하기.
 * 		2) for 문 인덱스 범위 자유자재로 다룰 수 있도록 숙달하기.
 * 		3) 본인의 코드 작성 스타일 고정 및 숙달하기 (변수명? for문 인덱스 지정 스타일? 코드 분리? 입출력 방식?)
 * 
 * 2. 디저트 문제:
 * 		1) 문제 접근 구조화 해보기 : 문제 설명대로 시뮬레이션을 직접 손으로 해볼때 순서에 따라서, (1)배열 순회하기 (2) 순회하는 요소마다 경로탐색 호출하기
 * 		2) 문제 해결 전략이 왜 DFS 였는지 생각해보기 (문제에서 어떤 조건때문에 dfs? 어떤 결과를 원하길래 DFS?)
 * 		3) DFS의 핵심적인 특징들 다시한번 정리해보기 (깊이 우선으로 탐색한다는 것이, BFS와 달리 어떤 의미/동작인지?, DFS 메서드 선언부에서 파라미터를 활용하는 이유/방법?)
 *
 * */

public class swea_2105 {

	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static boolean[] isSelected;
	static int tc, N, MAX, map[][];
	static final int INF = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception, IOException {
		//System.setIn(new FileInputStream("src/Day0307/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			MAX = INF; // 테스트 케이스마다 Max 값 최소값으로 초기화

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					isSelected = new boolean[101];
					isSelected[map[i][j]] = true;
					dfs(i, j, i, j, 1, 0); // 출발

				}
			}

			if (MAX == INF) sb.append(-1).append('\n');
			else sb.append(MAX).append('\n');
		}
		System.out.println(sb);
	}

	/*  2차원 배열에서 선택한 한 개 요소 (i,j) 에서 돌아다닐 수 있는 모든 경로 탐색하기!
	 * @param  cnt : 하나의 경로를 탐색하는 과정에서, 한칸 씩 앞으로 나아갈때마다 세기 위한 변수 (재귀호출마다 갱신)  
	 * @param  rr, cc : current x/y. 현재의 (x,y) 위치. 즉, 지정된 방향에 따라 앞으로 나아가지는 위치 (재귀호출마다 갱신)
	 * @param  r, c : 맨 처음 2차원 배열에서 선택한 한개의 요소(i,j)의 위치. dfs의 기저조건(탈출조건)을 위한 변수 (갱신X)
	 * @param  prevDir : previous direction, 바로 직전에 진행했던 탐색 방향. (재귀호출 시, 특정 조건에 이면 갱신)
	 * */

	private static void dfs(int r, int c, int rr, int cc, int cnt, int prevDir) {
	
		for (int d = prevDir; d < 4; d++) {
			int nr = rr + dr[d];
			int nc = cc + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			if (nr == r && nc == c && prevDir >= 2) { // 출발 했던 좌표 & 왼쪽 위 or 오른쪽 위 대각선으로 돌아왔을 때 투어 끝!!
				MAX = Math.max(MAX, cnt);
				return;
			}

			if (!isSelected[map[nr][nc]]) {
				isSelected[map[nr][nc]] = true; // 같은 숫자의 디저트 먹었는지 flag
				dfs(r, c, nr, nc, cnt + 1, d);
				isSelected[map[nr][nc]] = false; // flag 원복

			}
		}
	}

}
