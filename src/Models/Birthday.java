package Models;

public class Birthday extends Event{
    private String celebrant;
    private String location;
    private int age;

    public Birthday(String date, String time, String celebrant, String location, int age) {
        super(date, time);
        this.celebrant = celebrant;
        this.location = location;
        this.age = age;
    }

    public String getCelebrant() { return celebrant; }
    public String getLocation() { return location; }
    public int getAge() { return age; }

    public void setCelebrant(String celebrant) { this.celebrant = celebrant; }
    public void setLocation(String location) { this.location = location; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "[День рождения] " + super.toString() +
                "\nИменинник: " + celebrant +
                "\nМесто: " + location +
                "\nВозраст: " + age;
    }

    public String toCsv() {
        return super.toCsv() + "," + celebrant + "," + location + "," + age;
    }

}
