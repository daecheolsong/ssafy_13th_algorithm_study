

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_1916{

    public static int[] dist;
    public static ArrayList<Point>[] map;

    public static class Point{
        int node;
        int value;

        public Point(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dist = new int[N];
        map = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            map[start].add(new Point(end,value));

        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;
        dist[start] =0;

        di(start);

        System.out.println(dist[end]);
    }

    public static void di(int node){
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.value- o2.value);
        pq.add(new Point(node, dist[node]));

        while(!pq.isEmpty()){
            Point nowNodePoint = pq.poll();
            int nowNode = nowNodePoint.node;
            int nowValue = nowNodePoint.value;

            if(nowValue!=dist[nowNode])continue;

            for(Point nextNodePoint : map[nowNode]){
               int nextNode = nextNodePoint.node;
               int nextValue = nextNodePoint.value;

               if(dist[nextNode]>dist[nowNode]+nextValue){
                   dist[nextNode] = dist[nowNode]+nextValue;
                   pq.add(new Point(nextNode, dist[nextNode]));
               }
            }



        }



    }
}
