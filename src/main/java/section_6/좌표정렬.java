package section_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Point implements Comparable<Point>{
    public int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {  // 정렬하는 기준을 잡아주는 메서드
        if(this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
} // end class Point

public class 좌표정렬 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Point(x,y));
        } // end for

        Collections.sort(arr);  // sort()는 호출되면 정렬의 기준을 compareTo() 메소드로 잡고 정렬을 해준다.
        for(Point tmp : arr) System.out.println(tmp.x + " " + tmp.y);
    } // end main
}
