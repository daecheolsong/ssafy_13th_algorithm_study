import java.util.Arrays;
import java.util.Scanner;

public class G4_2110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] houses = new int[N];
		
		for(int i = 0; i < N; i++) {
			houses[i] = sc.nextInt();
		}
		
		Arrays.sort(houses);
		
		int lo = 1; // 최소 거리값
		int hi = houses[N-1] - houses[0]; // 최대 거리값
		
		while(lo<hi) {
			int mid = (hi + lo +1) / 2; //+1 을 안하면 무한굴레가 일어날 수 있음 +1을 해줌으로써 중복숫자 생성 방지
			if (installcheck(mid, houses) < C ) {
				hi = mid-1; //installcheck로 나온 공유기의 갯수가  C보다 작다면 거리를 줄여서 다시 확인
			}
			else {
				lo = mid; // C와 같거나 크다면 거리를 늘려서 다시 확인 만약 lo가 hi보다 커진다면 종료
			}
		}
		System.out.println(lo);

	}
	
	static int installcheck(int distance, int[] houses) {
		int count = 1; // 설치 공유기 갯수
		int lastinstall = houses[0]; //첫번째 집 설치 (제일 최근 설치 집 저장 변수)
		
		for(int i = 1; i < houses.length; i++) {
			if (houses[i] - lastinstall >= distance) { // 거리안에 들어있는 집이라면 count세고 lastinsatll 갱신
				count++;
				lastinstall = houses[i];
			}
		}
		
		return count;
	}

}
