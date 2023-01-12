package section_9;
// 인덱스는 정점번호를 의미
// dis[3] : 1번 정점에서 3번 정점까지 가는 최소비용

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 그래프에 다익스트라 알고리즘을 적용할 때 전제조건 : 그래프 간선의 가중치 값이 음수면 안된다.
// priorityqueue : 큐에 들어있는 값 중 가장 최소값을 찾는데 걸리는 시간 logn

class Edge implements Comparable<Edge>{
    public int vex; // 정점
    public int cost; // 비용
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    // 이 메서드의 기준에 의해 poll()이 된다.
    public int compareTo(Edge o) {  // priorityqueue는 이 기준을 보고 가장 작은값을 우선으로 한다. 가장 작은 값을 우선으로 poll()을 시켜준다.
        return this.cost - o.cost; // 오름차순
    }
} // end class Edge
public class 다익스트라알고리즘 {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v,0));
        dis[v] = 0;
        while(!pQ.isEmpty()) { // 다익스트라
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > ob.cost + nowCost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            } // end for
        } // end while
    } // end solution()
    public static void main(String[] args) {
        다익스트라알고리즘 T = new 다익스트라알고리즘();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        } // end for
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b,c));
        } // end for
        T.solution(1); // 1번 정점에서 출발
        for(int i=2; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i+ " : "+dis[i]);
            else System.out.println(i+ " : impossible"); // 무한대 값이 갱신이 안되고 그대로 있는 경우
        }
    } // end main
}
