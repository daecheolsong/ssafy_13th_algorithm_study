import java.util.*;
import java.io.*;

public class G5_5430 {
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String str = br.readLine();
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> list = new LinkedList<>(); //reverse로 인해 deque로 선언
			String str2 = br.readLine();
			str2 = str2.replaceAll("[\\[\\]]", ""); //대괄호 제거
			String[] nums = str2.split(","); //쉼표 기준으로 숫자 분리

			if (!nums[0].equals("")) { //list에 추가
			    for (String num : nums) {
			        list.add(Integer.parseInt(num));
			    }
			}
			
			boolean reverse = false; //뒤집어졌는지 flag
			boolean flag = false; //에러 flag
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'R') { //R이라면? 뒤집기 flag 갱신
					reverse = !reverse;
				}
				if (str.charAt(j) == 'D') { //D라면?
					if (!list.isEmpty()) {
						if (reverse) { //뒤집어져있을땐 뒤에서 제거
							list.pollLast();
						}
						else { //안뒤집어졌으면 앞에서 제거
							list.pollFirst();
						}
					}
					else { //리스트가 비어있으면 에러 발생
						System.out.println("error");
						flag = true;
						break;
					}
				}
				
			}
			
			if (!flag) { //에러가 발생하지 않았다면?
				StringBuilder st = new StringBuilder();
				st.append("[");
				while (!list.isEmpty()) {
                    st.append(reverse ? list.pollLast() : list.pollFirst()); //뒤집기가 켜져있으면 뒤에서부터 추가, 아니라면 앞에서부터 추가
                    if (!list.isEmpty()) st.append(",");
                }
				st.append("]");
				System.out.println(st);
			}
			
		}
	}
}
