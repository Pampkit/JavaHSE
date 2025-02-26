import java.util.Scanner;
import Tasks.*;
import Models.*;
import java.util.*;
import java.io.*;

public class Main {
    private static void printMenu() {
        System.out.println("\n--- Меню ---");
        System.out.println("1. Задание 1");
        System.out.println("2. Задание 2");
        System.out.println("3. Задание 3");
        System.out.println("4. Задание 4");
        System.out.println("5. Проект");
        System.out.println("6. Выход");
        System.out.print("Выберите действие: ");
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1: One.one(); break;
                case 2: Two.two(); break;
                case 3: Three.three(); break;
                case 4: Four.four(); break;
                case 5: PersonalOrganizer.personalOrganizer(); break;
                case 6: System.out.println("Выход из программы"); return;
                default: System.out.println("Неверный выбор");
            }
        }
    }
}
