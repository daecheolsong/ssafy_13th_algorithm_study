import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1_17143 {
	static class Shark{
		int y;
		int x;
		int s;
		int d;
		int z;
		boolean isdeath;
		
		public Shark() {
			
		}
		
		
		public Shark(int y, int x, int s, int d, int z , boolean isdeath) {
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
			this.z = z;
			this.isdeath = isdeath;
			
		
		}
	}
	
	public static int map[][];
	
	public static int Y,X;
	
	public static Shark[] sharks;
	
	public static int sizeSum;
	

	
	public static void main(String[] args) throws IOException {
		

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		sharks = new Shark[M];
		map = new int[Y][X];
		
		
		
		
		for(int i=0 ; i<M ; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			map[y][x] = i+1;
			
			s = d<2?s%(2*(Y-1)):s%(2*(X-1)); // 계산 괄호 실수
			
			sharks[i] = new Shark(y,x,s,d,z,false);
			
		}
		
		int time =X;
		
		int perSonIndex =-1;
		
		while(time>0) {
			
			perSonIndex++;
			
			fishing(perSonIndex);
			
			
			moveShark();
			
//			System.out.println("최종지도");
//			for(int i=0;i<Y;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
						
			
			time--;
			//System.out.println("--------------------");
		}
		
		System.out.println(sizeSum);
		
		
	}
	
	public static void fishing(int personIndex) {
		for(int i=0; i<Y ;i++) {
			
			if(map[i][personIndex]>0) {
				sharks[map[i][personIndex]-1].isdeath = true;
				sizeSum += sharks[map[i][personIndex]-1].z;
				map[i][personIndex] = 0;
				return;
			}
		}
	}
	
	public static void moveShark() {
		
		int[] dx = {0,0,1,-1};
		int[] dy = {-1,1,0,0};
		
		int[][] temp = new int[Y][X];
		
		for(int i=0; i< Y ; i++) {
			for(int j =0; j<X ;j++) {
				if(map[i][j]>0) {
					
//					for(int h=0;h<Y;h++) {
//						System.out.println(Arrays.toString(temp[h]));
//					}
//					System.out.println();
								
					
					Shark shark = sharks[map[i][j]-1];//좌표에 있는 상어를 구한다.
					int now_y = i;
					int now_x = j;
					int z = shark.z;
					int s = shark.s;
					int next_y=i;
					int next_x=j;
//					System.out.println(z+"크기");
//					System.out.println(s);
//					
					for(int k=0;k<s; k++) {
						int d = shark.d;
						next_y = now_y + dy[d];
						next_x = now_x + dx[d];
						
//						System.out.println(now_y+": y");
//						System.out.println(now_x+": x");
//						
						
						
						if(d<2) {
							
							
							if(next_y<0||next_y>Y-1) {
								//System.out.println(d);
								shark.d = d ^ 1;
								//System.out.println(d);
								//System.out.println(z+"크기"+"방향 바꿈");
								next_y = now_y + dy[shark.d];
							}
							
						}else {
							if(next_x<0||next_x>X-1) {
								shark.d = d ^ 1;
								next_x = now_x+ dx[shark.d];
							}
							
							
						}
//						 if (next_y < 0 || next_y >= Y) {
//						        shark.d ^= 1; // 상하 방향 전환
//						        next_y = now_y + dy[shark.d]; // 새로운 방향으로 재계산
//						    }
//						    if (next_x < 0 || next_x >= X) {
//						        shark.d ^= 1; // 좌우 방향 전환
//						        next_x = now_x + dx[shark.d]; // 새로운 방향으로 재계산
//						    }
						
						now_y = next_y;
						now_x = next_x;
						
						
						
					}
					
//					System.out.println(next_y);
//					System.out.println(next_x);
					
					// 같은 칸에 상어가 있을 경우 잡아먹는 상황
					
					if(temp[next_y][next_x]!=0) {
						// 도착한 칸에 상어가 있을 경우
						
						if(sharks[temp[next_y][next_x]-1].z > z) {
							// 있었던 상어의 크기가 더 큰 경우
							shark.isdeath=true;
						}else {
							// 이제 막 온 상어의 크기가 더 큰 경우
							sharks[temp[next_y][next_x]-1].isdeath=true;
							temp[next_y][next_x] = map[i][j];
						}
						
					}else {
						

						// 무혈 입성
						
						temp[next_y][next_x] = map[i][j];
					}
					
					
				}
								
			}
		}
		
		for(int i=0; i<Y ; i++) {
			for(int j =0; j<X ; j++) {
				map[i][j]= temp[i][j];
			}
		}
		
		
		
	}
	
 


}





