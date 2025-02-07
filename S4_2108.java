import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        
        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N]; 
        int[] freq = new int[8001]; 
        
        int sum = 0, maxFreq = 0, min = 4000, max = -4000;
        List<Integer> modeList = new ArrayList<>(); 
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            
            freq[num + 4000]++; 
            
            if (freq[num + 4000] > maxFreq) { 
                maxFreq = freq[num + 4000];
                modeList.clear();
                modeList.add(num);
            } else if (freq[num + 4000] == maxFreq) {
                modeList.add(num);
            }
            
            min = Math.min(min, num); // 최소값 갱신
            max = Math.max(max, num); // 최대값 갱신
        }
        
        Arrays.sort(arr); // 중앙값 계산정렬

        // 평균 첫째에서 반올림
        sb.append(Math.round((double) sum / N)).append("\n");

        //  중앙값
        sb.append(arr[N / 2]).append("\n");

        // 최빈값 두번째로 작은값
        Collections.sort(modeList);
        sb.append(modeList.size() > 1 ? modeList.get(1) : modeList.get(0)).append("\n");
  
        sb.append(max - min).append("\n");

        System.out.print(sb); 
    }
}
