import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N,M;

    public static int[][] visited;

    public static boolean[][] padongVisited;


    public static char[][] map;

    public static int[] dx ={0,0,1,-1};
    public static int[] dy ={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int y1= Integer.parseInt(st.nextToken())-1;
        int x1= Integer.parseInt(st.nextToken())-1;
        int y2= Integer.parseInt(st.nextToken())-1;
        int x2= Integer.parseInt(st.nextToken())-1;

        map = new char[N][M];
        visited = new int[N][M];
        padongVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
                if(map[i][j]=='#'){
                    map[i][j]='1';
                }
            }
        }


        bfs(x1,y1,x2,y2);


        System.out.println(visited[y2][x2]-1);
    }

    public static void bfs(int x, int y, int x2,int y2){
        visited[y][x] = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int now[] = queue.poll();

            int now_x = now[0];
            int now_y = now[1];

            if(now_x==x2&&now_y==y2){
                return;
            }


            for (int i = 0; i < 4; i++) {
                int next_x = now_x+dx[i];
                int next_y = now_y+dy[i];

                if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N&&visited[next_y][next_x]==0){
                    if(map[next_y][next_x]=='1'){
                        visited[next_y][next_x] = visited[now_y][now_x] + 1;
                        queue.add(new int[]{next_x, next_y});
                    }else{
                        visited[next_y][next_x] = visited[now_y][now_x];
                        queue.addFirst(new int[]{next_x, next_y});
                    }
                }

            }




        }

    }


}
