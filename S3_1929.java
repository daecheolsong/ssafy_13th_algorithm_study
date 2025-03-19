import java.util.Scanner;

public class S3_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] prime = new boolean[N+1];
		get_prime(prime);
		
		for(int i=M; i <= N; i++) {
			if(prime[i] == false) System.out.println(i);
		}
	}
	static boolean[] get_prime(boolean[] prime) {
		prime[0] = prime[1] = true; //0과 1은 소수가 아님
		for (int i = 2; i<=Math.sqrt(prime.length); i++) { //루드 N까지 돌면서
			if(prime[i] == true) continue;
			for(int j = i*i; j < prime.length; j+=i) { // 소수의 배수 제거
				prime[j] = true;
			}
		}
	return prime;
	}

}
