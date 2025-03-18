import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_14442 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m, k, answer;
    static boolean[][][] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[k + 1][n][m];
        answer = -1;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, k, 1});
        visit[k][0][0] = true;

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int count = q.peek()[2];
            int a = q.peek()[3];
            q.poll();

            if (x == n - 1 && y == m - 1) {
                answer = a;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (!isIn(cx, cy) || visit[count][cx][cy]) continue;

                if (arr[cx][cy] == 0) {
                    visit[count][cx][cy] = true;
                    q.add(new int[] {cx, cy, count, a + 1});
                } else if(count > 0 && !visit[count - 1][cx][cy]){
                    visit[count - 1][cx][cy] = true;
                    q.add(new int[] {cx, cy, count - 1, a + 1});
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
