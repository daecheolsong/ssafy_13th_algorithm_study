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
		//오름파순으로 정렬
		Arrays.sort(arr);
		
		//투 포인터로 찢기
		int left = 0;
		int right = N - 1;
		int count = 0;
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			if(sum == x) {
				count++; //sum과 x가 같으면 한쌍을 찾음
				left++; //쌍을 찾았으니 두 포인터를 좁힘
				right--;
			} else if (sum < x) {
				//sum값이 x보다 작을떄
				left++; //값을 키우기 위해 왼쪽 포인터 증가
			} else {
				//sum값이 x보다 크면
				right--; //값을 줄이기 위해 오른쪽 포인터 감소
			}
		}
		
		System.out.println(count);
		sc.close();
		}
	}




