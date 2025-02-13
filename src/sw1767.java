import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static int Min = Integer.MAX_VALUE;
    public static int[][] map;
    public static boolean[][] visited;

    public static int mapSize;

    public static ArrayList<int[]> cores;

    public static int coreSize;

    public static ArrayList<int[]> sol;

    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TESTCASE = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= TESTCASE; testCase++) {
            sb.append("#").append(testCase).append(" ");
            Min = Integer.MAX_VALUE;
            sol = new ArrayList<>();
            mapSize = Integer.parseInt(br.readLine());

            map = new int[mapSize][mapSize];
            visited = new boolean[mapSize][mapSize];

            cores = new ArrayList<>();

            for (int i = 0; i < mapSize; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < mapSize; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i != 0 && j != 0 && i != mapSize - 1 && j != mapSize - 1) {
                        if (map[i][j] == 1) {
                            cores.add(new int[] { j, i });
                        }
                    }
                }
            }

            coreSize = cores.size();

            go(0,0);
            
            Collections.sort(sol, (o1, o2) -> (o1[0]==o2[0])? Integer.compare(o1[1],o2[1]) : Integer.compare(o1[0],o2[0])*-1 );
            
            sb.append(sol.get(0)[1]).append('\n');
        }

        System.out.println(sb);

    }



    public static void go(int index, int point) {

        if (index == coreSize) {
            sol.add(new int[] {point,count()});
            return;
        }

        go(index+1,point);


        int[] nowCore = cores.get(index);

        int nowCoreX = nowCore[0];
        int nowCoreY = nowCore[1];

        for (int i = 0; i < 4; i++) {

            int power = 1;
            while (true) {
                int nextCoreX = nowCoreX + dx[i] * power;
                int nextCoreY = nowCoreY + dy[i] * power;

                if (arrangeCheck(nextCoreX, nextCoreY)) {
                    if (map[nextCoreY][nextCoreX] == 0 && !visited[nextCoreY][nextCoreX]) {
                        visited[nextCoreY][nextCoreX] = true;
                        if (powerCheck(nextCoreX, nextCoreY)) {
                            go(index + 1,point+1);
                            cancel(nowCoreX, nowCoreY, dx[i], dy[i], power);
                            break;

                        }

                        power++;
                    } else {
                        cancel(nowCoreX, nowCoreY, dx[i], dy[i], power-1);
                        break;
                    }

                }

            }

        }

    }

    public static int count() {
        int num = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (visited[j][i]) {
                    num++;
                }
            }
        }
        return num;
    }

    public static void cancel(int x, int y, int dx, int dy, int power) {

        for (int i = 1; i <= power; i++) {

            int next_x = x + dx * i;
            int next_y = y + dy * i;

            visited[next_y][next_x] = false;

        }

    }

    public static boolean powerCheck(int x, int y) {
        if (x == 0 || y == 0 || x == mapSize - 1 || y == mapSize - 1) {
            return true;
        }
        return false;
    }

    public static boolean arrangeCheck(int x, int y) {

        if (x >= 0 && y >= 0 && x < mapSize && y < mapSize) {
            return true;
        }

        return false;
    }

}
