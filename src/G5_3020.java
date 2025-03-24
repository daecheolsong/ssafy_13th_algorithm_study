

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class G5_3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());


        int[] up = new int[N/2];
        int[] down = new int[N/2];
        for (int i = 0; i < N/2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            down[i] = a;
            up[i] = b;
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int minCount =Integer.MAX_VALUE;
        int sol =0;
        for (int i = 1; i <= H; i++) {
            int count = binarySearch(0,N/2 , down,i) + binarySearch(0,N/2,up,H-i+1);
            //System.out.println(count);
            if(minCount>count){
                minCount = count;
                sol =1;

            } else if (minCount==count) {
                sol++;
            }

        }




        StringBuilder sb = new StringBuilder();

        sb.append(minCount).append(" ").append(sol);

        System.out.println(sb);
    }

    public static int binarySearch(int lo , int hi , int[] arr , int h){

        while(lo<hi){

            int mid =(lo+hi)/2;

            if(arr[mid]>=h){
                hi = mid ;
            }else{
                lo = mid+1;
            }
        }

        return arr.length- lo;


    }

}
