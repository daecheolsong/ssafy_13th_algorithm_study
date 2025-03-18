

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2512 {
    static int N;
    static int M;

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max =0;
        int sum =0;
        for (int i = 0; i < N; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
            sum += arr[i];
        }

        M = Integer.parseInt(br.readLine());

        if(sum>M) {


            int lo = 1;
            int hi = 100000;
            int mid = 0;
            while (lo < hi) {
                mid = (lo + hi) / 2;

                if (check(mid)) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }


            }

            System.out.println(lo - 1);
        }else{
            System.out.println(max);
        }
    }

    public static boolean check(int mid){
        int count =0;
        for (int i = 0; i < N; i++) {
            if(arr[i]<=mid){
                count+=arr[i];
            }else{
                count+=mid;
            }
        }
        return M >= count;

    }
}
