package section_8;

import java.util.ArrayList;
import java.util.Scanner;

// 조합 경우의 수 구하는 것 반드시 외우기

class Point3{
    public int x,y;
    Point3(int x, int y){
        this.x = x;
        this.y = y;
    }
} // end class Point3

public class 피자배달거리 {
    static int n,m=0;
    static int answer = Integer.MAX_VALUE;
    static int[] combi_arr;
    static ArrayList<Point3> house = new ArrayList<>();
    static ArrayList<Point3> pizza = new ArrayList<>();
    public void DFS(int D, int s){  // 조합구하기
        if(D==m){  // 조합이 하나 완성
            int sum = 0;  // 도시의 피자배달거리
            for(Point3 h : house){  // 집이 하나 선택
                int dis = Integer.MAX_VALUE;
                for(int i : combi_arr){  // 조합의 인덱스 번호가 i에 대응
                    dis = Math.min(dis, Math.abs(h.x-pizza.get(i).x) + Math.abs(h.y-pizza.get(i).y));
                }
                sum+=dis;
            } // end for
            // 도시의 피자배달거리중에서도 최소값을 찾아야 한다.
            answer = Math.min(answer,sum);
        }else{
            for(int i=s; i< pizza.size(); i++){ // pizza.size() = 6
                combi_arr[D] = i;
                DFS(D+1,i+1); // 다음 인덱스에 들어갈 수는 중복이 안되니깐 i+1을 해주어야 함
            }
        } // end else
    } //  end DFS()
    public static void main(String[] args) {
        피자배달거리 T = new 피자배달거리();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi_arr = new int[m];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = kb.nextInt();
                if(tmp==1) house.add(new Point3(i,j));
                if(tmp == 2) pizza.add(new Point3(i,j));
            }
        } // end for
        T.DFS(0,0);
        System.out.println(answer);
    } // end main
}
