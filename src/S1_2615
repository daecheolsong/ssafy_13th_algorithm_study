

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S1_2615 {

    public static int[] dx = {1,1,1,0,0,-1,-1,-1};
    public static int[] dy = {1,-1,0,1,-1,1,0,-1};

    public static int N;

    public static int[][] map;

    public static ArrayList<int[]> sol1;
    public static ArrayList<int[]> sol2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        sol1 = new ArrayList<>();
        sol2 = new ArrayList<>();

        N = 19;

        map = new int[19][19];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(map[i][j]==1){
                    check(j,i,1);
                }else if(map[i][j]==2){
                    check(j,i,2);
                }

            }
        }

        Collections.sort(sol1 , (item1,item2)->Integer.compare(item1[0],item2[1]));
        Collections.sort(sol2 , (item1,item2)->Integer.compare(item1[0],item2[1]));

        if(sol1.size()==0&&sol2.size()==0){
            sb.append(0).append('\n');
        }else if(sol1.size()>0&&sol2.size()==0){
            sb.append(1).append('\n');
            sb.append(sol1.get(0)[1]+1).append(" ").append(sol1.get(0)[0]+1);
        }else if(sol1.size()==0 && sol2.size()>0){
            sb.append(2).append('\n');
            sb.append(sol2.get(0)[1]+1).append(" ").append(sol2.get(0)[0]+1);
        }
        //System.out.println(sol2.size());
        System.out.println(sb);
    }


    public static void check(int x,int y, int num){

        for (int i = 0; i < 4; i++) {
            int now_x = x;
            int now_y = y;
            int index_x = dx[i];
            int index_y = dy[i];
            int count =1;

            while(true){
                int next_x = now_x + index_x;
                int next_y = now_y + index_y;

                if(arrayCheck(next_x,next_y)){
                    if(map[next_y][next_x]==num){
                        count++;
                        now_x = next_x;
                        now_y = next_y;
                    }else{
                        break;
                    }


                }else{
                    break;
                }

            }


            if(count==5){
                if(!check6(x,y,i,num)){
                    if(num == 1){
                        sol1.add(new int[]{x,y});
                    }else if (num ==2){
                        sol2.add(new int[]{x,y});
                    }
                }

            }

        }

    }

    public static boolean check6(int x,int y, int index , int num){
        int next_x = x+dx[index]*-1;
        int next_y = y+dy[index]*-1;

        if(arrayCheck(next_x,next_y)){
            if(map[next_y][next_x]==num){
                return true;
            }
        }
        return false;

    }


    public static boolean arrayCheck(int x,int y){
        return x>=0 && y>=0 && x<N && y<N;
    }
}
