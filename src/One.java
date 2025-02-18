import java.util.Scanner;

public class One {
  public static int foo(int a, int b){
    int max = Math.max(a, b);
    return max * 5;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Input two numbers separated by space: ");
    int a = in.nextInt(); // Читаем первое число
    int b = in.nextInt(); // Читаем второе число
    int result = foo(a, b);
    // Выводим результат на экран
    System.out.println("Result: " + result);
  }
}