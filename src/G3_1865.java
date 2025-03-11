

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
    static int start;
    static ArrayList<Node>[] map;
    static int[] dist;
    static int N;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        for (int testCase = 0; testCase < TESTCASE; testCase++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            map = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                map[i] = new ArrayList<>();
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()) - 1;
                int E = Integer.parseInt(st.nextToken()) - 1;
                int T = Integer.parseInt(st.nextToken());

                map[S].add(new Node(E, T));
                map[E].add(new Node(S, T));
            }


            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()) - 1;
                int E = Integer.parseInt(st.nextToken()) - 1;
                int T = Integer.parseInt(st.nextToken()) * -1;
                start = E;
                map[S].add(new Node(E, T));
            }

            temp  = new int[N];

            for (int i = 0; i < temp.length; i++) {
                temp[i] = Integer.MAX_VALUE;
            }

            // 모든 노드에서 벨만-포드 실행하여 음수 사이클 탐지
            sb.append(belmanFord() ? "YES" : "NO").append('\n');
        }

        System.out.println(sb);
    }

    public static boolean belmanFord() {
        dist = new int[N];
        for (int start = 0; start < N; start++) {


            dist = temp;
            dist[start] = 0;  // 시작 노드 설정

            // (N-1)번 반복하여 최단 거리 계산
            for (int i = 0; i < N; i++) {
                int count =0;
                for (int here = 0; here < N; here++) {
                    if (dist[here] == Integer.MAX_VALUE) continue;
                    for (Node node : map[here]) {
                        if (dist[node.end] > dist[here] + node.value) {
                            count++;
                            dist[node.end] = dist[here] + node.value;
                            if (i == N - 1) {
                                return true;
                            }

                        }
                    }
                }
                if(count==0){
                    break;
                }
            }
        }


        return false;
    }

}
