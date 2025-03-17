package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B24479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken())-1;

        map = new ArrayList[N];
        visited = new int[N];

        for (int i = 0; i < N; i++) {
            map[i]  = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            map[s].add(e);
            map[e].add(s);

        }

        dfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(visited[i]).append('\n');
        }

        System.out.println(sb);

    }
    static ArrayList<Integer>[] map;
    static int[] visited;

    static int count =1;
    public static void dfs(int node){
        visited[node] = count;

        ArrayList<Integer> temp = map[node];
        Collections.sort(temp);
        for(int nextNode : temp){
            if(visited[nextNode] ==0 ){
                count++;
                dfs(nextNode);
            }


        }


    }
}
