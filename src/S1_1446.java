

import java.io.*;
import java.util.*;

public class S1_1446 {

    static class Node implements Comparable<Node> {
        int pos, cost;
        Node(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        
        List<Node>[] graph = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < D; i++) {
            graph[i].add(new Node(i + 1, 1));
        }


        for (int i = 0; i < N; i++) {
            st  = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (from <= D && to <= D && to - from > cost) {
                graph[from].add(new Node(to, cost));
            }
        }


        int[] dist = new int[D + 1];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.pos] < cur.cost) continue;

            for (Node next : graph[cur.pos]) {
                if (dist[next.pos] > dist[cur.pos] + next.cost) {
                    dist[next.pos] = dist[cur.pos] + next.cost;
                    pq.offer(new Node(next.pos, dist[next.pos]));
                }
            }
        }

        System.out.println(dist[D]);
    }
}
