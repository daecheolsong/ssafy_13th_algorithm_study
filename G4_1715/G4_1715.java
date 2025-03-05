import java.util.*;
import java.io.*;

public class G4_1715 {

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> q  = new PriorityQueue<>();
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n ; i++) {
            q.offer(Long.parseLong(br.readLine()));
        }
        
        long res = 0;
        
        while(q.size() > 1)
        {
           long sum = 0;
           sum += (q.poll()+q.poll());
           res += sum;
           q.offer(sum);
           
        }
        System.out.println(res);
    }
}
