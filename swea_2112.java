import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_2112 {
    static int d, w, k; // 두께, 가로크기, 합격기준
    static int[][] arr; // 보호필름 배열
    static int answer;  // 답
    static int size;    // 약물 투입할 횟수(최소 2)

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()); // 보호필름 두께
            w = Integer.parseInt(st.nextToken()); // 가로 크기
            k = Integer.parseInt(st.nextToken()); // 합격 기준
            answer = 0;
            size = 1;

            arr = new int[d][w];

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 만약 처음부터 통과된다면 0
            if (checkHeight(arr)) {
                sb.append("#").append(t).append(" ").append(0).append("\n");
                continue;
            }

            while (size <= k) {
                if (size == k) {
                    answer = k;
                    break;
                }

                List<int[]> list = new ArrayList<>();
                getLine(list, 0);

                if (answer == size) {
                    break;
                }
                size++;
            }


            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * 1. 약물 투입할 라인 구하기
     */
    static void getLine(List<int[]> list, int idx) {
        // 약물 투입할 가로줄 라인수가 정해졌다면 약물 투입할 함수 호출
        if (list.size() == size) {
            insert(list);
            return;
        }

        if (idx == d) {
            return;
        }

        for (int i = idx; i < d; i++) {
            list.add(new int[] {i, 0});
            getLine(list, i + 1);
            list.remove(list.size() - 1);

            list.add(new int[] {i, 1});
            getLine(list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 2. 약물 투입
     */
    static void insert(List<int[]> list) {
        // 배열 복사
        int tempArr[][] = new int[d][w];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < w; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }

        int idx = 0;
        for (int i = 0; i < d; i++) {
            if (idx == size) {
                break;
            }

            // 어느 라인이 칠할 라인인지 확인
            if (list.get(idx)[0] == i) {
                // 칠할 색 값
                int value = list.get(idx)[1];
                for (int j = 0; j < w; j++) {
                    tempArr[i][j] = value;
                }
                idx++;
            }
        }

        if (checkHeight(tempArr)) {
            answer = size;
        }
    }

    /**
     * 3. 두께 체크
     */
    static boolean checkHeight(int[][] checkArr) {
        // 어떤 세로 줄이 조건을 만족하는지 확인할 용도
        boolean[] check = new boolean[w];

        for (int i = 0; i < w; i++) {
            int count = 0;
            int c = checkArr[0][i]; // 현재 위치를 체크(A or B)
            for (int j = 0; j < d; j++) {
                // 일치한다면 count++
                if (c == checkArr[j][i]) {
                    count++;
                }
                // 일치하지 않는다면 c를 변경해주고 count를 1로 초기화
                else {
                    c = checkArr[j][i];
                    count = 1;
                }

                // 조건을 만족한다면 그 라인은 true
                if (count == k) {
                    check[i] = true;
                }
            }
            if (!check[i]) {
                return false;
            }
        }

        return true;
    }
}
