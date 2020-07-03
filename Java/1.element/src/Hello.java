public class Hello {
    // C,C++ 함수를 자바에서는 메소드(method)라고 부른다.
    // 반드시 class 내에서 작성
    public static int sum(int n, int m){
        return n+m;
    }

    // main은 반드시 public static void로 선언
    public static void main(String[] args){
        int i=20;
        int s;
        char a;

        s=sum(i,10); // method 호출
        a='?';
        // System.out.print()를 사용하면 출력 후 다음줄로 넘어가지 않는다.
        System.out.println(a);
        System.out.println("Hello");
        System.out.println(s);
    }
}
