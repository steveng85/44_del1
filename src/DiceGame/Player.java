package DiceGame;

public class Player {
    private String name;
    private int points;
    private final int maxPoints = 40;

    public int getPoints() {
        return points;
    }

    public void changePoints(int points) {
        this.points += points;
        if (this.points >= 40) {
            this.points = 40;
        }
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
