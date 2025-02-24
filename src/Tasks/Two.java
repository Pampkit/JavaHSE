package Tasks;

import java.util.Scanner;

public class Two {
    public static int foo(int a, int b){
        return (int) ((Math.pow(a, 5) - 3.2 * b) / (1 + b));
    }

    public static void two() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input two numbers separated by space: ");
        int a = in.nextInt(); // Читаем первое число
        int b = in.nextInt(); // Читаем второе число

        int result = foo(Math.max(a,b), Math.min(a,b));
        // Выводим результат на экран
        System.out.println("Result: " + result);
    }
}
