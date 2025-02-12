package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        //회원 배열 만들기
        for(int i = 0; i < N; i++) {
       	arr[i] = Integer.parseInt(br.readLine());
        }
        //앞뒤 자를 값 구하기
        int cut = Math.round((float) arr.length * (float)0.15 ) ;
        //반올림 

        //정렬
        Arrays.sort(arr);
        //자르기
        for (int i = 0, j = arr.length-1; i < cut; i++, j--) {
        	arr[i] = 0;
        	arr[j] = 0;
        }
        
        //평균 구하기
        int avg = 0;
        for(int i : arr) {
        	avg += i;
        }

        avg = Math.round(((float)avg) / ((float)arr.length-(cut*2)));    
        System.out.println(avg);
        }
}