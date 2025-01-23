import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_17822 {
	
	public static int N,M;
	
	public static boolean[][] visited;
	
	public static int[][] map;
	
	public static boolean check;
	
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static ArrayList<int[]> delete;

	

	public static void main(String[] args) throws IOException {

		        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		        StringTokenizer st = new StringTokenizer(br.readLine());

		        N = Integer.parseInt(st.nextToken());
		        M = Integer.parseInt(st.nextToken());
		        int T = Integer.parseInt(st.nextToken());

		        map = new int[N][M];



		        for (int i = 0; i < N; i++) {
		            st = new StringTokenizer(br.readLine());
		            for (int j = 0; j < M; j++) {
		                map[i][j] = Integer.parseInt(st.nextToken());
		            }
		        }

		        int[][] arr = new int[T][3];

		        for (int i = 0; i < T; i++) {
		            st = new StringTokenizer(br.readLine());
		            arr[i][0] = Integer.parseInt(st.nextToken());
		            arr[i][1] = Integer.parseInt(st.nextToken());
		            arr[i][2] = Integer.parseInt(st.nextToken()) % M;
		        }


		        for (int i = 0; i < T; i++) {

//		            System.out.println("변경전 : ");
//		            for (int i2 = 0; i2 < N; i2++) {
//		                System.out.println(Arrays.toString(map[i2]));
//		            }
		            int x = arr[i][0];
		            int d = arr[i][1];
		            int k = arr[i][2];
		            check = false;

		            visited = new boolean[N][M];
		            for (int j = x; j <= N; j += x) {
		                int index = j - 1;

		                if (d == 0) {

		                    map[index] = rotate(map[index], k);
		                    //System.out.println(Arrays.toString(map[index]));

		                } else {
		                    map[index] = ban_rotate(map[index], k);
		                }

		            }

		            for (int j = 0; j < N; j++) {
		                for (int l = 0; l <M ; l++) {
		                    if(!visited[j][l]&&map[j][l]!=0) {
		                        delete = new ArrayList<>();
		                        dfs(l, j, map[j][l]);

		                        if (delete.size() > 1) {
		                            check = true;
		                            for(int temp[] : delete){
		                                map[temp[1]][temp[0]]=0;
		                            }

		                        }else{
		                            visited[j][l] = false;

		                        }
		                    }
		                }
		            }

		            if (!check) {
		                double sum1 =0;
		                int count =0;
		                for (int j = 0; j < N; j++) {
		                    for (int l = 0; l < M; l++) {
		                        if(map[j][l]!=0){
		                            sum1 += map[j][l];
		                            count++;
		                        }
		                    }
		                }
		                double average = sum1 / count;


		                for (int i1 = 0; i1 < N; i1++) {
		                    for (int j1 = 0; j1 < M; j1++) {
		                        if (map[i1][j1] > average) {
		                            map[i1][j1] -= 1;
		                        } else if (map[i1][j1] < average) {
		                            if(map[i1][j1]!=0){

		                                map[i1][j1] += 1;
		                            }
		                        }
		                    }
		                }
		            }

//		            System.out.println("변경후 : ");
//		            for (int i2 = 0; i2 < N; i2++) {
//		                System.out.println(Arrays.toString(map[i2]));
//		            }
		        }





		        int sol = 0;





		        for (int i = 0; i < N; i++) {
		            //System.out.println(Arrays.toString(map[i]));
		            for (int j = 0; j < M; j++) {
		                sol += map[i][j];
		            }
		        }
		        System.out.println(sol);


		    }

		    public static int[] rotate(int[] arr,int k) {

		        int[] temp = new int[M];

		        for(int i=0 ; i<M ;i++) {

		            temp[(i+k)%M] = arr[i];

		        }

		        return temp;

		    }

		    public static int[] ban_rotate(int[] arr, int k) {
		        int[] temp = new int[M];

		        for(int i=0 ; i<M ;i++) {

		            temp[i] = arr[(i+k)%M];

		        }

		        return temp;

		    }

		    public static void dfs(int x,int y,int num) {
		        visited[y][x] = true;
		        delete.add(new int[] {x,y});


		        for(int i=0;i<4;i++) {
		            int next_x = x+ dx[i];
		            int next_y = y+ dy[i];

		            if(next_y>=N||next_y<0) {
		                continue;
		            }

		            if(next_x>=M) {
		                next_x =0;
		            }

		            if(next_x<0) {
		                next_x=M-1;
		            }

		            if(!visited[next_y][next_x]&&map[next_y][next_x]==num) {

		                dfs(next_x,next_y,num);

		            }
		        }

		    }
	

}
