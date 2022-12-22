package section_7;

// 재귀함수를 이용한 이진수 출력

class lec_02 {

    public void DFS(int n){
        if(n == 0) return  ;
        else{
            DFS(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        lec_02 T = new lec_02();
        T.DFS(11);
    }
}
