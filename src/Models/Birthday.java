package Models;

public class Birthday extends Event{
    private final String celebrant;
    private final String location;
    private final int age;

    public Birthday(String date, String time, String celebrant, String location, int age) {
        super(date, time);
        this.celebrant = celebrant;
        this.location = location;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[День рождения] " + super.toString() +
                "\nИменинник: " + celebrant +
                "\nМесто: " + location +
                "\nВозраст: " + age;
    }
}
