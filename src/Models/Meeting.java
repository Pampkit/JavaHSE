package Models;

public class Meeting extends Event{
    private final String person;
    private final String location;

    public Meeting(String date, String time, String person, String location) {
        super(date, time);
        this.person = person;
        this.location = location;
    }

    @Override
    public String toString() {
        return "[Встреча] " + super.toString() +
                "\nС кем: " + person +
                "\nМесто: " + location;
    }
}
