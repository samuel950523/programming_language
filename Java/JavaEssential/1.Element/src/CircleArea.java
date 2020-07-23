public class CircleArea {
    public static void main(String[] args) {
        final double PI = 3.14; // 상수는 final로 선언
        double radius = 10.2;
        double circleArea = radius * radius * PI;

        // System.out.println의 단축키 : sout+tab
        // 코드 자동 정렬 : ctrl+alt+L
        System.out.print("반지름 " + radius + ", ");
        System.out.println("원의 면적 = " + circleArea);
    }
}
