package Models;

public class Meeting extends Event{
    private String person;
    private String location;

    public Meeting(String date, String time, String person, String location) {
        super(date, time);
        this.person = person;
        this.location = location;
    }

    public String getPerson() { return person; }
    public String getLocation() { return location; }

    public void setPerson(String person) { this.person = person; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return "[Встреча] " + super.toString() +
                "\nС кем: " + person +
                "\nМесто: " + location;
    }
}
