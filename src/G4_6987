
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class G4_6987 {




        public static int N =6;

        public static int R = 2;

        public static ArrayList<int[]> list;
        public static int[] temp;

        public static int[][]map;

        public static boolean Success;

        public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;


            StringBuilder sb = new StringBuilder();
            for(int testCase=0; testCase<4 ; testCase++) {
                temp= new int[2];
                map = new int[6][3];
                list = new ArrayList<>();
                Success = false;
                st = new StringTokenizer(br.readLine());
                for(int i=0 ;i<6;i++ ) {

                    for(int j=0 ; j<3 ; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }

                }


                go(0,0);

                play(0);


                if(Success) {
                    sb.append(1).append(" ");
                }else {
                    sb.append(0).append(" ");
                }

            }


            System.out.println(sb);


        }


        public static void go(int index,int start) {//조합으로 모든 경기의 경우의 수 구하기!!
            if(index==R) {
                list.add(new int[] {temp[0],temp[1]});
                return;
            }


            for(int i =start ; i< N ; i++) {
                temp[index] = i;
                go(index+1,i+1);

            }

        }



        public static void play(int index) {

            if(Success) {
                return;
            }


            if(index==list.size()) {

                if(check()) {
                    Success = true;
                }
                return;
            }


            int team1 = list.get(index)[0];
            int team2 = list.get(index)[1];


            // team1 승리, team2 패배
            if (map[team1][0] > 0 && map[team2][2] > 0) {
                map[team1][0]--;
                map[team2][2]--;
                play(index + 1);
                map[team1][0]++;
                map[team2][2]++;
            }

            // team2 승리, team1 패배
            if (map[team2][0] > 0 && map[team1][2] > 0) {
                map[team2][0]--;
                map[team1][2]--;
                play(index + 1);
                map[team2][0]++;
                map[team1][2]++;
            }

            // 무승부
            if (map[team1][1] > 0 && map[team2][1] > 0) {
                map[team1][1]--;
                map[team2][1]--;
                play(index + 1);
                map[team1][1]++;
                map[team2][1]++;
            }

        }
        public static boolean check() {
            for(int i=0; i< 6 ; i++) {
                for(int j= 0; j<3 ;j++) {
                    if(map[i][j]!=0) {
                        return false;
                    }
                }
            }
            return true;
        }


}
