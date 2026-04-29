import java.util.Objects;

public class Functionality {
  
    private String description;
    private int timeCost;
    private int value;

    public Functionality(String description, int timeCost, int value) {
        this.description = description;
        this.timeCost = timeCost;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        description = d;
    }

    public int getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(int t) {
        timeCost = t;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int v) {
        value = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Functionality)) return false;
        Functionality that = (Functionality) o;
        return timeCost == that.timeCost &&
               value == that.value &&
               Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, timeCost, value);
    }
}

