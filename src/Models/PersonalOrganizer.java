package Models;
import java.util.*;
import java.io.*;


public class PersonalOrganizer {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static final ArrayList<Event> events = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int contactIdCounter = 1;
    private static final String CONTACTS_FILE = "contacts.txt";
    private static final String EVENTS_FILE = "events.txt";

    public static void personalOrganizer() {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1: addContact(); break;
                case 2: addEvent(); break;
                case 3: showSortedContacts(); break;
                case 4: showSortedEvents(); break;
                case 5: saveData(); break;
                case 6: loadData(); break;
                case 7: System.out.println("Выход из программы"); return;
                default: System.out.println("Неверный выбор");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Меню ---");
        System.out.println("1. Добавить контакт");
        System.out.println("2. Добавить событие");
        System.out.println("3. Показать контакты");
        System.out.println("4. Показать события");
        System.out.println("5. Сохранить данные в файлы");
        System.out.println("6. Загрузить данные из файлов");
        System.out.println("7. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void addContact() {
        System.out.print("Имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Фамилия: ");
        String lastName = scanner.nextLine();
        System.out.print("Адрес: ");
        String address = scanner.nextLine();
        System.out.print("Телефон: ");
        String phone = scanner.nextLine();
        System.out.print("Заметка: ");
        String note = scanner.nextLine();

        contacts.add(new Contact(contactIdCounter++, firstName, lastName, address, phone, note));
        System.out.println("Контакт добавлен!");
    }

    private static void addEvent() {
        System.out.println("Тип события:");
        System.out.println("1. День рождения");
        System.out.println("2. Встреча");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Дата (дд-мм-гггг): ");
        String date = scanner.nextLine();
        System.out.print("Время: ");
        String time = scanner.nextLine();

        if (type == 1) {
            System.out.print("Именинник: ");
            String celebrant = scanner.nextLine();
            System.out.print("Место проведения: ");
            String location = scanner.nextLine();
            System.out.print("Возраст: ");
            int age = scanner.nextInt();
            events.add(new Birthday(date, time, celebrant, location, age));
        } else if (type == 2) {
            System.out.print("С кем встреча: ");
            String person = scanner.nextLine();
            System.out.print("Место встречи: ");
            String location = scanner.nextLine();
            events.add(new Meeting(date, time, person, location));
        }
        System.out.println("Событие добавлено!");
    }

    private static void showSortedContacts() {
        contacts.sort(Comparator.comparing(Contact::getLastName)
                .thenComparing(Contact::getFirstName));

        System.out.println("\n--- Все контакты ---");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    private static void showSortedEvents() {
        events.sort(Comparator.comparing(Event::getDate)
                .thenComparing(Event::getTime));

        System.out.println("\n--- Все события ---");
        for (Event e : events) {
            System.out.println(e);
        }
    }

    private static void saveData() {
        System.out.println("Что выгрузить:");
        System.out.println("1. Контакты");
        System.out.println("2. События");
        int type = scanner.nextInt();

        if (type == 1) {
            saveToFile(CONTACTS_FILE, contacts);
            System.out.println("Контакты сохранены в " + CONTACTS_FILE);
        } else if (type == 2) {
            saveToFile(EVENTS_FILE, events);
            System.out.println("События сохранены в " + EVENTS_FILE);
        }

    }

    private static <T extends CsvConvert> void saveToFile(String fileName, ArrayList<T> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T item : list) {
                writer.write(item.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private static void loadData() {
        System.out.println("Что загрузить:");
        System.out.println("1. Контакты");
        System.out.println("2. События");
        int type = scanner.nextInt();

        if (type == 1) {
            updateContactsFromFile(CONTACTS_FILE, contacts);
            System.out.println("Контакты выгружены");
        } else if (type == 2) {
            updateEventsFromFile(EVENTS_FILE, events);
            System.out.println("События выгружены");
        }
    }

    private static void updateContactsFromFile(String fileName, ArrayList<Contact> contacts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    contacts.add(new Contact(id, parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }


    private static void updateEventsFromFile(String fileName, ArrayList<Event> events) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 0) {
                    int type = Integer.parseInt(parts[0]);
                    if (type == 1) {
                        if (parts.length == 6) {
                            events.add(new Birthday(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5])));
                        }
                    } else if (type == 2) {
                        if (parts.length == 5) {
                            events.add(new Meeting(parts[1], parts[2], parts[3], parts[4]));
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }





}
