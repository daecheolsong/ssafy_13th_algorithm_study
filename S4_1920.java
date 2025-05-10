package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        
        int N = Integer.parseInt(br.readLine());
        st =new StringTokenizer(br.readLine());
        //arrN에 N만큼 저장
        int[] arrN = new int[N];
        
        for (int i = 0; i < N; i++) {
        	arrN[i] = Integer.parseInt(st.nextToken());
        	}
        
        //이분탐색을 위해 정렬해주기
        Arrays.sort(arrN);
        
        //두번째 입력 받기
        int M = Integer.parseInt(br.readLine());
        st =new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
        	int target = Integer.parseInt(st.nextToken()); // 찾고 싶은 값
        	
        	if (binarySearch(arrN, target)) {
        		sb.append("1\n");
        	} else {
        		sb.append("0\n");
        	}
        }
        
        System.out.println(sb);
    }
    
    public static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right){
			int mid = (left + right) / 2; //중앙 인덱스
			if (arr[mid] == key) {
				return true;
			} else if (arr[mid] < key ) {
				left = mid + 1; //오른쪽
			} else {
				right = mid - 1; //왼쪽
			}
		}
		return false;
    	
    }
    
}