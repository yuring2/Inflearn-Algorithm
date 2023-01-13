package section_9;

import java.util.ArrayList;
import java.util.Scanner;

// 내 풀이 : 코드 자체를 잘 못 짬

class wedding implements Comparable<wedding>{
    public int start,end;
    wedding(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(wedding o) {
        return this.start - o.start;  // 피로연에 오는시간을 오름차순으로 정렬
    }
} // end class wedding

public class 결혼식 {
    static int n = 0; // 피로연에 참석할 인원수
    static ArrayList<wedding> arr = new ArrayList<>();
    public int solution(){
        int count = 0; // 현재 피로연에 존재하는 인원수
        int Maxsum = Integer.MIN_VALUE;
        int max = 0;
        int endT=Integer.MAX_VALUE;
        for(wedding tmp : arr){
            if(tmp.start < endT){
                count++;
                endT = Math.min(endT, tmp.end);
            }else{
                Maxsum = Math.max(Maxsum,count);
                count = 1;
                endT = tmp.end;
            }
        }
        return Maxsum;
    } // end solution()
    public static void main(String[] args) {
        결혼식 T = new 결혼식();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        for(int i=0; i<n; i++){
            int s = kb.nextInt();
            int e = kb.nextInt();
            arr.add(new wedding(s,e));
        }
        System.out.println(T.solution());
    } // end main
}
