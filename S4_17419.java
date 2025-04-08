package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int N = Integer.parseInt(br.readLine());
        String bS= br.readLine();
        int K = Integer.parseInt(bS, 2);  // 2진수로 변경
        
        int count = 0;
        
        // K가 0이 될 때까지 연산 반복
        while (K != 0) {
            K = K-(K&((~K)+1));
            count++;
        }
        
        System.out.println(count);
    }
}