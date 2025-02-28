package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {


    public static int[][] visited;
    public static char[][] map;
    public static int N;
    public static int M;

    public static int[] dx ={0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];


        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);

                if(map[i][j]=='S'){
                    start[0] = j;
                    start[1] = i;

                }

                if(map[i][j] == 'D'){
                    end[0] =j;
                    end[1] = i;
                }
            }
        }

        bfs(start[0],start[1]);

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(waterTemp[i]));
//        }

        System.out.println(visited[end[1]][end[0]]==0?"KAKTUS":visited[end[1]][end[0]]-1);


    }


    public static void bfs(int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = 1;
        queue.add(new int[]{x,y});



            int index =0;
            while(!queue.isEmpty()) {

                waterExpand();
                waterPlay();
                int size = queue.size();
                for (int l = 0; l < size; l++) {
                    int[] now = queue.poll();

                    int nowX = now[0];
                    int nowY = now[1];
                    for (int i = 0; i < 4; i++) {
                        int nextX = nowX + dx[i];
                        int nextY = nowY + dy[i];

                        if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {

                            if (map[nextY][nextX] == 'D') {
                                visited[nextY][nextX] = visited[nowY][nowX] + 1;
                                return;
                            }

                            if (visited[nextY][nextX] == 0 && (map[nextY][nextX] == '.' || map[nextY][nextX] == 'D')) {
                                visited[nextY][nextX] = visited[nowY][nowX] + 1;
                                queue.add(new int[] {nextX, nextY});
                            }

                        }

                    }
                }
                index++;
            }




    }

    public static void waterPlay(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(waterTemp[i][j]&&(map[i][j]=='.'||map[i][j]=='S')){
                    map[i][j]= '*';
                }
            }
        }
    }
    public static boolean[][] waterTemp;
    public static void waterExpand(){
        waterTemp = new boolean[N][M];

        for(int i=0; i<N; i++){
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='*'){
                    waterTemp[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nextX = j + dx[k];
                        int nextY = i + dy[k];
                        if(nextX>=0&&nextY>=0&&nextX<M&&nextY<N) {
                         if(map[nextY][nextX]=='.'||map[nextY][nextX]=='S'){
                             waterTemp[nextY][nextX] = true;
                        }
                        }
                    }
                }
            }
        }

    }
}
