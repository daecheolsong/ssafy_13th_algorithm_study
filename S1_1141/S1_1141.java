import java.io.*;
import java.util.*;


public class S1_1141 {
	
	static int n;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i < n; i ++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
		
		
		int answer = n;
		for(int i = 0; i < n; i ++) {
			String src = list.get(i);
			for(int j = i + 1; j < n; j ++) {
				String target = list.get(j);
				if(!isValid(target, src)) {
					answer--;
					break;
				}
			}
			
			
		}
		
		System.out.println(answer);
		
		
	}
	
	public static boolean isValid(String s1, String s2) {
		int minL = Math.min(s1.length(), s2.length());
		
		int sameCnt = 0;
		for(int i = 0; i < minL; i ++) {
			if(s1.charAt(i) == s2.charAt(i)) {
				sameCnt ++;
			}
		}
		
		if(sameCnt == minL) {
			return false;
		}
		return true;
	}
	
	
}
