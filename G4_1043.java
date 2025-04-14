import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1043 {

    static int n, m, c;
    static int[] arr, parent;
    static List<Integer>[] party;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            party[i].add(prev);
            for (int j = 0; j < t - 1; j++) {
                int now = Integer.parseInt(st.nextToken());
                party[i].add(now);
                union(prev, now);
            }
        }

        boolean[] truth = new boolean[n + 1];
        for (int i = 0; i < c; i++) {
            truth[find(arr[i])] = true;
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean lie = true;

            for (int person : party[i]) {
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
