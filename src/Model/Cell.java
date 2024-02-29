package src.Model;

public class Cell {
    private String position;
    private String value;
    private String fortName;

    public Cell(String position, String value, String fortName) {
        this.position = position;
        this.value = value;
        this.fortName = fortName;
    }

    public String getPosition() {
        return position;
    }

    public String getValue() {
        return value;
    }

    public String getFortName() {
        return fortName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setFortName(String fortName) {
        this.fortName = fortName;
    }
}
