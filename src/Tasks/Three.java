package Tasks;

import java.util.ArrayList;
import java.util.Random;

public class Three {
    public static void three(){
        int size = 10;
        final int TARGET_VALUE = 5;
        int[] array = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10); // Случайные числа от 0 до 9
        }

        System.out.print("Исходный массив: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i] == TARGET_VALUE) {
                indexes.add(i);
            }
        }

        // Преобразуем список в массив
        int[] resultArray = new int[indexes.size()];
        for (int i = 0; i < indexes.size(); i++) {
            resultArray[i] = indexes.get(i);
        }

        // Выводим результат
        System.out.print("Индексы элементов, равных " + TARGET_VALUE + ": ");
        for (int index : resultArray) {
            System.out.print(index + " ");
        }
        System.out.println();

    }
}
