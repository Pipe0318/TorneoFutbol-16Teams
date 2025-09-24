package model;

import java.time.LocalDate;

public class Match {
    private Team team1;
    private Team team2;
    private int scoreTeam1;
    private int scoreTeam2;
    private boolean played;
    private Referee[] matchReferees = new Referee[3];
    private LocalDate matchDate;

    public Match(Team team1, Team team2, LocalDate matchDate) {

        this.team1 = team1;
        this.team2 = team2;
        this.matchDate = matchDate;
        this.played = false;

        preChargeInfo();

    }

    public void preChargeInfo() {

    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public Referee[] getMatchReferees() {
        return matchReferees;
    }

    public void setMatchReferees(Referee[] matchReferees) {
        this.matchReferees = matchReferees;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
        setPlayed(true);
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
        setPlayed(true);
    }

    /**
     * Description: Checks if the match has been played.
     *
     * @return True if the match has been played, false otherwise.
     *         pre: None.
     *         post: Returns the value of the `played` attribute. The state of the
     *         Match
     *         object remains unchanged.
     */
    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    /**
     * Description : Adds goals to Team 1 and updates the match score and team
     * statistics. This
     * method seems incomplete and likely incorrect. It updates the local
     * `scoreTeam1` and `scoreTeam2` variables but doesn't actually update the
     * match's score or the opposing team's conceded goals. It calls
     * `team1.addGoals()` which also updates `goalsScored` and `goalsConceded` for
     * that team, but using the parameters passed to *this* method, effectively
     * making the second parameter (goalsConceded) pointless within this context.
     *
     * @param int scoreTeam1 The current score of Team 1 (this parameter is
     *            redundant
     *            and should be removed).
     * @param int scoreTeam2 The current score of Team 2 (this parameter is
     *            redundant
     *            and should be removed).
     * @param int goalsScored The number of goals to add to Team 1.
     * @param int goalsConceded The number of goals conceded by Team 1 (but not
     *            actually
     *            used for team 2 and ultimately redundant due to the use
     *            of `team1.addGoals()`).
     * @return Always returns false; the return value is meaningless and the method
     *         should be void.
     *         pre: `goalsScored` and `goalsConceded` must be non-negative. `team1`
     *         and
     *         `team2` must be properly initialized `Team` objects.
     *         post: The `goalsScored` for `team1` is increased by the given amount.
     *         The
     *         `goalsScored` and `goalsConceded` for `team1` are updated via the
     *         `addGoals` method. The local variables `scoreTeam1` and `scoreTeam2`
     *         are also updated, but these changes aren't stored anywhere so they
     *         have
     *         no impact on the actual `Match` score. The method always returns
     *         false.
     *         The state of Team 2 is potentially inconsistent because the goals
     *         conceded by Team 2 (which should be Team 1’s goals scored) aren't
     *         properly recorded in `team2`. This method needs to be reviewed and
     *         corrected to make it functional.
     */
    public boolean addGoalsToTeam1(int scoreTeam1, int scoreTeam2, int goalsScored, int goalsConceded) {

        scoreTeam1 += goalsScored;
        scoreTeam2 += goalsConceded;
        team1.addGoals(goalsScored, goalsConceded);

        return false;
    }

    /**
     * Description: Adds goals to Team 2 and updates match score and team
     * statistics. This
     * method, like `addGoalsToTeam1`, appears incomplete and potentially incorrect.
     * It updates local `scoreTeam1` and `scoreTeam2` which are not persisted. The
     * call to `team2.addGoals()` suffers from the same redundancy issue explained
     * in `addGoalsToTeam1`.
     *
     * @param int scoreTeam2 The current score of Team 2 (redundant parameter).
     * @param int scoreTeam1 The current score of Team 1 (redundant parameter).
     * @param int goalsScored The number of goals scored by Team 2.
     * @param int goalsConceded The number of goals conceded by Team 2 (not properly
     *            used for Team 1).
     * @return Always returns false (meaningless return value).
     *         pre: `goalsScored` and `goalsConceded` must be non-negative. `team1`
     *         and
     *         `team2` must be valid, initialized `Team` objects.
     *         post: The `goalsScored` for `team2` is incremented. Similar to
     *         `addGoalsToTeam1`, the local `scoreTeam1`, `scoreTeam2` variables are
     *         updated but not stored, so have no lasting effect. The `goalsScored`
     *         and `goalsConceded` are updated via `team2.addGoals()`, but the way
     *         the
     *         parameters are used renders this method's `goalsConceded` parameter
     *         redundant and doesn't properly update `team1`'s conceded goals. The
     *         method always returns `false`. Team 1's state may be inconsistent due
     *         to not updating conceded goals correctly. This method needs to be
     *         reviewed and fixed.
     */
    public boolean addGoalsToTeam2(int scoreTeam2, int scoreTeam1, int goalsScored, int goalsConceded) {
        scoreTeam2 += goalsScored;
        scoreTeam1 += goalsConceded;
        team2.addGoals(goalsScored, goalsConceded);

        return false;
    }

    /**
     * Description: Searches for a referee within the match's referee array by their
     * ID.
     *
     * @param String id The ID of the referee to search for.
     * @return The Referee object if found, null otherwise.
     *         pre: The provided `id` should be a valid referee ID.
     *         post: If a referee with the matching `id` is found in the
     *         `matchReferees`
     *         array, their Referee object is returned. Otherwise, `null` is
     *         returned.
     *         The state of the match and its referees is not modified.
     */
    public Referee searchReferee(String id) {
        for (int i = 0; i < matchReferees.length; i++) {
            if (matchReferees[i] != null && matchReferees[i].getId().equals(id)) {
                return matchReferees[i];
            }
        }
        return null;
    }

    /**
     * Description: Adds a card to the specified referee's count for this match.
     *
     * @param String id The ID of the referee to add a card to.
     *               pre: The `id` should correspond to a referee that exists in the
     *               `matchReferees` array for this match.
     *               post: If the referee with the matching `id` is found, their
     *               card count is
     *               incremented using the `addCard()` method of the `Referee`
     *               class. If the
     *               referee is not found, no action is taken.
     */
    public void addCardToReferee(String id) {
        Referee referee = searchReferee(id);
        referee.addCard();
    }

    /**
     * Registers a match as played and updates the referee's match count. This
     * method assumes the referee is already associated with the match. It *does
     * not* add a new referee to the match.
     *
     * @param String idReferee The ID of the referee who officiated the match.
     * @return A message indicating whether the match was successfully registered or
     *         if the referee was not found.
     * pre: The `idReferee` must correspond to a referee that has already been
     *      assigned to this Match (e.g., as part of the `matchReferees` array). The
     *      `played` status of the match should initially be `false`.
     * post: If a referee with the given `idReferee` is found within the
     *       `matchReferees` array, their `matchesRefereed` count is incremented,
     *       the match is marked as played (`played = true`), and a success message
     *       is returned. If the referee is not found, no changes are made, and an
     *       appropriate message is returned.
     * 
     */
    public String addMatchPlayed(String idReferee) {
        String message = ""; // Store a message indicating success or failure
        for (int i = 0; i < matchReferees.length; i++) {
            if (matchReferees[i] != null && matchReferees[i].getId().equals(idReferee)) {
                matchReferees[i].addMatchPlayed();
                message = "Match played added successfully"; // Or a similar success message
                break; // Exit the loop once the referee is found and updated
            } else {
                message = "Referee not found"; // Or appropriate failure message
            }
        }
        return message; // Return the message to caller method for user feedback or handling
    }

    public String toString() {

        return team1.getName() + " " + scoreTeam1 + " vs " + scoreTeam2 + " " + team2.getName();
    }

}
