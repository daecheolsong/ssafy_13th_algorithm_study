
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1477 {

    static  int N , M;
    static int[]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        arr = new int[N+2];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr[0] = 0;
        arr[N+1] = L;

        Arrays.sort(arr);

        int lo = 1;
        int hi = arr[N+1]-arr[0];

        while(lo<hi){
            int mid = (lo+hi)/2;

            if(check(mid)){
                hi = mid;
            }else{
                lo = mid+1;
            }


        }

        System.out.println(lo);

    }

    public static boolean check(int mid){
        int count =0;
        for (int i = 0; i < N+1; i++) {
            count += (arr[i+1]-arr[i]-1)/mid;
        }
        return count <= M;


    }
}
