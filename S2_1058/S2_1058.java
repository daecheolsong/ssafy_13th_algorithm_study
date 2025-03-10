import java.util.*;
import java.io.*;

public class S2_1058 {
    
    public static void main(String[] arsg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [][] arr = new String[n][n];
        for(int i = 0; i < n ; i ++) {
            arr[i] = br.readLine().split("");
        }
        int answer = 0;
        
        for(int i = 0; i < n ; i ++) {
            int cnt = 0;
            for(int k = 0; k < n ; k ++) {
                if(k == i) {
                    continue;
                }
                for(int j = 0; j < n ; j ++) {
                    if(arr[k][j].equals("Y")) {
                        if(arr[i][j].equals(arr[k][j]) || arr[i][k].equals(arr[k][j])) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
