import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if (input.isEmpty())
            System.out.println(0);
        else
            System.out.println(input.split(" ").length);
        scanner.close();
    }
}
