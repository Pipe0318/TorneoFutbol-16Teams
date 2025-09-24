package model;

public class Group {
    private String name;
    private Match[] matches;
    private Team[] teams;

    public Group(String name) {

        this.name = name;
        this.matches = new Match[6];
        this.teams = new Team[4];

    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public Match[] getMatches() {
        return matches;
    }

    public void setMatches(Match[] matches) {
        this.matches = matches;
    }

    /**
     * Description: Searches for a player within a specific team in the group by
     * their ID.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String id The ID of the player to search for.
     * @return The Player object if found, null otherwise.
     *         pre: The `teamName` should be a valid name of a team registered in
     *         this
     *         group, and `id` should be a valid player ID.
     *         post: Returns the `Player` object if a player with the matching `id`
     *         is found
     *         in the specified team. Otherwise, returns `null`. No changes are made
     *         to the system state.
     */
    public Player searchPlayer(String teamName, String id) {
        Team team = searchTeam(teamName);
        return team.searchPlayer(id);
    }

    /**
     * Description: Displays a formatted list of players for a given team in the
     * group.
     *
     * @param String teamName The name of the team to list players for.
     * @return A String containing a formatted list of players if the team exists,
     *         or an appropriate message if the team is not found.
     *         pre: `teamName` should correspond to a team within this group.
     *         post: If the `team` with the given `teamName` is found, a formatted
     *         string is
     *         returned with each player's ID, name, shirt number, and position. If
     *         not, a message indicating that the team is not found is returned. The
     *         system state remains unchanged.
     */

    public String showPlayerList(String teamName) {
        Team team = searchTeam(teamName);

        return team.showPlayerList();

    }

    /**
     * Description: Adds goals to a player's statistics within a specified team in
     * the group.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String id The ID of the player to add goals to.
     *               pre: The `teamName` must correspond to an existing team in this
     *               group. The
     *               `id` must correspond to a player registered within that team.
     *               post: The number of goals for the specified player in the
     *               specified team is
     *               incremented. If the team or player is not found, no action is
     *               taken. No
     *               other data is modified.
     */
    public void addGoalsToPlayer(String teamName, String id) {
        Team team = searchTeam(teamName);
        if (team != null) {
            team.addGoalsToPlayer(id);
        }
    }

    /**
     * Description : Adds assists to a player's statistics within a specified team
     * in the group.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String id The ID of the player to add assists to.
     *               pre: The `teamName` must correspond to an existing team in this
     *               group. The
     *               `id` must correspond to a player registered within that team.
     *               post: The number of assists for the specified player in the
     *               specified team is
     *               incremented. If the team or player is not found, no action is
     *               taken. No
     *               other data is modified.
     */
    public void addAssistsToPlayer(String teamName, String id) {
        Team team = searchTeam(teamName);
        if (team != null) {
            team.addAssistsToPlayer(id);
        }
    }

    /**
     * Description: Adds a yellow card to a player's statistics within a specified
     * team in the
     * group.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String id The ID of the player to add a yellow card to.
     *               pre: The `teamName` must correspond to an existing team in
     *               this group. The
     *               `id` must correspond to a player registered within that team.
     *               post: The number of yellow cards for the specified player in
     *               the specified
     *               team is incremented. If the team or player is not found, no
     *               action is
     *               taken. No other data is modified.
     */
    public void addYelllowCardToPlayer(String teamName, String id) {
        Team team = searchTeam(teamName);
        if (team != null) {
            team.addYelllowCardToPlayer(id);
        }

    }

    /**
     * Description: Adds a red card to a player's statistics within a specified team
     * in the
     * group.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String id The ID of the player to add a red card to.
     *               pre: The `teamName` must correspond to an existing team in this
     *               group. The
     *               `id` must correspond to a player registered within that team.
     *               post: The number of red cards for the specified player in the
     *               specified team
     *               is incremented. If the team or player is not found, no action
     *               is taken.
     *               No other data is modified.
     */
    public void addRedCardToPlayer(String teamName, String id) {
        Team team = searchTeam(teamName);
        if (team != null) {
            team.addRedCardToPlayer(id);
        }

    }

    /**
     * Description: Searches for a match within the group based on the names of the
     * two
     * participating teams.
     *
     * @param String team1Name The name of the first team.
     * @param String team2Name The name of the second team.
     * @return The Match object if found, or null otherwise.
     *         pre: The `team1Name` and `team2Name` should be valid names of teams
     *         within
     *         this group. The order of team names does not matter; the method
     *         should
     *         find the match regardless of whether team1 is the home or away team.
     *         post: Returns the `Match` object representing the match between the
     *         specified
     *         teams if it exists within this group. Returns `null` if no such match
     *         is found. The state of the system remains unchanged.
     */
    public Match searchMatch(String team1Name, String team2Name) {
        for (int i = 0; i < matches.length; i++) {
            Match match = matches[i];
            if (match != null &&
                    match.getTeam1().getName().equals(team1Name) &&
                    match.getTeam2().getName().equals(team2Name)) {
                return match;
            }
        }

        return null;
    }

    /**
     * Adds a team to the group at a specified index.
     *
     * @param team  The Team object to add.
     * @param index The index in the `teams` array where the team should be added.
     * @pre The `team` should not be null. The `index` must be within the valid
     *      bounds of the `teams` array (0 to teams.length - 1). The group should
     *      not already contain a team with the same name as the given team at any
     *      index other than the specified `index`. If a team already exists at the
     *      specified index, it will be replaced.
     * @post If the preconditions are met, the provided `team` is added to the
     *       `teams` array at the specified `index`. If the `index` is out of
     *       bounds, no action is taken.
     */
    public void addTeam(Team team, int index) {

        if (index >= 0 && index < teams.length) {
            teams[index] = team;
        }
    }

    /**
     * Searches for a team within the group by its name.
     *
     * @param String teamName The name of the team to search for.
     * @return The Team object if found, null otherwise.
     *         pre: The `teamName` should be a valid team name.
     *         post: If a team with the matching `teamName` is found in the group,
     *         the Team
     *         object is returned. Otherwise, null is returned. The system state
     *         remains unchanged.
     */
    public Team searchTeam(String teamName) {
        if (teams == null) {
            return null;
        } else {
            for (int k = 0; k < teams.length; k++) {
                if (teams[k].getName().equals(teamName)) {
                    return teams[k];
                }
            }
        }
        return null;
    }

    /**
     * Sets the result of a match within the group.
     *
     * @param String team1Name The name of the first team.
     * @param String team2Name The name of the second team.
     * @param String score1 The score of the first team.
     * @param String score2 The score of the second team.
     * @return A string message indicating whether the match result was registered
     *         successfully or if the match was not found or already played.
     *         pre: The `team1Name` and `team2Name` must correspond to valid teams
     *         within
     *         the group, and a `Match` object representing the game between these
     *         teams must exist in the `matches` array. The match represented by
     *         `Match` should have `isPlayed` set to false.
     *         post: If the match is found and has not been played yet, the match
     *         score is
     *         updated with `score1` and `score2` for respective teams. The games
     *         played, won, lost, drawn, goals scored, goals conceded, and points
     *         are
     *         updated for both participating teams based on the match result. The
     *         match's status is set to played (`match.setPlayed(true)`). If the
     *         match
     *         is not found or has already been played, an appropriate message is
     *         returned and no changes are made to any team or match data.
     */
    public String setMatchResult(String team1Name, String team2Name, int score1, int score2) {
        Match match = searchMatch(team1Name, team2Name);

        if (match == null || match.isPlayed()) { // Ensure the match exists and hasn't already been played
            return "Match not found or already played.";
        }

        match.setScoreTeam1(score1);
        match.setScoreTeam2(score2); // Set the score for the match

        Team team1 = match.getTeam1();
        Team team2 = match.getTeam2();

        team1.addGamesPlayed(1);
        team2.addGamesPlayed(1);

        team1.addGoalsScored(score1);
        team1.addGoalsConceded(score2); // Update goals against (conceded)
        team2.addGoalsScored(score2);
        team2.addGoalsConceded(score1);

        if (score1 > score2) {
            team1.addGamesWon(1);
            team2.addGamesLost(1);
            team1.addPoints(3);

        } else if (score2 > score1) {

            team2.addGamesWon(1);
            team1.addGamesLost(1);
            team2.addPoints(3);

        } else {

            team1.addGamesDrawn(1);
            team2.addGamesDrawn(1);
            team1.addPoints(1);
            team2.addPoints(1);

        }

        match.setPlayed(true);
        return "Match result registered successfully.";
    }

    /**
     * Registers a match as played and assigns a referee to it. This method seems to
     * assume there's already a Match object created for the two teams, and only
     * updates its played status and referee. It does *not* create a new Match
     * object.
     *
     * @param String team1Name The name of the first team.
     * @param String team2Name The name of the second team.
     * @param String idReferee The ID of the referee officiating the match.
     * @return A message confirming the registration of the match or explaining the
     *         error if any conditions weren't met.
     *         pre: A `Match` object between `team1Name` and `team2Name` must
     *         already exist
     *         in the `matches` array of the group and be in an "unplayed" state
     *         (`isPlayed` is false). A `Referee` with the provided `idReferee` must
     *         exist in the system. Both `team1Name` and `team2Name` must be valid
     *         names of teams in this group.
     *         post: If the preconditions are met, the existing `Match` between the
     *         specified teams has its `isPlayed` status set to `true`, its
     *         `refereeID` is updated with `idReferee`. The `matchesPlayed` count
     *         for
     *         each of the participating teams is incremented. A success message is
     *         returned. If no match is found, or if the match has already been
     *         played, or if the referee ID is invalid, an appropriate message is
     *         returned and no changes are made to any match or team data.
     */
    public String addMatchPlayed(String team1Name, String team2Name, String idReferee) {
        Match match = searchMatch(team1Name, team2Name);
        Team team1 = searchTeam(team1Name);
        Team team2 = searchTeam(team2Name);
        team1.addMatchPlayed();
        team2.addMatchPlayed();

        return match.addMatchPlayed(idReferee);
    }

    /**
     * Calculates the top goal scorer within the group.
     *
     * @return The Player object representing the top goal scorer, or null if no
     *         players are found or no goals have been scored.
     *         pre: The group should contain at least one team, and at least one
     *         player
     *         should have scored at least one goal.
     *         post: Returns the `Player` object who has scored the highest number
     *         of goals
     *         within the group. If multiple players share the highest number of
     *         goals, the first such player encountered in the iteration is
     *         returned.
     *         If no goals have been scored by any player, returns `null`. The
     *         system
     *         state is not modified.
     */
    public Player calcTopGoalScorer() {
        Player topScorer = null;
        int maxGoals = -1;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i] != null) {
                for (int j = 0; j < teams[i].getPlayers().length; j++) {
                    Player player = teams[i].getPlayers()[j];
                    if (player != null && player.getGoals() > maxGoals) {
                        topScorer = player;
                        maxGoals = player.getGoals();
                    }

                }
            }
        }
        return topScorer;

    }

    /**
     * Calculates the "fairest play" team within the group based on the total number
     * of red and yellow cards received.
     *
     * @return The Team object representing the team with the fewest cards, or null
     *         if no teams are found.
     *         pre: The group should contain at least one team.
     *         post: Returns the `Team` object with the lowest total card count (red
     *         cards +
     *         yellow cards). If multiple teams share the lowest card count, the
     *         first
     *         such team encountered is returned. If no teams are present in the
     *         group, returns `null`. The system state is not modified.
     */
    public Team calcFairPlayTeam() {
        Team fairPlayTeam = null;
        int cards = Integer.MAX_VALUE;
        if (teams == null) {
            return null;
        } else {
            for (int i = 0; i < teams.length; i++) {
                Team team = teams[i];
                if (team != null && team.getCards() < cards) {
                    fairPlayTeam = team;
                    cards = team.getCards();
                }

            }
        }

        return fairPlayTeam;

    }

    /**
     * Calculates the efficiency of a specific team in the group.
     *
     * @param teamName The name of the team whose efficiency is to be calculated.
     * @return The calculated efficiency of the team as a `double`.
     *         pre: The `teamName` must correspond to a valid team within this
     *         group. The
     *         team should have played at least one match.
     *         post: Returns the calculated team efficiency. The efficiency
     *         calculation is
     *         delegated to the `calcTeamEfficiency` method of the `Team` class. The
     *         system state is not modified. If the team is not found, or has not
     *         played any matches a value will still be returned, but its meaning
     *         will
     *         be undefined and should be handled by the caller.
     */
    public double calcTeamEfficiency(String teamName) {
        Team team = searchTeam(teamName);
        if (team != null) {
            return team.calcTeamEfficiency();
        } else {

            return 0;
        }
    }

    /**
     * Calculates the efficiency of a specific player in the group.
     *
     * @param playerId The ID of the player.
     * @param teamName The name of the team the player belongs to.
     * @return The calculated efficiency of the player as a `double`.
     *         pre: The `playerId` and `teamName` must correspond to a registered
     *         player
     *         within a team that belongs to this group. The player should have
     *         participated in at least one match.
     *         post: The calculated player efficiency is returned. The efficiency
     *         calculation is delegated to the `calcPlayerEfficiency` method of the
     *         `Team` class. The system state remains unchanged. If the team or
     *         player
     *         are not found, a value will still be returned, but it will be
     *         undefined
     *         and the caller should handle this situation appropriately (e.g., by
     *         checking for error values or throwing exceptions).
     */
    public double calcPlayerEfficiency(String playerId, String teamName) {
        Team team = searchTeam(teamName);
        if (team != null) {
            return team.calcPlayerEfficiency(playerId);
        } else {

            return 0;
        }

    }

    /**
     * Displays the list of players for the first team found in this group. This
     * method's name is misleading, as it doesn't actually use the provided name
     * parameter. It simply returns the player list of the first team in the group.
     *
     * @return A string representation of the player list for the first team in the
     *         group.
     * pre: The group must contain at least one team, and that team should have at
     *      least one registered player.
     * post: Returns a formatted string containing the list of players for the first
     *       team found in the `teams` array. If the group is empty or the first
     *       team has no players, a message indicating this should be returned
     *       (currently, the behavior is undefined in such cases, which could lead
     *       to unexpected results). The system's state remains unchanged. The
     *       `name` parameter is not used and is therefore misleading.
     */
    public String showPlayerList() {
        Team team = searchTeam(name);

        return team.showPlayerList();

    }
}
