import java.util.*;
import java.io.*;

public class G2_11444 {
	
	static long N;
	static final long mod = 1000000007;
	public static long[][] origin = {{1, 1} , {1, 0}};	// 초기값을 갖고있는 행렬

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[][] A = {{1, 1} , {1, 0}};
		
		N = Long.parseLong(br.readLine());
		
		System.out.println(pow(A, N - 1)[0][0]);
	}
	
	public static long[][] pow(long[][] A, long exp) {
		if(exp == 1 || exp == 0) {
			return A;
		}
		
		long[][] ret = pow(A, exp/2);
		
		ret = multiply(ret, ret);
		
		if(exp %2 == 1) {
			ret = multiply(ret, origin);
		}
		
		return ret;
	}
	
	public static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] ret = new long[2][2];
		
		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % mod;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % mod;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % mod;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % mod;
		
		return ret;
	}

}
