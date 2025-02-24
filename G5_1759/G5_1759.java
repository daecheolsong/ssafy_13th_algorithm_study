import java.io.*;
import java.util.*;

public class G5_1759 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		char [] arr = new char[c];
		
		for(int i = 0; i < c; i ++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		char[] temp = new char[l];
		Set<String> set = new TreeSet<>();
		
		dfs(0, l, temp, arr, 0, set);
		
		for(String str : set) {
			System.out.println(str);
		}
		
	}
	
	public static void dfs(int depth, int l, char[] temp, char[] arr, int next, Set<String> set) {
		if(depth == l) {
			int moeumCnt = 0;
			int jaeumCnt = 0;
			for(int i = 0; i < temp.length; i ++) {
				if(isMoeum(temp[i])) {
					moeumCnt++;
				} else {
					jaeumCnt++;
				}
			}
			if(moeumCnt > 0 && jaeumCnt >= 2) {
				set.add(new String(temp));
			}
			return;
		}
		
		for(int i = next; i < arr.length; i ++) {
			temp[depth] = arr[i];
			dfs(depth + 1, l, temp, arr, i + 1, set);
		}
	}
	
	public static boolean isMoeum(char c) {
		return c =='a' || c == 'e' || c =='i' || c =='o' || c =='u';
	}
}
