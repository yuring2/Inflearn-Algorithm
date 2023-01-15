package main.java.section_9;
// Prim 알고리즘은 Union&Find가 아닌 PriorityQueue를 사용한다.

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge1 implements Comparable<Edge1>{
    public int vex;
    public int cost;
    Edge1(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge1 o) {
        return this.cost-o.cost;
    }
} // end class Edge
public class 원더랜드_프림 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<ArrayList<Edge1>> graph = new ArrayList<ArrayList<Edge1>>(); // 인접리스트
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge1>());
        }
        int[] ch = new int[n + 1];
        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge1(b,c));
            graph.get(b).add(new Edge1(a,c)); // 무방향이라 이렇게도 해주어야 함
        }
        int answer = 0;
        PriorityQueue<Edge1> pQ = new PriorityQueue<>();
        pQ.offer(new Edge1(1, 0));
        while (!pQ.isEmpty()){
            Edge1 tmp = pQ.poll();
            int endV = tmp.vex; // 도착정점
            if(ch[endV]==0){
                ch[endV] = 1;
                answer+=tmp.cost;
                for(Edge1 ob : graph.get(endV)){
                    if(ch[ob.vex]==0) pQ.offer(new Edge1(ob.vex, ob.cost));
                } // end for
            }
        } // end while()
        System.out.println(answer);
    } // end main
}
