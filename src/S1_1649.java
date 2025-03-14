

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_1946 {

    static int[] arr;
    static  int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TEST_CASE = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < TEST_CASE ; testCase++) {
            N=  Integer.parseInt(br.readLine());


            StringTokenizer st;
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a-1] = b;


            }
            int count =0;
            int gizun =arr[0];
            for (int i = 0; i < N; i++) {
                if(gizun<arr[i]){
                    count++;
                }else{
                    gizun = arr[i];

                }
            }

            sb.append(N-count).append('\n');

        }
        System.out.println(sb);

    }

//    static boolean check(int person){
//        for (int i = 0; i < person; i++) {
//            if(arr[i]<arr[person]){
//                return  true;
//            }
//        }
//        return false;
//    }



}
