import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17281_양대열 {
	
	public static boolean[] isSelected;
	public static int N;
	public static int tasun[];
	public static int Max;
	public static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][9];
		isSelected = new boolean[9];
		tasun = new int[9];
		StringTokenizer st;
		
		for(int i=0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9;j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		permutation(0,0);
		
		System.out.println(Max);
		
		

	}
	
	public static void permutation(int index,int flag) {
		
		if(index==3) index++;
		
		
		if(index==9) {
			Max = Math.max(Max, play());// 타순이 다 정해지면 경기를 시작
			
			return;
		}
		
//		for(int i=1; i<9;i++){ // 순열로 풀었을때 시간 초과
//			
//			if(index==3) {
//				tasun[3] = 0;
//				permutation(index+1);
//				continue;
//			}
//			
//			if(!isSelected[i]) {
//				isSelected[i] = true;
//				tasun[index]=i;
//				permutation(index+1);
//				isSelected[i] = false;
//			}
//			
//			
//		}
		
		for(int i=1; i<9; i++) {//비트마스킹으로 풀었을때 통과  비트 마스킹을 통해 타순에 몇번 선수를 넣을지 선택
			if((flag&1<<i)!=0) continue;
				tasun[index] = i;
				permutation(index+1,flag|1<<i);
		}
		
		
		
		
		
		
	}
	
	public static int play() {// 이닝과 안타 2루타 3루타 홈런을 구현 배열로 주자의 위치를 저장
		boolean[] runner; 
		int point =0;
		
		
		int num =0;
		for(int ining =0; ining<N; ining++) {
			int out =0;
			runner =new boolean[4];
			while(true) {
				if(out==3) {
					break;
				}
				
				int result = map[ining][ tasun[num]];
				
				switch(result) {
				case 1:
					
					if(runner[2]) {
						point++;
						runner[2] = false;
					}
					
					if(runner[1]) {
						runner[1] = false;
						runner[2] = true;
					}
					
					
					if(runner[0]) {
						runner[1] = true;
						runner[0] = false;
					}
					
					runner[0] = true;
					
					break;
					
				case 2:
					if(runner[1]) {
						point++;
						runner[1] = false;
					}
					if(runner[2]) {
						point++;
						runner[2] = false;
					}
					
					if(runner[0]) {
						runner[2] = true;
						runner[0] = false;
					}
					
					runner[1] = true;
					break;
					
				case 3:
					if(runner[2]) {
						point++;
						runner[2] = false;
					}
					
					if(runner[1]) {
						point++;
						runner[1] = false;
					}
					
					if(runner[0] ){
						point++;
						runner[0] = false;
					}
					
					runner[2] = true;
					break;
					
				case 4:
					
					if(runner[2]) {
						point++;
						runner[2] = false;
					}
					
					if(runner[1]) {
						point++;
						runner[1] = false;
					}
					
					if(runner[0] ){
						point++;
						runner[0] = false;
					}
					point++;
					break;
					
				case 0:
					out++;
					break;
				
				
				}
				
				
				num++;
				if(num==9) {
					num-=9;
				}
			}
			
			
			
			
		}
		return point;
		
	}

}
