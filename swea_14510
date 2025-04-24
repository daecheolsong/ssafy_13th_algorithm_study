public class Solution {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());
        
        for(int tc = 1 ; tc <= TC ; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            int[] heights = new int[N];
            int[] diffHeights = new int[N];
            
            int max = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, heights[i]);
            }
            
            int sum = 0; // max 높이 나무만큼 커야하는 나무 키의 합
            int one=0;   // 맥스와 차이 1
            int even=0;  // 맥스의 차와 차이가 짝수
            int odd=0;   // 맥스의 차와 차이가 홀수 -> 필수적으로 1을 사용
            for(int i = 0 ; i < N ; i++) {
                diffHeights[i] = max - heights[i];
                if(diffHeights[i]==1) one++;
                if(diffHeights[i]!=1 && diffHeights[i]%2==1) {
                    even+=diffHeights[i]/2;
                    odd++;
                }
                if(diffHeights[i]!=0 && diffHeights[i]%2==0) {
                    even+=diffHeights[i]/2;
                }
                sum += diffHeights[i];
            }
            int ans=0;
            if(one+odd>even) {   
                ans=(one+odd)*2-1;  // 1 3 5 7 9 홀수 위치에 있다.
            }else { // 1+2로 만들수 있음
                 // 1+2 =3 3차이가 2일
                // 차가 20=6*3+2  12일 짝수인데 다시 2가 나오려면 2일걸림
                ans=(sum/3)*2+sum%3;
            }
           
            System.out.println("#" + tc + " " + ans);
            
        }
    }

}
