public class Circle2 {
    int radius;
    String name;

    public Circle2() {  // 생성자 이름은 클래스 이름과 동일
        radius = 1;
        name = "";
    }

    public Circle2(int r, String n) {
        radius = r;
        name = n;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        Circle2 pizza = new Circle2(10, "자바피자");
        System.out.println(pizza.name + "의 면적은 " + pizza.getArea());

        Circle2 donut = new Circle2();
        donut.name = "도넛피자";
        System.out.println(donut.name + "의 면적은 " + donut.getArea());
    }
}
