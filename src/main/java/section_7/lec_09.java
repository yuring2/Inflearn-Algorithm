package section_7;

// 최소 이동 횟수와 같은 문제는 bfs로 푸는 것이 맞다. 이건 연습이니까 dfs로 한 번 구현해 보겠음
// dfs같은 경우는 자식이 하나만 달린 경우는 원래 오류가 남
// 다시 들어보기

class Node3{
    int data;
    Node3 lt,rt;

    public Node3(int val){
        data = val;
        lt=rt = null;
    }
}


public class lec_09 {    // 1. static class란 건 없다.

    Node root;
    public int DFS(int L, Node root){  // 말단 노드를 만났을 때 해당 레벨을 return
        // 매개변수인 root가 계속 100번지를 가르키는 것이 아니다. 계속 바뀐다.
        if(root.lt == null && root.rt == null) return L;
        // 말단노드가 아니라면 계속 뻗어나가야 겠죠?
        else return Math.min(DFS(L+1, root.lt), DFS(L+1,root.rt));
         
    }

    public static void main(String[] args) {
        // lec_09.root
        // 2. 따라서 객체를 만들어서 사용해야 한다.

        lec_09 tree = new lec_09();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0,tree.root));
    }
}
