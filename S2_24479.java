import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer>[] graph;
    static int[] visited;  
    static int N, M, R;
    static int order = 1; 

    public static void main(String[] args) throws IOException {
        init();
        dfs(R);
        
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        
        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = order++;  // 방문 순서 기록

        for (int nv : graph[v]) {
            if (visited[nv] == 0) {  // 방문하지 않았다면
                dfs(nv);
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new int[N + 1]; 

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            graph[i].add(j);
            graph[j].add(i);
        }

        // 오름차순 정렬 (작은 번호부터 방문하도록)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
    }
}
