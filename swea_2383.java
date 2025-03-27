import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static int res;
    static int N; //맵사이즈
    
    static ArrayList<Person> pList; //전체 사람
    static Stairs[] srr; //계단
    static int[] sel; // 모든 사람이 어느 계단에 할당되었는지 확인하는 선택배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t = 1; t <= TC ; t++) {
            N = sc.nextInt();
            //맵 정보 입력
            pList = new ArrayList<>();
            srr = new Stairs[2 + 1];
            int idx = 1;
            
            res = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int d = sc.nextInt();
                    if(d != 0) { //사람또는 계단
                        if(d == 1) { //사람
                            pList.add(new Person(j,i));
                        }else {
                            srr[idx] = new Stairs(j,i,d);
                            idx++;
                        }
                    }
                }
            } //입력
            /*
             * 1.사람의 계단의 부분집합으로 배정하고             * 
             */
            sel = new int[pList.size()];
            dfs(0);
            System.out.println("#" + t + " " + res);
        }

    }

    private static void dfs(int idx) {
        // TODO Auto-generated method stub
        if(idx == pList.size()) {
            res = Math.min(res, sol());
            /*
             * 3.그 두계단의 시간의 최대값 중에서 최소값을 구하여 출력하기 
             */
            return;
        }
        // 부분집합을 재귀로 만드는 방법
        sel[idx] = 1;
        dfs(idx + 1);
        sel[idx] = 2;
        dfs(idx+1);
        
    }

    private static int sol() {
        /*
         * 2.실제로 배정된 사람을 시뮬레이션해서 시간을 구하고
         * 
         */
        
        ArrayList<Integer> pList1 = new ArrayList<>();
        ArrayList<Integer> pList2 = new ArrayList<>();
        Person p;
        Stairs s;
        for(int i = 0; i < pList.size(); i++) { //전체인원만큼 반복
            p = pList.get(i); //현재 사람
            int idx = sel[i];
            s = srr[idx];
            // - 이동 시간(분) = | PR - SR | + | PC - SC |
            int time = Math.abs(p.x - s.x) + Math.abs(p.y - s.y);
            if(idx == 1) { //1번계단
                pList1.add(time);
            }else { //2 번
                pList2.add(time);
            }
        }
        /*
         * 3.그 두계단의 시간의 최대값 
         * 
         */
        int rmax = 0;
        //계단1, 계단2 시뮬레이션
        rmax = Math.max(rmax, sim(pList1, srr[1].h));
        rmax = Math.max(rmax, sim(pList2, srr[2].h));
        return rmax;
    }

    private static int sim(ArrayList<Integer> list, int h) {
        if(list.size() == 0) {
            return 0;
        }

        Collections.sort(list);// 오름차순으로 정렬
        Queue<Integer> q = new LinkedList(); //계단에 올라가 있는 사람 관리
        int idx = 0; //리스트에서 나오는 현재 사람 관리
        int time = 0;
                //while(idx < list.size()) { //시뮬레이션
                // 이곳 수정합니다 계단에 있는 사람들도 다 내려갈때까지 반복
        while(idx < list.size() || !q.isEmpty()) { //시뮬레이션
            time++;
            //1.계단에 있는 사람들 중에 계단을 다 내려간사람들 큐에서 제거 하기
            while(!q.isEmpty() && q.peek() + h <= time) {  // 빈큐에서 peek() 익센셥 발생
                q.poll();
            }
            
            //2. 새로운(리스트에 존재하는 사람) 사람을 계단에 올려놓기(계단최대인원 3명 파악해서)
            while( idx < list.size() && list.get(idx) < time && q.size() < 3) {
                q.offer(time);
                idx++;
            }
        }
        return time;
    }

    static class Person{
        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x, y;
    }
    static class Stairs{
        int x, y;
        int h;
        public Stairs(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
