package model;

public class Player extends Person {

    private int shirtNumber;
    private Position position;
    private int goals;
    private int assists;
    private int playedGames;
    private int redCards;
    private int yellowCards;

    public Player(String id, String name, String country, int shirtNumber, Position position) {
        super(id, name, country);
        this.shirtNumber = shirtNumber;
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    /**
     * Increments the player's count of matches played.
     *
     * pre: The Player object should be initialized.
     * post: The `playedGames` attribute of the player is incremented by one. No
     * other player attributes are modified.
     */
    public void addMatchPlayed() {
        this.playedGames += 1;
    }

    /**
     * Calculates the player's efficiency, defined as goals per game played.
     *
     * @return The player's efficiency as a double. Returns 0.0 if the player has
     *         not played any games.
     * pre: The `playedGames` attribute should be a non-negative integer.
     * post: Returns a double representing the calculated efficiency. The efficiency
     *       is calculated as `goals / playedGames`. If `playedGames` is zero,
     *       returns 0.0 to avoid division by zero. The state of the Player object
     *       remains unchanged.
     */
    public double calcPlayerEfficiency() {
        double efficiency = goals / playedGames;
        return efficiency;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n No: " + shirtNumber +
                "\n Posicion: " + position;
    }

}