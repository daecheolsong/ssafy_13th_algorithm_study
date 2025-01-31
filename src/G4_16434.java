import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,attack;
	
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력
		
		//방의갯수
		N = Integer.parseInt(st.nextToken());
		
		//용사의 공격력
		attack = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][3];
		
		
		for(int i=0; i< N ;i++) {
			st = new StringTokenizer(br.readLine());
			
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
			
			
		}
		
		long low = 1;
		long high = 1000000000000000000L;
		
		long sol =0;
		
		
		while(low<=high) {
			
			long mid = (low+high)/2;
			
			if(check(mid)) {
				high = mid-1;
				sol = mid;
				//System.out.println(sol);
			}else {
				
				low = mid+1;
			}
			
		}
		
		System.out.println(sol);
	}
	
	public static boolean check(long maxHp) {
		long currentHp = maxHp;
		long currentAttack = attack;
		for(int i=0; i<N ; i++) {
			int type = map[i][0];
			
			if(type==1) {
				//System.out.println("전쟁");
		
				int monsterAttack = map[i][1];
				int monsterHp = map[i][2];
				
//				while(true) {
//					monsterHp -= currentAttack;
//					//System.out.println("몬스터 hp:" + monsterHp);
//					if(monsterHp<=0) {
//						break;
//					}
//					
//					currentHp -= monsterAttack;
//					//System.out.println("플레이어 hp:" + currentHp);
//					if(currentHp<=0) {
//						return false;
//					}
				
					
					
//				}
				
				if(monsterHp % currentAttack ==0) {
					currentHp -= (monsterHp/currentAttack -1)*monsterAttack;
				} else {
					currentHp -= (monsterHp/currentAttack)*monsterAttack;
				}
				
				if(currentHp <=0) {
					return false;
				}
							
				
			}else {
				//System.out.println("힐링");
				int potionAttack = map[i][1];
				int potionHp = map[i][2];
				
				currentAttack += potionAttack;
				currentHp += potionHp;
				
				if(currentHp >= maxHp) {
					currentHp = maxHp;
				}
								
				
			}
			
			
		}
		
		return true;
	}

}
