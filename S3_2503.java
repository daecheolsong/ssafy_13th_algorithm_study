import java.io.*;
import java.util.*;

public class S3_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); // 질문 개수
        List<int[]> questions = new ArrayList<>();

        // 질문 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            questions.add(new int[]{num, strike, ball});
        }

        int answerCount = 0; // 가능한 정답 개수

        // 123~987까지의 모든 경우의 수 탐색
        for (int i = 123; i <= 987; i++) {
            if (isValidNumber(i) && isPossibleAnswer(i, questions)) {
                answerCount++;
            }
        }

        // 결과 출력
        System.out.println(answerCount);
    }

    // 숫자가 1~9까지의 서로 다른 세 자리 수인지 체크하는 함수
    private static boolean isValidNumber(int num) {
        int d1 = num / 100;       // 백의 자리
        int d2 = (num / 10) % 10; // 십의 자리
        int d3 = num % 10;        // 일의 자리

        // 중복 숫자가 있거나 0이 포함된 경우 불가능
        return (d1 != d2 && d2 != d3 && d1 != d3) && (d1 > 0 && d2 > 0 && d3 > 0);
    }

    // 해당 숫자가 모든 질문에 대해 올바른 스트라이크, 볼 개수를 만족하는지 체크
    private static boolean isPossibleAnswer(int candidate, List<int[]> questions) {
        for (int[] q : questions) {
            int givenNum = q[0];
            int givenStrike = q[1];
            int givenBall = q[2];

            if (!checkStrikeBall(candidate, givenNum, givenStrike, givenBall)) {
                return false;
            }
        }
        return true;
    }

    // 두 숫자의 스트라이크, 볼 개수 비교하는 함수
    private static boolean checkStrikeBall(int num1, int num2, int expectedStrike, int expectedBall) {
        int[] digits1 = {num1 / 100, (num1 / 10) % 10, num1 % 10};
        int[] digits2 = {num2 / 100, (num2 / 10) % 10, num2 % 10};

        int strike = 0, ball = 0;

        // 스트라이크 체크
        for (int i = 0; i < 3; i++) {
            if (digits1[i] == digits2[i]) {
                strike++;
            }
        }

        // 볼 체크
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && digits1[i] == digits2[j]) {
                    ball++;
                }
            }
        }

        return strike == expectedStrike && ball == expectedBall;
    }
}