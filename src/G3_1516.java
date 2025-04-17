import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1516 {
	static class Game{
		int id;
		int time;
		int prev;
		public Game(int id,int time, int prev) {
			super();
			this.id = id;
			this.time = time;
			this.prev = prev;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Integer>[] map = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) {
			map[i] = new ArrayList<>();
		}
		Game[] gameList = new Game[N];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			gameList[i] = new Game(i,time, 0);
			while(true) {
				int node = Integer.parseInt(st.nextToken());
				if(node==-1) {
					break;
				}
				map[node-1].add(i);
				gameList[i].prev+=1;
			}
		}
		
//		for(int i = 0 ; i< N ; i++) {
//			System.out.println(map[i]);
//		}
		
		
		Queue<Game> queue = new ArrayDeque<>();
		int timeTable[] = new int[N];
		
		
		for(int i = 0 ; i<N ; i++) {
			Game game = gameList[i];
			if(game.prev==0) {
				queue.add(game);
				timeTable[i] = game.time;
			}
		}
		
		
		while(!queue.isEmpty()) {
			
			Game nowGame = queue.poll();
			
			for(int nextGame : map[nowGame.id]) {
				
				gameList[nextGame].prev-=1;
				
				timeTable[nextGame] = Math.max(timeTable[nextGame],timeTable[nowGame.id]+gameList[nextGame].time);
				if(gameList[nextGame].prev==0) {
					queue.add(gameList[nextGame]);
				}
				
			}
			
			
		}
		
		//System.out.println(Arrays.toString(timeTable));
		
		StringBuilder sb  =new StringBuilder();
		for(int num : timeTable) {
			sb.append(num).append('\n');
		}
		System.out.println(sb);
		
	}

}
