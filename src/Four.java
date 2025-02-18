import java.util.ArrayList;
import java.util.Random;

public class Four {
    public static void main(String[] args){
        int rows = 4;
        int cols = 5;

        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(21) - 10; // Случайные числа от -10 до 10
            }
        }

        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Создаем вектор B
        int[] vectorB = new int[rows];
        for (int i = 0; i < rows; i++) {
            int count = 0; // Счетчик неотрицательных элементов в строке
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] >= 0) {
                    count++;
                }
            }
            vectorB[i] = count; // Записываем количество в вектор B
        }

        // Выводим вектор B на экран
        System.out.println("\nВектор B (число неотрицательных элементов в каждой строке):");
        for (int i = 0; i < rows; i++) {
            System.out.println("Строка " + i + ": " + vectorB[i]);
        }
    }
}
