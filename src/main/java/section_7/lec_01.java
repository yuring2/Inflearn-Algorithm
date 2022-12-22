package section_7;

class lec_01 {

    public void DFS(int n){
        if(n==0) return;    // return : 함수종료
        else{
            DFS(n-1);
            System.out.print(n +" ");  // 왜 출력문을 함수호출 아래에 두어야 3 2 1 이 아닌 1 2 3 이 호출되는가?
        }

    }

    public static void main(String[] args){

        lec_01 T = new lec_01();
        T.DFS(3);

    }

}
