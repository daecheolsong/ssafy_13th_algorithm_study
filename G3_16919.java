import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_16919 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        if (time == 1) {
            printArray(arr, sb);
        } else if (time % 2 == 0) {
            printFullBombs(r, c, sb);
        } else if (time % 4 == 3) {
            char[][] temp = explode(arr, r, c);
            printArray(temp, sb);
        } else if (time % 4 == 1) {
            char[][] once = explode(arr, r, c);
            char[][] twice = explode(once, r, c);
            printArray(twice, sb);
        }
    }

    static char[][] explode(char[][] arr, int r, int c) {
        char[][] temp = new char[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(temp[i], 'O');
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'O') {
                    temp[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int cx = i + dx[d];
                        int cy = j + dy[d];
                        if (cx >= 0 && cx < r && cy >= 0 && cy < c) {
                            temp[cx][cy] = '.';
                        }
                    }
                }
            }
        }

        return temp;
    }

    static void printFullBombs(int r, int c, StringBuilder sb) {
        for (int i = 0; i < r; i++) {
            sb.append("O".repeat(c)).append("\n");
        }
        System.out.println(sb);
    }

    static void printArray(char[][] arr, StringBuilder sb) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
