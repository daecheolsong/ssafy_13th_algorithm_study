import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2117 {

    static int n;
    static int m;
    static int[][] arr;
    static int[][] homeLocation;
    static int max;
    static int homeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            max = -1;
            homeCount = 0;
            homeLocation = new int[n * n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        homeLocation[homeCount][0] = i;
                        homeLocation[homeCount][1] = j;
                        homeCount++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(check()).append("\n");
        }
        System.out.println(sb);
    }

    static int check() {
        int answer = 0;
        int k = n + 2;

        while (k --> 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int count = 0;

                    for (int l = 0; l < homeCount; l++) {
                        int x, y;
                        x = homeLocation[l][0];
                        y = homeLocation[l][1];

                        if ((Math.abs(i - x) +  Math.abs(j - y)) < k) {
                            count++;
                        }
                    }

                    int temp = (k * k + (k - 1) * (k - 1)) - count * m;
                    if (temp <= 0) {
                        answer = Math.max(answer, count);
                    }
                }
            }
            if (answer > 0) {
                return answer;
            }
        }
        return answer;
    }
}
