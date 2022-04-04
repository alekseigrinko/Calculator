import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String example1 = "1 + 2";
        System.out.println("1-й пример: " + example1);
        System.out.println("Ответ: " + calculator.calc(example1));
        String example2 = "5 - 4 * 2";
        System.out.println("2-й пример: " + example2);
        System.out.println("Ответ: " + calculator.calc(example2));
        String example3 = "4 + 6 / (12 - 3 * 2)";
        System.out.println("3-й пример: " + example3);
        System.out.println("Ответ: " + calculator.calc(example3));

        System.out.println("Введите произвольный пример:");
        String example = scanner.nextLine();
        System.out.println(calculator.calc(example));
        System.out.println(calculator.converterForNotation(example));
    }
}
