package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2170 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<int[]> arrayList = new ArrayList<>();

        for(int i=0; i<N ;i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            arrayList.add(new int[] {left,right});


        }

        Collections.sort(arrayList , new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub

                if(o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                }else {

                    return o1[0]-o2[0];
                }
            }

        });


//		for(int i=0; i< N ;i++) {
//			System.out.println(arrayList.get(i)[0]);
//
//			System.out.println(arrayList.get(i)[1]);
//		}



        int left = arrayList.get(0)[0];
        int right = arrayList.get(0)[1];

        int sol =0;

        for(int i =1; i< N ; i++) {


            int next_left = arrayList.get(i)[0];
            int next_right = arrayList.get(i)[1];


            if(right>=next_left && next_right>=right) {
                right = next_right;


            }else if(right < next_left) {
                sol += right - left;

                left = next_left;
                right = next_right;
            }



//			System.out.println(left);
//			System.out.println(right);
//
//			System.out.println("sum: "+ sol);


        }
        sol += right - left;

        System.out.println(sol);
    }

}

