import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		long m = Integer.parseInt(br.readLine());
		
		long[] a = new long[(int) n];
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
			
		}
		Arrays.sort(a);
		
		
		long cnt = 0, start = 0, end=n-1;
		
		while(start < end) {
			if(a[(int) start]+a[(int) end] == m) {
				cnt++;
				start++;
				end--;
			}
			else if(a[(int) start]+a[(int) end] > m) {
				end--;
			}
			else if(a[(int) start]+a[(int) end] < m) {
				start++;
			}
		}
		System.out.println(cnt);
		
	}

}
