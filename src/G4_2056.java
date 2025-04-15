

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_2056 {
    static class Node{

        int time;

        int prev;

        public Node(int time, int prev) {
            this.time = time;
            this.prev = prev;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] map = new ArrayList[N];
        Node[] list = new Node[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());

            list[i] = new Node(time,count);
            for (int j = 0; j < count; j++) {
                int id =Integer.parseInt(st.nextToken())-1;
                map[id].add(i);
            }
        }
        int[] timeTable = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if(list[i].prev==0){
                queue.add(i);

                timeTable[i] = 0;
            }
        }

        while(!queue.isEmpty()){

            int nowNode = queue.poll();

            for (int nextNode : map[nowNode]){
                list[nextNode].prev-=1;

                timeTable[nextNode] =Math.max(timeTable[nextNode],timeTable[nowNode] + list[nowNode].time);
                if(list[nextNode].prev==0){

                    queue.add(nextNode);
                }
            }

        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, timeTable[i] + list[i].time);
        }
        System.out.println(result);

    }
}
