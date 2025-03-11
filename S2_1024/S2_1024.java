import java.io.*;
import java.util.*;

public class S2_1024 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int a = -2;
        int l = 0;
        for(int i = L; i <= 100; i ++) {
            if((2 * N - i * i - i) % (2 * i) == 0) {
                a = (2 * N - i * i - i) / (2 * i);
                l = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
       
        if(a < -1) {
            System.out.println(-1);
            return;
        } else {
            for(int i = 1; i <= l ; i ++) {
                sb.append((a + i) + " ");
            }
            sb.append("\n");
      
        }     
        System.out.println(sb);
        
    }
}
