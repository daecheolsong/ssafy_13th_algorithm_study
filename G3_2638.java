import java.io.*;
import java.util.*;

class G3_2638 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int n, m;
	static int[][] arr;
	static int[][] temp;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        temp = new int[n][m];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for (int j = 0; j < m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int time = 1;
        
        // 1. 내부 공기인지 판단
        // 2. 외부 공기와 2개 이상 닿았을 경우 녹음
        // 3. 
        
        while (true) {
        	int[][] temp = new int[n][m];
        	boolean[][] visit = new boolean[n][m];
        	
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < m; j++) {
        			temp[i][j] = arr[i][j];
        		}
        	}
        	
        	int check = 2;
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < m; j++) {
        			if (temp[i][j] == 0) {
        				temp = airCheck(i, j, check, temp, visit);
        				check++;
        			}
        		}
        	}
        	
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < m; j++) {
        			if (arr[i][j] == 1) {
        				cheeseCheck(i, j, temp);
        			}
        		}
        	}
        	
        	boolean cheese = false;
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < m; j++) {
        			if (arr[i][j] == 1) {
        				cheese = true;
        				break;
        			}
        		}
        		if (cheese)
        			break;
        	}
        	
        	if (cheese) {
        		time++;
        	} else {
        		break;
        	}
        }
        
        System.out.println(time);
    }
    
    // 내부 공기 판단 
    static int[][] airCheck(int x, int y, int check, int[][] temp, boolean[][] visit) {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {x, y});
    	
    	while (!q.isEmpty()) {
    		int x1 = q.peek()[0];
    		int y1 = q.peek()[1];
    		temp[x1][y1] = check;
    		q.poll();
    		
    		for (int i = 0; i < 4; i++) {
    			int cx = x1 + dx[i];
    			int cy = y1 + dy[i];
    			
    			if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
    				if (!visit[cx][cy] && temp[cx][cy] == 0) {
    					visit[cx][cy] = true;
        				q.add(new int[] {cx, cy});
    				}
    			}
    		}
    	}
    	
    	return temp;
    }
    
    // 치즈가 녹을 위치인지 판단
    static void cheeseCheck(int x, int y, int[][] temp) {
    	int count = 0;
    	for (int i = 0; i < 4; i++) {
    		int cx = x + dx[i];
    		int cy = y + dy[i];
    		
    		if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
    			if (temp[cx][cy] == 2) {
    				count++;
    			}
    		}
    	}
    	
    	if (count >= 2) {
    		arr[x][y] = 0;
    	}
     }
}
