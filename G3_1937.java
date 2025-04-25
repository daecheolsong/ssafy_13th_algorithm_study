import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_1937 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, answer;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(dfs(i, j), answer);
            }
        }

        System.out.println(answer);
    }

    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (!isIn(cx, cy) || arr[cx][cy] <= arr[x][y]) continue;

            dp[x][y] = Math.max(dp[x][y], dfs(cx, cy) + 1);
        }
        return dp[x][y];
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
