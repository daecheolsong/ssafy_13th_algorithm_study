package problem100;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		//�����ļ����� ����
		Arrays.sort(arr);
		
		//�� �����ͷ� ����
		int left = 0;
		int right = N - 1;
		int count = 0;
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			if(sum == x) {
				count++; //sum�� x�� ������ �ѽ��� ã��
				left++; //���� ã������ �� �����͸� ����
				right--;
			} else if (sum < x) {
				//sum���� x���� ������
				left++; //���� Ű��� ���� ���� ������ ����
			} else {
				//sum���� x���� ũ��
				right--; //���� ���̱� ���� ������ ������ ����
			}
		}
		
		System.out.println(count);
		sc.close();
		}
	}




