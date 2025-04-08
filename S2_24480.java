import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] visitOrder;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        R = Integer.parseInt(st.nextToken()); 

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        visitOrder = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(R);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitOrder[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int n) {
        visited[n] = true;
        visitOrder[n] = order++; 

        // 인접 정점들을 방문
        for (int nv : graph[n]) {
            if (!visited[nv]) {
                dfs(nv);
            }
        }
    }
}
