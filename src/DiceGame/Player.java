package DiceGame;

public class Player {
    private String name;
    private int points;

    public int getPoints() {
        return points;
    }

    public void changePoints(int points) {
        this.points += points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
