

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int maxValue;
    public static int tempValue;
    public static int[] dist;

    public static ArrayList<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] value = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }


       map = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }



        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int distance = Integer.parseInt(st.nextToken());

            map[start].add(new Node(end,distance));
            map[end].add(new Node(start,distance));
        }

        for (int i = 0; i < N; i++) {
            tempValue =0;
            dist = new int[N];
            for (int i1 = 0; i1< N; i1++) {
                dist[i1] = Integer.MAX_VALUE;
            }
            dist[i]=0;
            go(i);

            for (int j = 0; j < N; j++) {
                if(dist[j]<=M){
                    tempValue+=value[j];
                }
            }

            maxValue = Math.max(maxValue,tempValue);
        }
        System.out.println(maxValue);
    }

    public static void go(int startNode){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.distance-o2.distance));
        pq.add(new Node(startNode,dist[startNode]));

        while(!pq.isEmpty()){
            Node nowNodeC= pq.poll();
            int nowNode = nowNodeC.node;
            int nowNodeDistance = nowNodeC.distance;

            if(nowNodeDistance!=dist[nowNode])continue;

            for(Node nextNodeC : map[nowNode]){
                int nextNode = nextNodeC.node;
                int nextNodeDistance = nextNodeC.distance;

                if(dist[nextNode]>dist[nowNode]+nextNodeDistance){
                    dist[nextNode] = dist[nowNode]+nextNodeDistance;
                    pq.add(new Node(nextNode,dist[nextNode]));
                }

            }



        }

    }
}
