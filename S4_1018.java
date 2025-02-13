package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static boolean[][] board;
	public static int min = 64;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        //입력 받은 보드 판 크기
        board = new boolean[N][M];
        
        //보드 칠하기
        for(int i = 0; i < N; i++) {
        	String str = br.readLine();
        	
        	for(int j = 0; j < M; j++) {
        		if(str.charAt(j) == 'W') {
        			board[i][j] = true; //화이트면 fure
        		}else {
        			board[i][j] = false; //아니면 false
        		}
        		 
        	}
        }
        
        
        //찾아야 되는 칸
        int N_row = N -7;
        int M_col = M -7;
        
        for(int i = 0; i < N_row; i++) {
        	for(int j = 0; j< M_col; j++) {
        		find(i, j);
        	}
        }
       sb.append(min);
       System.out.println(sb);
        
    }
    public static void find(int x, int y) {
    	int end_x = x+8;
    	int end_y = y+8;
    	int count = 0;
    	
    	boolean TF = board[x][y]; // 보드의 첫번째 칸 색
    	
    	for(int i = x; i < end_x; i++) {
    		for(int j = y; j < end_y; j++) {
    			
    			//올바른 색이 아니면 
    			if(board[i][j] != TF) {
    				count++;
    			}
    			
    			//다음칸 색이 바뀌므로
    			//true false 전환
    			
    			TF = (!TF);
    		}
    		TF = !TF;
    		
    		
    	}
    	count = Math.min(count, 64 - count);
    	min = Math.min(min, count);
    }
}