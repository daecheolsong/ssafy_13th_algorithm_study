

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_B14002 {
    public static ArrayList<Integer> arrayList;

    public static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arrayList = new ArrayList<>();


        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        int [] dp = new int[N];
        int [] prev = new int[1001];

        int sol =0;

        for(int i=0; i< N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

        }

        for(int i=0 ; i< prev.length ; i++) {
            prev[i] = -1;
        }

        int ret = 1;

        for(int i=0; i< N ; i++) {

            for(int j =0; j < i ; j++) {
                if(arr[i]>arr[j]) {
                    if(dp[i]<dp[j]+1) {
                        dp[i] = dp[j]+1;
                        prev[i] = j;
                        if(ret<dp[i]){
                            ret=dp[i];
                            sol = i;
                        }
                    }
                }

            }
        }

        arrayList.add(arr[sol]);

        prev_method(prev,sol);

        //System.out.println(Arrays.toString(dp));

        sb.append(dp[sol]).append('\n');


        for(int i= arrayList.size()-1 ; i>=0 ; i--) {
            sb.append(arrayList.get(i)).append(" ");
        }
        System.out.println(sb);



    }

    public static void prev_method(int[] prev,int index) {
        if(prev[index]==-1) {
            return;
        }

        arrayList.add(arr[prev[index]]);
        prev_method(prev,prev[index]);

    }
}

