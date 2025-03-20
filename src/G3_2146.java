
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2146 {

    static int N;

    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int islandCount;
    static int minBridgeCount;
    static HashSet<Integer> bridgeSet;

    static int[][] isVisited;
    public static void main(String[] args) throws IOException {

        init();

        makeNumberIsland();


        //print();

        start();

    }

    static int currentNum;
    public static void start(){
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(map[i][j]!=0){
                    isVisited = new int[N][N];
                    currentNum = map[i][j];
                    minCount = Math.min(bfs(j,i),minCount);
                }
            }
        }
        System.out.println(minCount);


    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(!isRange(nextX,nextY)) continue;

                if(map[nextY][nextX]!=currentNum&&isVisited[nextY][nextX]==0){
                    if(map[nextY][nextX]!=0){

                        return isVisited[nowY][nowX];
                    }

                    isVisited[nextY][nextX] = isVisited[nowY][nowX]+1;
                    queue.add(new int[] {nextX,nextY});
                }
            }





        }
        return Integer.MAX_VALUE;

    }

    public static void print(){
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];


        minBridgeCount = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    map[i][j] = 100;
                }
            }
        }
    }

    public static void makeNumberIsland(){
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==100){

                    index++;
                    dfs(j,i,index);
                }


            }
        }
        islandCount = index;

    }

    public static void dfs(int x, int y , int num){
        map[y][x] = num;

        for (int i = 0; i < 4; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(!isRange(nextX,nextY)) continue;

            if(map[nextY][nextX]==100){
                map[nextY][nextX] = num;
                dfs(nextX,nextY,num);
            }

        }
    }

    //범위 안에 있는지 확인하기
    public static boolean isRange(int x , int y){
        return x>=0 && y>=0 && x<N && y<N;
    }

}
