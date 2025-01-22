import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class G2_2632 {
	
	 public static int[] pArrA;
	 public static int[] pArrB;

	    public static int sol;

	    public static HashMap<Integer, Integer> AMap = new HashMap<>();
	    public static HashMap<Integer, Integer> BMap = new HashMap<>();
	    public static void main(String[] arg) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int solSize = Integer.parseInt(br.readLine());
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int ASize = Integer.parseInt(st.nextToken());
	        int BSize = Integer.parseInt(st.nextToken());

	        int[] arrA = new int[ASize];
	        int[] arrB = new int[BSize];
	        pArrA = new int[ASize*2];
	        pArrB = new int[BSize*2];

	        for(int i=0 ; i<ASize ; i++) {
	            arrA[i] = Integer.parseInt(br.readLine());

	        }

	        for(int i=0 ; i<BSize ; i++) {
	            arrB[i] = Integer.parseInt(br.readLine());

	        }

	        int index =0;
	        for(int i=0 ; i<pArrA.length-1;i++) {

	            pArrA[i+1] += arrA[index]+pArrA[i];

	            index++;
	            if(index==arrA.length) {
	                index=0;
	            }

	        }



	        index =0;
	        for(int i=0 ; i<pArrB.length-1;i++) {

	            pArrB[i+1] += arrB[index]+pArrB[i];

	            index++;
	            if(index==arrB.length) {
	                index=0;
	            }
	        }

//	        System.out.println(Arrays.toString(pArrA));
	//
	//
//	        System.out.println(Arrays.toString(pArrB));


	        make(ASize, pArrA, AMap );
	        make(BSize, pArrB, BMap );


	        int sol = 0;

	        sol = AMap.getOrDefault(solSize,0)+BMap.getOrDefault(solSize,0);


	        for(int i=1; i<solSize ; i++) {
	            sol += AMap.getOrDefault(i,0)*BMap.getOrDefault(solSize-i,0);
//	            System.out.println("ASize:"+makeASize+":"+make(makeASize , ASize,pArrA));
//	            System.out.println("BSize:"+makeBSize+":"+make(makeBSize, BSize,pArrB));
//	            System.out.println(sum);
	        }
	        System.out.println(sol);




	    }

	    public static void make(int size, int[] arr, HashMap<Integer,Integer> hashMap){
	        for (int cha = 1; cha <=size ; cha++) {
	            for (int start = cha; start <= size+cha-1 ; start++) {
	                int sum = arr[start] - arr[start-cha];
	                hashMap.put(sum, hashMap.getOrDefault(sum,0)+1);
	                if(cha==size) break;
	            }
	        }


	    }

//	    public static int make(int size , int size1 , int[] arr) {
//	        sol =0;
//	        if(size==0) {
//	            return 1;
//	        }
//	        for(int cha=1 ; cha<=size1 ; cha++) {
//	            for(int i =0; i<size1+cha ; i++) {
//	                if(i+cha<size1+cha) {
//	                    if(size==arr[i+cha]-arr[i]) {
//	                        sol++;
//	                    }
//	                }
//	            }
	//
//	        }
//	        return sol;
	//
	//
//	    }
}
