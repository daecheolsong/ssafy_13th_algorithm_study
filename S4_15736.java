package problem100;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long white = 0;
		// 1���� N������ ��ȣ�� �������� ��ȣ���� ������ ���ϸ� �� ������ ����� ���� ���μ�
		// �� 1���� ��ƮN������ ������ ����N ������ ���� 
		for (long i = 1; i * i <= N; i++) {
			white++;
		}
		System.out.println(white);
		sc.close();
	}
}