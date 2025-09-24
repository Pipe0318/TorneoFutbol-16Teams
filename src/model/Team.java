package model;

public class Team {
    private String name;
    private String country;
    private String coach;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesDrawn;
    private int gamesLost;
    private int goalsScored;
    private int goalsConceded;
    private int cards;
    private int points;
    private Player[] players = new Player[20];

    public Team(String name, String country, String coach) {
        this.name = name;
        this.country = country;
        this.coach = coach;
    }

    public Team(Player[] players) {
        this.players = players;
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void addGoalsScored(int goals) {
        this.goalsScored += goals;
    }

    public void addGoalsConceded(int goals) {
        this.goalsConceded += goals;
    }

    public void addGamesPlayed(int games) {
        this.gamesPlayed += games;
    }

    public void addGamesWon(int games) {
        this.gamesWon += games;
    }

    public void addGamesDrawn(int games) {
        this.gamesDrawn += games;
    }

    public void addGamesLost(int games) {
        this.gamesLost += games;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int goalDifference() {

        return goalsScored - goalsConceded;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public void setGamesDrawn(int gamesDrawn) {
        this.gamesDrawn = gamesDrawn;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getCards() {
        return cards;
    }

    public void setCards(int cards) {
        this.cards = cards;
    }

    public void addGoals(int goalsScored, int goalsConceded) {

        this.goalsScored += goalsScored;
        this.goalsConceded += goalsConceded;

    }

    /**
     * Description: Updates the match result for this team. This method updates the
     * team's
     * statistics based on the outcome of a match.
     *
     * @param int goalsScored The number of goals scored by this team in the match.
     * @param int goalsConceded The number of goals conceded by this team in the
     *            match.
     *            pre: The `goalsScored` and `goalsConceded` must be
     *            non-negative integers.
     *            post: The team's `gamesPlayed`, `goalsScored`,
     *            `goalsConceded`, `gamesWon`,
     *            `gamesLost`, `gamesDrawn`, and `points` are updated
     *            based on the
     *            provided scores. No other attributes are modified.
     */
    public void updateMatchResult(int goalsScored, int goalsConceded) {
        this.gamesPlayed++; // Increment gamesPlayed regardless of outcome
        this.goalsScored += goalsScored;
        this.goalsConceded += goalsConceded;

        if (goalsScored > goalsConceded) {
            this.gamesWon++;
            this.points += 3;
        } else if (goalsScored < goalsConceded) {
            this.gamesLost++;
        } else {
            this.gamesDrawn++;
            this.points += 1; // Add points for a draw
        }
    }

    /**
     * Description: Adds a player to the team.
     *
     * @param Player player The Player object to add.
     * @return True if the player was added successfully, false otherwise.
     *         pre: The `player` object should not be null. The team should not
     *         already have
     *         a player with the same ID as the player being added. The team should
     *         have space for a new player (less than 20 players already added).
     *         post: If the preconditions are met, the `player` is added to the
     *         `players`
     *         array in the first available null slot. Returns `true` to indicate
     *         successful addition. If the player is not added and the method
     *         returns
     *         `false`.
     */
    public boolean addPlayer(Player player) {
        if (player == null) {
            return false;
        } else {
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    players[i] = player;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Description: Searches for a player within the team by their ID.
     *
     * @param String id The ID of the player to search for.
     * @return The Player object if found, null otherwise.
     *         pre: The provided `id` should be a valid player ID.
     *         post: If a player with the matching `id` is found in the team's
     *         `players`
     *         array, their Player object is returned. Otherwise, `null` is
     *         returned.
     *         The state of the team and its players is not modified.
     */
    public Player searchPlayer(String id) {
        for (int k = 0; k < players.length; k++) {
            if (players[k] != null && players[k].getId().equals(id)) {
                return players[k];
            }
        }
        return null;
    }

    /**
     * Description: Generates a formatted string listing all players in the team,
     * along with
     * their ID, name, nationality, shirt number, and position.
     *
     * @return String A formatted string containing the player list, or a message if
     *         no
     *         players are registered.
     *         pre: The `players` array may contain `null` entries if fewer than 20
     *         players
     *         have been added.
     *         post: Returns a formatted string listing all registered players in
     *         the team,
     *         including their ID, name, country, shirt number, and position, each
     *         on
     *         a new line. If no players are registered, returns a message
     *         indicating
     *         an empty roster. The system state remains unchanged.
     */
    public String showPlayerList() {
        String list = "";
        boolean validar = false;
        for (int j = 0; j < players.length; j++) {
            if (players[j] != null) {
                list += "- " + players[j].getId() + " " + players[j].getName() + " " + players[j].getCountry() + " "
                        + players[j].getShirtNumber() + " " + players[j].getPosition() + "\n";
                validar = true;
            } else {
                break;
            }

        }
        if (validar == false) {
            list = "No hay jugadores registrados en el equipo";

        }

        return list;

    }

    /**
     * Description: Adds goals to a player's statistics.
     *
     * @param String id The ID of the player to add goals to.
     * @return True if the goals were added successfully, false otherwise.
     *         pre: The `id` must correspond to a player registered within this
     *         team.
     *         post: If the player with the given `id` is found, their `goals`
     *         attribute is
     *         incremented. Returns `true` to indicate success. If the player is not
     *         found, no changes are made and the method returns `false`.
     */
    public boolean addGoalsToPlayer(String id) {
        int goals = 1;
        Player playerToUpdate = searchPlayer(id);

        if (playerToUpdate != null) {
            playerToUpdate.setGoals(playerToUpdate.getGoals() + goals);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an assist to a player's statistics.
     *
     * @param String id The ID of the player to add the assist to.
     * @return True if the assist was added successfully, false otherwise.
     *         pre: The `id` must correspond to a player registered within this
     *         team.
     *         post: If a player with the given `id` is found, their `assists`
     *         attribute is
     *         incremented and the method returns `true`. If the player is not
     *         found,
     *         no changes are made, and the method returns `false`.
     */
    public boolean addAssistsToPlayer(String id) {
        int assist = 1;
        Player playerAssist = searchPlayer(id);

        if (playerAssist != null) {
            playerAssist.setAssists(playerAssist.getAssists() + assist);

            return true;
        } else {
            return false;
        }
    }

    /**
     * Description: Adds a yellow card to a player's statistics.
     *
     * @param String id The ID of the player receiving the yellow card.
     * @return True if the yellow card was added successfully, false otherwise.
     *         pre: The `id` must correspond to a player registered within this
     *         team.
     *         post: If a player with the given `id` is found, their `yellowCards`
     *         count is
     *         incremented, the team's total card count (`cards`) is also
     *         incremented,
     *         and the method returns `true`. If the player is not found, no changes
     *         are made, and the method returns `false`.
     */
    public boolean addYelllowCardToPlayer(String id) {
        int yellowCard = 1;
        Player playerYellowCard = searchPlayer(id);

        if (playerYellowCard != null) {
            playerYellowCard.setYellowCards(playerYellowCard.getYellowCards() + yellowCard);
            addCard();
            return true;
        } else {
            return false;

        }
    }

    /**
     * Description: Adds a red card to a player's statistics.
     *
     * @param String id The ID of the player receiving the red card.
     * @return True if the red card was added successfully, false otherwise.
     *         pre: The `id` must correspond to a player registered within this
     *         team.
     *         post: If a player with the given `id` is found, their `redCards`
     *         count is
     *         incremented, the team's total card count (`cards`) is also
     *         incremented,
     *         and the method returns `true`. If the player is not found, no changes
     *         are made, and the method returns `false`.
     */
    public boolean addRedCardToPlayer(String id) {
        int redCard = 1;
        Player playerRedCard = searchPlayer(id);

        if (playerRedCard != null) {
            playerRedCard.setRedCards(playerRedCard.getRedCards() + redCard);
            addCard();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description: Increments the team's card count. This method doesn't
     * distinguish between
     * yellow and red cards; it simply increments the total card count for the team.
     *
     * pre: The Team object should be initialized.
     * post: The `cards` attribute of the team is incremented by one. No other
     * attributes are modified. Returns `true` to indicate the operation was
     * successful (although there's no failure scenario currently).
     */
    public boolean addCard() {
        this.cards += 1;
        return true;
    }

    /**
     * Description: Increments the number of matches played for each player in the
     * team.
     *
     * pre: The Team object should be initialized and contain Player objects in its
     * `players` array.
     * post: The `matchesPlayed` attribute of each non-null Player in the `players`
     * array is incremented. Returns a string indicating that the matches
     * played have been updated. No other team or player attributes are
     * modified.
     */
    public String addMatchPlayed() {
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                players[i].addMatchPlayed();
            }

        }

        return "Partidos jugados actualizado";

    }

    /**
     * Description: Calculates the team's efficiency, defined as the ratio of games
     * won to games
     * played.
     *
     * @return The team's efficiency as a double. Returns 0.0 if no games have been
     *         played.
     *         pre: The `gamesPlayed` attribute should be a non-negative integer.
     *         post: Returns a double representing the calculated efficiency. The
     *         efficiency
     *         is calculated as `gamesWon / gamesPlayed`. If `gamesPlayed` is zero,
     *         returns 0.0 to avoid division by zero. The state of the Team object
     *         remains unchanged.
     */
    public double calcTeamEfficiency() {
        if (gamesPlayed > 0) { // Avoid division by zero
            return (double) gamesWon / gamesPlayed; // Correct: cast *before* division
        } else {
            return 0.0; // Or another appropriate value when no matches played
        }
    }

    /**
     * Description: Calculates the efficiency of a specific player on the team.
     *
     * @param String id The ID of the player whose efficiency is to be calculated.
     * @return The calculated efficiency of the player as a `double`.
     *         pre: The `id` must correspond to a registered player within this
     *         team. The
     *         player should have played at least one match (`matchesPlayed` > 0).
     *         post: Returns the calculated player efficiency. The calculation is
     *         delegated
     *         to the `calcPlayerEfficiency` method of the `Player` class. The
     *         system
     *         state is not modified. If the player is not found, returns 0; the
     *         caller should handle cases where no player is found.
     */
    public double calcPlayerEfficiency(String id) {
        Player player = searchPlayer(id);
        return player.calcPlayerEfficiency();
    }

    /**
     * Description : Compares this team to another team based on points, goal difference, and
     * goals scored.
     *
     * @param Team other The other Team object to compare to.
     * @return A negative integer, zero, or a positive integer as this team is less
     *         than, equal to, or greater than the other team, respectively.
     * pre: Both this Team object and the `other` Team object should be initialized
     *      and have valid data for points, goals scored, and goals conceded.
     * post: Returns an integer based on the comparison of the two teams according
     *       to the following rules (in descending order of precedence):
     *       1. Higher points ranks higher.
     *       2. If points are equal, higher goal difference ranks higher.
     *       3. If points and goal difference are equal, higher goals scored ranks
     *       higher.
     *       The state of neither team is modified by this comparison.
     */

    public int compareTo(Team other) {

        int pointsComparison = Integer.compare(other.getPoints(), this.getPoints());
        if (pointsComparison != 0) {
            return pointsComparison;
        }

        int goalDifferenceComparison = Integer.compare(
                other.getGoalsScored() - other.getGoalsConceded(),
                this.getGoalsScored() - this.getGoalsConceded());
        if (goalDifferenceComparison != 0) {
            return goalDifferenceComparison;
        }

        return Integer.compare(other.getGoalsScored(), this.getGoalsScored());
    }

    @Override
    public String toString() {
        return "The team" + name + " from " + country + " with " + cards
                + " cards is the Fair Play team of the tournament";
    }

}
