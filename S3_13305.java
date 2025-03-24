import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        long[] distances = new long[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }
        
        long[] prices = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }
        
        long totalCost = 0;
        long minPrice = prices[0];
        
        for (int i = 0; i < N-1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            
            totalCost += minPrice * distances[i];
        }
        
        System.out.println(totalCost);
    }
}
