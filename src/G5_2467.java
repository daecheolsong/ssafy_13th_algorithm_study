import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2467 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for(int i = 0 ;i < N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long Min = Long.MAX_VALUE;
		int sol1 = -1;
		int sol2 = -1;
		
		for(int i = 0 ; i< N-1 ; i++) {
			int index = i;
			int lo = i+1;
			int hi = N-1;
			
			while(lo<=hi) {
				int mid = (lo+hi)/2;
				long sum = Math.abs(arr[i]+arr[mid]);
				
				if(Min>sum) {
					Min = sum;
					sol1 = index;
					sol2 = mid;
				}
				
				if(arr[mid]+arr[index]>0) {
					hi = mid-1;
				}else {
					lo = mid+1;
				}
				
				
			}
			
		}
		System.out.println(arr[sol1]+" "+arr[sol2]);
	}

}
