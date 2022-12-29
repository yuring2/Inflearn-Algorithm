package section_7;

// 이진트리 순회(DFS : DEEP FIRST SEARCH (깊이 우선 탐색)

class Node{
    int data;
    Node lt, rt;  // 왼쪽 자식의 노드주소와 오른쪽 자식의 노드 주소를 저장하는 변수
    public Node(int val){
        data=val;
        lt=rt=null;   // 객체가 생성되는 순간에는 null값이다.
    }
        }


public class lec_05 {
    Node root;    // 아직 new는 한 것이 아님. root : Node클래스 객체의 주소를 저장하는 변수 (주소만 할당받은 상태)
    public void DFS(Node root){
        if(root == null) return; // 말단노드이면 return
        else{
            DFS(root.lt);   // 1. 일단 왼쪽집부터 깊에 파고든다.
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
         //Node.lt
         lec_05 tree = new lec_05();
         tree.root = new Node(1);  // 맨 처음에 이걸 DFS에 담아서 넘긴다.
         tree.root.lt = new Node(2);
         tree.root.rt = new Node(3);
         tree.root.lt.lt = new Node(4);
         tree.root.lt.rt = new Node(5);
         tree.root.rt.lt = new Node(6);
         tree.root.rt.rt = new Node(7);
         tree.DFS(tree.root);  // tree.root :  1번 데이터를 가지고 있는
                              // 즉 100번지 객체이다.
    }
}
