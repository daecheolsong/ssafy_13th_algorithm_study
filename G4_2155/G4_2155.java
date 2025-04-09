import java.util.*;
import java.io.*;

public class G4_2155 {

	
	public static int getRow(int x) {
		int L = 1, R = 31663; // 31622^2 ~= 1e9이므로 upper bound로 충분
		while (L < R) {
			int mid = (L + R) / 2;
			if (mid * mid >= x)
				R = mid;
			else
				L = mid + 1;
		}
		return L;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

		if (A > B) {
			int temp = A;
			A = B;
			B = temp;
		}

		int rowA = getRow(A), rowB = getRow(B);
		int ll = A, rr = A;
		int moves = 0;

		while (rowA < rowB) {
			if ((ll & 1) == (rowA & 1)) {
				ll += rowA * 2;
				rr += rowA * 2;
				rowA++;
				moves++;
			} else {
				ll--;
				rr++;
				moves++;
			}
		}

		if (B < ll)
			System.out.println(moves + (ll - B));
		else if (rr < B)
			System.out.println(moves + (B - rr));
		else {
			if ((ll & 1) == (B & 1))
				System.out.println(moves);
			else
				System.out.println(moves + 1);
		}
	}
}
