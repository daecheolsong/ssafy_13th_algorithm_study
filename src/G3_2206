package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {


    public static int[][] map;
    public static int[][][] visited;

    public static int N,M;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static int min = Integer.MAX_VALUE;


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];


        for(int i=0 ; i<N;i++) {
            String temp = br.readLine();
            for(int j = 0; j< M ; j++) {
                map[i][j] = temp.charAt(j)-'0';

                if(map[i][j]==1) {
                    map[i][j] = -1;
                }

            }

        }



      bfs(0,0);



        System.out.println(min==Integer.MAX_VALUE?-1:min);

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(visited[j][k][i]+ " ");
//                }
//                System.out.println();
//            }
//
//            System.out.println();
//        }


    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x,y,0});

        visited[y][x][0] += 1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_x = now[0];
            int now_y = now[1];
            int attack = now[2];

            if(now_x==M-1 && now_y == N-1){
               
                min = Math.min(min,visited[now_y][now_x][attack]);
            }

            for(int i=0; i<4 ;i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if(next_x>=0 && next_y>=0 && next_x<M && next_y<N ) {

                    if(map[next_y][next_x]==0 && visited[next_y][next_x][attack]==0) {
                        visited[next_y][next_x][attack]=visited[now_y][now_x][attack]+1;
                        queue.add(new int[]{next_x, next_y,attack});
                    }

                    if(map[next_y][next_x]==-1 && attack == 0 && visited[next_y][next_x][1]==0){
                        visited[next_y][next_x][1] = visited[now_y][now_x][attack]+1;
                        queue.add(new int[]{next_x, next_y,1});
                    }
                }
            }
        }
    }



}


