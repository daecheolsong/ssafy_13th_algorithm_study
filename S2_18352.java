import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        
        boolean found = false;
        for (int i = 1; i <= N; i++) { // 0은 없으므로 1부터 시작
            if (visited[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (!found) sb.append("-1\n"); // K 거리의 도시가 없으면 -1 출력

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visited[X] = 0; // 시작점 거리는 0
        q.offer(X);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nv : graph[cur]) {
                if (visited[nv] == -1) { // 방문하지 않은 노드만
                    visited[nv] = visited[cur] + 1;
                    q.offer(nv);
                }
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];
        Arrays.fill(visited, -1); // 방문 배열 초기값 -1

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            graph[i].add(j);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
    }
}
