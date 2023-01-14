package section_9;

import java.util.Scanner;

// Disjoint-Set : 서로소 집합(두 집합이 서로 공통인 원소가 없다.)
// 이 문제는 서로소 집합을 만들면 해결이 되는데, 서로소 집합을 만드는데 사용하는 알고리즘으로 Union&Find를 사용한다.
// 배열 unf의 인덱스번호는 학생번호라고 생각, 배열의 값은 집합의 번호라고 생각. 처음에 모든 학생은 각각 다른 집합으로 초기화
// 같은 집합에 있으면 모두 친구관계이다.
public class 친구인가 {
    static int[] unf;
    public static int Find(int v){ // v번 학생의 집합번호를 return해주는 메소드
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    } // end find

    public static void Union(int a, int b){ // a와 b를 같은 집합으로 만들어주는 메소드
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    } // end Union
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 학생수
        int m = kb.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i] = i;
        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            Union(a,b); // a와 b를 같은 집합으로 만들어주는 작업
        } // end for

        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    } // end main
}
