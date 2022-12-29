package section_7;

// 부분집합구하기(DFS)

public class lec_06 {
    // 아래 두 줄 static으로 해준 이유 : static함수가 접근해야 하기 때문에(main함수)
    static int n; // 집합의 원소의 개수
    static int[] ch; // 체크배열
    public void DFS(int L){
      if(L==n+1){   // 체크배열을 확인해서 1로 체크되어있는 배열방의 인덱스를 출력
         String tmp="";
         for(int i=0; i<=n; i++){
             if(ch[i]==1) tmp+=(i+" ");
         }

         if(tmp.length()!=0) System.out.println(tmp);  // 공집합인 경우는 출력 제외
      }else{
          // 노드 하나 당 이 두 가지 경우를 다 거친다.
          // 1.
          ch[L] = 1;
          DFS(L+1); // 왼쪽으로 뻗 (사용한다)


          // 2.
          ch[L] = 0;
          DFS(L+1);  // 오른쪽으로 뻗 (사용하지 않는다)

      }
    }
    public static void main(String[] args) {
        lec_06 T = new lec_06();
        n = 3;
        ch = new int[n+1];  // 체크배열의 인덱스 번호를 원소로 생각. 따라서 1~3까지가 생겨야 한다.
        T.DFS(1);

    }
}
