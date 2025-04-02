
import java.io.*;
import java.util.*;


public class G4_1062 {

	static int n;
	static int k;
	static int rep;
	static String [] list;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		rep |= (1 << ('a' - 'a'));
		rep |= (1 << ('n' - 'a'));
		rep |= (1 << ('t' - 'a'));
		rep |= (1 << ('i' - 'a'));
		rep |= (1 << ('c' - 'a'));
		
		list = new String[n];
		
		if(k < 5) {
			System.out.println(0);
			return;
		}
		
		if(k >= 26) {
			System.out.println(n);
			return;
		}
		
		for(int i = 0; i < n; i ++) {
			String s = br.readLine();
			list[i] = s;
		}
		dfs(0, 0);
		System.out.println(answer); 
	}
	
	public static void dfs(int idx, int cnt) {
	
		if(cnt == k - 5) {
			int readCnt = 0;
			for(int i = 0; i < n; i ++) {
				String s = list[i];
				boolean canRead = true;
				for(int j = 0; j < s.length(); j ++) {
					char c = s.charAt(j);
					if((rep & (1 << (c - 'a'))) == 0) {
						canRead = false;
						break;
					}
				}
				if(canRead) {
					readCnt++;
				}
			}
			
			answer = Math.max(answer, readCnt);
		}
		
		for(int i = idx; i < 26; i ++) {
			if((rep & (1 << i)) == 0) {
				rep |= (1 << i);
				dfs(i + 1, cnt + 1);
				rep &= ~(1 << i);
			}
		}
		
	}
	

}
