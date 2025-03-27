import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class G4_1043 {
	
	static int[] p;
	static int N , tPersonSize;
	static int[] party;
	static int[] tPersons;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		p = new int[N];
		
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		tPersonSize = Integer.parseInt(st.nextToken());
		
		tPersons = new int[tPersonSize];
		for(int i = 0 ; i< tPersonSize ; i++) {
			tPersons[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		ArrayList<int[]> map = new ArrayList<>();
		make();
		for(int i =0 ; i< M ;i++) {
			st = new StringTokenizer(br.readLine());
			
			int size = Integer.parseInt(st.nextToken());
			int persons[] = new int[size];
			
			for(int j = 0; j<size ; j++) {
				persons[j] = Integer.parseInt(st.nextToken())-1;
			}
			
			if(size>=2) {
				for(int j = 0 ; j<size-1 ; j++) {
					union(persons[j],persons[j+1]);
				}
			}
			//System.out.println(Arrays.toString(p));
			map.add(persons);
			
		}
		
		int count =0;
		
		for(int i = 0 ; i <M ; i++) {
			party = map.get(i);
			
			if(!isSameUnion()) {
				count++;
			}	
			
		}
		
		System.out.println(count);
		
	}
	
	public static boolean isSameUnion() {
		
		for(int j = 0 ; j<party.length ; j++) {
			
			for(int k = 0; k<tPersonSize;k++) {
				
				if(find(party[j])==find(tPersons[k])) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public static void make() {
		for(int i =0 ; i < N ; i++) {
			p[i] = i;
		}
		
	}
	
	public static int find(int num) {
		if(p[num] == num) {
			return num;
		}
		
		return p[num] = find(p[num]);
	}
	
	public static boolean union(int num1 , int num2) {
		int root1 = find(num1);
		int root2 = find(num2);
		
		if(root1 == root2) {
			return false;
		}
		
		p[root2] = root1;
		
		return true;
		
		
		
	}

}
