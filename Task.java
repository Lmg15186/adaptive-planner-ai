public class Task {

    private String name;
    private int priority;
    private int hours;

    public Task(String name, int priority, int hours) {
        this.name = name;
        this.priority = priority;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getHours() {
        return hours;
    }
}
