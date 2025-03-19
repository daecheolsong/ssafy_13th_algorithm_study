import java.util.Scanner;

public class S4_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = -1;
		
		//5로 나누는 것이 최소한의 갯수를 구하는 것이 적합하기 때문에 5의 나머지를 경우로 계산
		if (N%5 == 0) {
			count = N/5;
		}
		else if (N%5 == 1) {
			if (N>= 6) {count = N/5 + 1;}
			else count = -1;
		}
		if (N%5 == 2) {
			if (N>7) {count = N/5 + 2;}
			else count = -1;
		}
		if (N%5 == 3) {
			if (N>=8) {count = N/5 + 1;}
			else count = -1;
		}
		if (N%5 == 4) {
			if (N>= 9) {
			count = N/5 + 2;
			}
			else count = -1;
		}
		
		if (N == 3) {
			count = 1;
		}
		System.out.println(count);
	}

}
