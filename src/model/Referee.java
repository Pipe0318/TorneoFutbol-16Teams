package model;

public class Referee extends Person {
    private Rtype rtype;
    private int matchesRefereed;
    private int cards;

    public Referee(String id, String name, String country, Rtype rtype) {
        super(id, name, country);
        this.rtype = rtype;
    }

    public Rtype getRtype() {
        return rtype;
    }

    public void setRtype(Rtype rtype) {
        this.rtype = rtype;
    }

    public int getMatchesRefereed() {
        return matchesRefereed;
    }

    public void setMatchesRefereed(int matchesRefereed) {
        this.matchesRefereed = matchesRefereed;
    }

    public int getCards() {
        return cards;
    }

    public void setCards(int cards) {
        this.cards = cards;
    }

    /**
     * Adds a card to the referee's count. This method doesn't differentiate between
     * yellow and red cards; it simply increments the total card count.
     * 
     * pre: The Referee object should be initialized.
     * post: The `cards` attribute of the referee is incremented by one.
     */
    public void addCard() {
        this.cards += 1;
    }

    /**
     * Increments the number of matches refereed by this referee.
     * 
     * @return String a confirmation message
     *         pre: The Referee object should be initialized.
     *         post: The `matchesRefereed` attribute of the referee is incremented
     *         by one. A
     *         string confirming the update is returned. No other attributes are
     *         modified.
     */
    public String addMatchPlayed() {
        this.matchesRefereed += 1;
        return "Partidos jugados actualizado";
    }

    /**
     * Calculates the referee's card index.
     *
     * @return The referee's card index, calculated as the average number of cards
     *         per match refereed.
     * pre: The referee should have refereed at least one match (`matchesRefereed` >
     *      0) to avoid division by zero.
     * post: The calculated card index is returned as a double. The card index
     *       represents the average number of cards given per match. The state of
     *       the Referee object remains unchanged. If `matchesRefereed` is zero, the
     *       method will return Infinity, which should be handled by the caller.
     */
    public double calcCardIndex() {
        double index = cards / matchesRefereed;
        return index;
    }

    @Override
    public String toString() {
        return "Nombre: " + getName() + "Pais: " + getCountry();
    }

}