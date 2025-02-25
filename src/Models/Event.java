package Models;

public class Event implements CsvConvert {
    private String date;
    private String time;

    public Event(String date, String time) {
        this.date = date;
        this.time = time;
    }

    // Геттеры и сеттеры
    public String getDate() { return date; }
    public String getTime() { return time; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        return "Дата: " + date + ", Время: " + time;
    }

    @Override
    public String toCsv() {
        return date + "," + time;
    }
}
