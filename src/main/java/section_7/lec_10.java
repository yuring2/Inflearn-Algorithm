package section_7;
// tree 말단 노드까지의 가장 짧은 경로(bfs)
// BFS는 자식이 하나만 있어도 괜찮다.

import java.util.LinkedList;
import java.util.Queue;

class Node4{
    int data;
    Node4 lt,rt;

    public Node4(int val){
        data = val;
        lt=rt = null;
    }
}


public class lec_10 {
    Node4 root;
    public int BFS(Node4 root){
        Queue<Node4> Q = new LinkedList<>();
        Q.offer(root);
        int L=0;
        while(!Q.isEmpty()){  // 큐가 비어있으면 거짓이 되면서 반복문을 탈출 (큐가 비어있지 않으면 계속 돈다.)
          int len = Q.size();  // 레벨의 길이를 구한다.
          for(int i=0; i<len; i++){  // 해당 레벨의 노드를 다 꺼내야한다
              Node4  curr = Q.poll();
              if(curr.lt == null && curr.rt == null) return L;
              // 말단노드가 아니면
              if(curr.lt != null) Q.offer(curr.lt);
              if(curr.rt != null) Q.offer(curr.rt);
          }  // end for (for문이 끝나면 한 레벨이 끝난거지?)
            // 그럼 레벨을 증가
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        lec_10 tree = new lec_10();
        tree.root = new Node4(1);
        tree.root.lt = new Node4(2);
        tree.root.rt = new Node4(3);
        tree.root.lt.lt = new Node4(4);
        tree.root.lt.rt = new Node4(5);
        System.out.println(tree.BFS(tree.root));
    }
}
