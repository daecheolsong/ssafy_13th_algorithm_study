import java.util.*;

public class Main {
    static final int MAX_N = 16;
    static final int INF = 987654321;
    static int n;
    static int[][] dist = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][1 << MAX_N];

    static int tsp(int here, int visited) {
        if (visited == (1 << n) - 1) {
            return (dist[here][0] != 0) ? dist[here][0] : INF;
        }
        if (dp[here][visited] != -1) return dp[here][visited];
        
        int ret = INF;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0) continue;
            if (dist[here][i] == 0) continue;
            ret = Math.min(ret, tsp(i, visited | (1 << i)) + dist[here][i]);
        }
        return dp[here][visited] = ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        System.out.println(tsp(0, 1));
        sc.close();
    }
}
