package main.java.section_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//간선으로 연결되면 한 집합
// 트리의 간선으로 선정을 할 것인지를 판별을 해주어야 한다. => 같은 집합인지 확인
// 회로가 안되는 간선만을 선택해서 작은 값부터 선택해나가면 된다.
class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) { // 간선의 가중치가 작은 값부터 나열하기 위함.
        return this.cost - o.cost; // 오름차순
    }
} // end class Edge
public class 원더랜드_크루스칼 {
    static int[] unf;
    static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    } // end Find()
    static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    } // end Union()

    public static void main(String[] args) {
       원더랜드_크루스칼 T = new 원더랜드_크루스칼();
       Scanner kb = new Scanner(System.in);
       int n = kb.nextInt(); // 도시의 개수
       int m = kb.nextInt(); // 도로의 개수
        unf = new int[n + 1];
        ArrayList<Edge> arr = new ArrayList<>();
        for(int i=1; i<=n; i++) unf[i] = i;
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Edge(a,b,c));
        }
        int answer = 0; // 최소비용
        Collections.sort(arr);
        for(Edge ob : arr){
            int find1 = Find(ob.v1);
            int find2 = Find(ob.v2);
            if(find1 != find2){
                answer+=ob.cost; // 둘 이 다른 집합이여서 간선을 선택한 후에
                Union(ob.v1, ob.v2); // 같은 집합으로 만들어주어야 함.
            }
        } // end for
        System.out.println(answer);
    } // end main
}
