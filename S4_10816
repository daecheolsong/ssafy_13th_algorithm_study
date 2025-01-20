import java.util.Arrays;
import java.util.Scanner;

public class S4_10816 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // 1번 배열 크기 변수
		int[] list1 = new int[num]; // 1번 배열 할당
		for (int i = 0; i < num; i++) {
			list1[i] = sc.nextInt(); // 1번 배열 저장
		}
		Arrays.sort(list1); // 배열 정렬! 이진탐색을 하려면 정렬이 되어있어야함
		int num2 = sc.nextInt();
		StringBuilder result = new StringBuilder(); // 결과값 저장
		//int[] list2 = new int[num2];
		for (int i = 0; i < num2; i++) { // 배열로 저장하면 시간초과가 뜸. 그때그때 key값으로 받고 바로 함수호출
			int key = sc.nextInt();
//			list2[i] = upper(list1, key) - lower(list1, key);
//			System.out.print(list2[i] + " ");
			result.append(upper(list1, key) - lower(list1, key)).append(' '); 
		}
		System.out.println(result);
		
	}
	static int upper(int[] list1, int key) { // key 값과 똑같은 값을 가진 인덱스 중 큰 값 저장
		int low = 0;
		int high = list1.length;
		
		while(low<high) {
			int mid = (low + high) / 2;
			
			if (key<list1[mid]) { // 차이점
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	static int lower(int[] list1, int key) { // key 값과 똑같은 값을 가진 인덱스 중 작은 값 저장
		int low = 0;
		int high = list1.length;
		
		while(low<high) {
			int mid = (low + high) / 2;
			
			if (key<=list1[mid]) { // 차이점
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return low;
	}

}
