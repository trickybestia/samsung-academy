import java.util.List;

public class Player {
    protected String name;
    protected List<Unit> units;

    public Player(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
