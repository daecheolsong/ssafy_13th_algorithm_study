package problem100;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long white = 0;
		// 1부터 N까지의 번호중 제곱수인 번호들의 개수를 구하면 그 개수가 백색이 위로 놓인수
		// 즉 1부터 루트N까지의 수들이 제곱N 이하의 수가 
		for (long i = 1; i * i <= N; i++) {
			white++;
		}
		System.out.println(white);
		sc.close();
	}
}