import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); 
        int M = sc.nextInt(); 
        
        //최고가를 설정하고 패키지와 낱개 최소 가격 찾기
        int minPackage = 1000;
        int minPiece = 1000;
       
        //브랜드별 가격
        for (int i = 0; i < M; i++) {
            int packagePrice = sc.nextInt();
            int piecePrice = sc.nextInt();
            
            // 패키지와 낱개 최소 가격 갱신
            minPackage = Math.min(minPackage, packagePrice);
            minPiece = Math.min(minPiece, piecePrice);
        }
        
        //최소 비용 계산
        int result = Integer.MAX_VALUE;
        
        //묶음으로 살때
        result = Math.min(result, ((N + 5) / 6) * minPackage);
        
        //낱개로 살때
        for (int pack = 0; pack <= (N + 5) / 6; pack++) {
            int piece = N - (pack * 6);
            //남은 줄 낱개로 살떄
            if (piece > 0) { 
                result = Math.min(result, 
                    pack * minPackage + piece * minPiece);
            } else {
                result = Math.min(result, pack * minPackage);
            }
        }
        
        System.out.println(result);
    }
}