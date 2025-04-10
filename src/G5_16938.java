import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_16938 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sol =0;
		for(int bit = 0 ; bit < (1<<N) ; bit++) {
			int count =0;
			int sum =0;
			int max =0;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i< N ; i++) {
				if((bit&(1<<i))!=0){
					count++;
					sum+=arr[i];
					max = Math.max(max, arr[i]);
					min = Math.min(min, arr[i]);
				}
				
			}
			if(count>=2 &&L<= sum && sum<=R && max - min >=X) {
				sol++;
			}
			
			
		}
		System.out.println(sol);
	}

}
