import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1043 {

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            party[i].add(prev);
            // 파티의 첫 사람 기준으로 유니온-파인드
            for (int j = 0; j < t - 1; j++) {
                int now = Integer.parseInt(st.nextToken());
                party[i].add(now);
                union(prev, now);
            }
        }

        // 진실을 아는 사람의 대표 노드를 true 변경
        boolean[] truth = new boolean[n + 1];
        for (int i = 0; i < c; i++) {
            truth[find(arr[i])] = true;
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            // 거짓말을 할 수 있는지?
            boolean lie = true;

            // 한 파티에서 거짓말을 할 수 있는지 확인
            for (int person : party[i]) {
                // 진실을 아는 사람의 대표 노드와 동일할 경우 거짓말 불가
                if (truth[find(person)]) {
                    lie = false;
                    break;
                }
            }
            if (lie) answer++;
        }
        System.out.println(answer);
    }

    static int find(int a) {
        if (parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parent[b] = a;
    }
}
