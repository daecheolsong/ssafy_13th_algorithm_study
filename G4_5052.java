import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_5052 {		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < n; t++) {
			int m = Integer.parseInt(br.readLine());
			String[] list = new String[m];
			
			for (int i = 0; i < m; i++) {
				list[i] = br.readLine();
			}
			Arrays.sort(list);
			
			sb.append(check(list) ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean check(String[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i + 1].startsWith(list[i])) return false;
		}
		return true;
	}
}
