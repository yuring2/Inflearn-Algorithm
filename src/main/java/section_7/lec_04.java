package section_7;

// 피보나치 수열(재귀)

// 이건 별로 좋은 코드가 아니다. n의 값이 커질수록 한참이 걸린다.
/*class lec_04 {
    public int DFS(int n){
        if(n==1) return 1;   // 첫 번째 항 1 리턴
        else if(n==2) return 1;  // 두 번째 항 2 리턴
        else return DFS(n-1)+DFS(n-2);
    }
    public static void main(String[] args) {
        lec_04 T = new lec_04();
        int n = 10;
        for(int i=1; i<=n; i++) System.out.print(T.DFS(i) + " ");

    }
}*/

class lec_04{
    static int[] fibo;   // static으로 해주어야 static함수(main)에서도 사용 가능하고 인스턴스 함수에서도 사용 가능하다.

    public int DFS(int n){
        if(fibo[n] != 0 ) return fibo[n];  // 메모이제이션
       if(n==1) return fibo[n] = 1;
       else if(n==2) return fibo[n] = 1;
       else return fibo[n] = DFS(n-2) + DFS(n-1);    // 배열 값을 return한다.
    }
    public static void main(String[] args) {
        lec_04 T = new lec_04();
        int n = 45;
        fibo = new int[n + 1]; // 우리는 0번 인덱스는 사용하지 않을 것이기 때문에 n+1
        // 이렇게 배열을 동적으로 할당받으면 0으로 초기화 되어 있다.
        T.DFS(n);   // DFS(10)만 한 번 도는 것이다.
        for (int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");
    }
}
