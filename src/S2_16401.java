import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_16401 {
	
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i< N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lo = 0;
		int hi = 1000000000;
		int mid = 0;
		while(lo<hi) {
			mid = (lo+hi)/2;
			
			if(mid==0) {
				lo = 1;
				break;
			}
			
			if(check(mid)) {
				
				hi = mid;
				
			}else {
				
				lo = mid+1;
			}
			
			
		}
		System.out.println(lo-1);
	}
	
	public static boolean check(int mid) {
		int count =0;
		
		
		
		for(int i = 0 ; i < N ; i++) {
			count += arr[i]/mid;
			
		}
		
		return count < M;
		
		
		
	}

}
