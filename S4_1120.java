package algo;
import java.util.*;

public class S4_1120 {
	public static void main(String[] args) {
        
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int count = Integer.MAX_VALUE;
		
		if (s1.length() == s2.length()) {
			int temp = 0;
			for (int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					temp += 1;
				}
			}
			count = Math.min(temp, count);
		} else if (s1.length() < s2.length()) {
			int size = s1.length();
			for(int i = 0; i <= s2.length() - size; i ++) {
				String substr = s2.substring(i, i + size);
				int temp = 0;
				for (int j = 0; j < s1.length(); j++) {
					if(s1.charAt(j) != substr.charAt(j)) {
						temp += 1;
					}
				}
				count = Math.min(temp, count);
			}
		
		
		} else {
			System.out.println("잘못입력하셨습니다.");
		}
		
		System.out.println(count);
		
//		System.out.println(s1);
//		System.out.println(s2);
		
//    	char c = s1.charAt(0);
//    	System.out.println(a.indexOf("b"));
//        	    
//    	for(int i = 0; i < s1.length(); i ++) {
//    		System.out.println(a.charAt(i));
//    	}
    }

}
