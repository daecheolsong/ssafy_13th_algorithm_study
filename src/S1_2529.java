import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int[] numList;
	public static boolean[] isSelected;
	public static long Max = Long.MIN_VALUE;
	public static long Min = Long.MAX_VALUE;
	public static char[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N];
	
		numList = new int[N+1];
		isSelected = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N ;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		
		permutation(0);
		
		StringBuilder minSol = new StringBuilder(String.valueOf(Min));
		StringBuilder maxSol = new StringBuilder(String.valueOf(Max));
		
		if(maxSol.length()<=N) {
			maxSol.insert(0,"0");
		}
		
		if(minSol.length()<=N) {
			minSol.insert(0,"0");
		}
		System.out.println(maxSol);
		System.out.println(minSol);
		
		
		
	}
	
	
	public static void permutation(int index) {
		
		if(index == N+1) {
			if(check()) {
				//System.out.println(Arrays.toString(numList));
				long num = arrayToNum();
				//System.out.println(num);
				Max = Math.max(Max, num);
				Min = Math.min(Min, num);
			}
			
			
			return;
		}
		
		
		for(int i =0 ; i < 10 ; i++) {
			if(!isSelected[i]) {	
				numList[index] = i;
				isSelected[i] = true;
				permutation(index+1);
				isSelected[i] = false;
				
			}
			
		}
		
		
	}
	
	public static long arrayToNum() {
		long sol =0;
		for(int i =0 ;i<numList.length;i++) {
			sol*=10;
			sol+=numList[i];
			
		}
		return sol;
		
		
	}
	
	
	public static boolean check() {
		for(int i=0 ; i< N ; i++) {
			char c = arr[i];
			
			if(c=='>') {
				if(numList[i] <= numList[i+1]) {
					return false;
				}
			}else {
				
			if(numList[i] >= numList[i+1]) {
				return false;
			}
			}
			
		}
		return true;
		
	}

}
