package section_9;
// n <= 30000이므로 이중 for문을 사용해 해결하면 시간초과

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
    public int h,w;
    Body(int h, int w){
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) {  // 씨름선수들의 키를 내림차순으로 정렬하기 위함
        return o.h - this.h;
    }
}  //end class Body

public class 씨름선수 {
    static int n = 0;
    public int solution(ArrayList<Body> arr, int n){
        int count = 0;
        Collections.sort(arr);  // 1. 위에 compareTo 메소드의 기준에 의해 정렬을 해준다.
        int max = Integer.MIN_VALUE;
        for(Body tmp : arr){
            if(tmp.w > max){
                max = tmp.w;
                count++;
            }
        } // end for
        return count;
    } // end soluiton
    public static void main(String[] args) {
        씨름선수 T = new 씨름선수();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int h = kb.nextInt();
            int w = kb.nextInt();
            arr.add(new Body(h,w));
        }// end for
        System.out.println(T.solution(arr,n));
    } // end main
}
