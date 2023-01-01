package section_7;

// 이진트리순회(넓이우선탐색 : 레벨탐색)

import java.util.LinkedList;
import java.util.Queue;

class Node2{
    int data;
    Node2 lt, rt;
    public Node2(int val){
        data=val;
        lt=rt=null;
    }
}


public class lec_07 {

    Node2 root;
    public void BFS(Node2 root){
        Queue<Node2> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
       while (!Q.isEmpty()){   // 큐가 비어있으면 참 근데 부정걸어서 거짓으로 되서 반복문 탈출
           // 큐가 비어있지 않으면
           int len = Q.size();
           System.out.print(L+" : ");

           for (int i=0; i<len; i++){
               Node2 cur = Q.poll();   // 1. 큐에서 꺼내고
               System.out.print(cur.data + " "); // 2. 출력하는 것이다.
               if(cur.lt!= null) Q.offer(cur.lt);
               if(cur.rt!= null) Q.offer(cur.rt);
           }

           L++;
           System.out.println();
       }

    }

    public static void main(String[] args) {
        lec_07 tree = new lec_07();
        tree.root = new Node2(1);  // 맨 처음에 이걸 DFS에 담아서 넘긴다.
        tree.root.lt = new Node2(2);
        tree.root.rt = new Node2(3);
        tree.root.lt.lt = new Node2(4);
        tree.root.lt.rt = new Node2(5);
        tree.root.rt.lt = new Node2(6);
        tree.root.rt.rt = new Node2(7);
        tree.BFS(tree.root);  // tree.root :  1번 데이터를 가지고 있는
                              // 즉 100번지 객체이다.
    }

}
