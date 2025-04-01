
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G3_4386 {

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight,o.weight);
        }
    }

    static class Star{
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static List<Edge> edgeList;
    static Star[] stars;

    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        edgeList = new ArrayList<>();
        stars = new Star[N];
        selected = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i] = new Star(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
        }
        combi(0,0);

        Collections.sort(edgeList);
        make();

        double result = 0;
        int count =0;
        for(Edge edge : edgeList){
            int from = edge.from;
            int to = edge.to;
            double weight = edge.weight;

            if(union(from,to)){
                result += weight;
                if(++count == N-1){
                    break;
                }
            }

        }

        System.out.println(result);

    }

    public static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB){
            return  false;
        }

        if(rootA<rootB){
            p[rootA] =  rootB;
        }else{
            p[rootB] = rootA;
        }
        return  true;

    }

    public static int find(int a){
        if(p[a] ==a){
            return a;
        }

        return p[a]= find(p[a]);
    }
    static int[] p;
    public static void make(){
        p= new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
    }

    public static void combi(int index ,int start){
        if(index==2){
            add(selected);
            return;
        }

        for (int i = start; i < N; i++) {
            selected[index] = i;
            combi(index+1, i+1);
        }

    }

    public static void add(int[] selected){
        int a = selected[0];
        int b = selected[1];

        double weight =  getDistance(stars[a].x,stars[a].y , stars[b].x , stars[b].y);

        edgeList.add(new Edge(a,b,weight));
    }


    public static double getDistance(double x,double y , double x1,double y1){
        return Math.sqrt(Math.pow((x-x1),2)+Math.pow((y-y1),2));
    }
}
