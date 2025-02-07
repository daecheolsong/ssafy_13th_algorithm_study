import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_9019 {

    static boolean[] visit;
    static String[] command;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visit = new boolean[10000];
            command = new String[10000];

            bfs(a, b);

            sb.append(command[b]).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * D : n * 2;
     * S : n - 1;
     * L : n << (1234 -> 2341)
     * R : n >> (1234 -> 4123)
     */
    static void bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visit[a] = true;
        command[a] = "";

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == b) {
                break;
            }

            int D = cur * 2 % 10000;
            int S = cur == 0 ? 9999 : cur - 1;
            int L = (cur % 1000) * 10 + cur / 1000;
            int R = (cur % 10) * 1000 + cur / 10;

            if (!visit[D]) {
                visit[D] = true;
                command[D] = command[cur] + "D";
                q.add(D);
            }
            if (!visit[S]) {
                visit[S] = true;
                command[S] = command[cur] + "S";
                q.add(S);
            }
            if (!visit[L]) {
                visit[L] = true;
                command[L] = command[cur] + "L";
                q.add(L);
            }
            if (!visit[R]) {
                visit[R] = true;
                command[R] = command[cur] + "R";
                q.add(R);
            }
        }
    }
}
