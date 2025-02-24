package Models;

public class Contact {
    // Свойства класса
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String note;

    // Конструктор
    public Contact(int id, String firstName, String lastName, String address, String phone, String note) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.note = note;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Models.Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    // Пример использования
    public static void main(String[] args) {
        // Создаем объект класса Models.Contact
        Contact contact = new Contact(1, "Иван", "Иванов", "ул. Ленина, д. 10", "+7 (123) 456-78-90", "Коллега по работе");

        // Выводим информацию о контакте
        System.out.println(contact);
    }
}