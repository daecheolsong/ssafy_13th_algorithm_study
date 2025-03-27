import java.io.*;
import java.util.*;

public class G4_9663 {
    
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int [] board = new int[n];
        dfs(0, board);
        System.out.println(cnt);
    }
    
    public static void dfs(int depth, int [] board) {
        if(depth == board.length) {
            cnt++;
            return;
        }
        
        for(int i = 0; i < board.length ; i++) {
            boolean flag = true;
            for(int j = 0; j < depth ; j ++) {
                if(board[j] == i || Math.abs(depth-j) == Math.abs(board[j] - i)) {
                    flag =false;
                    break;
                }
            }
            if(flag) {
                board[depth] = i;
                dfs(depth+1, board);
            }
        }
    }
}
