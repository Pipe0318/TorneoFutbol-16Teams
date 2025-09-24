package model;

import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {

    private Team[] prevTeams = new Team[8];
    private Person[] persons = new Person[172];
    private Referee[] centralReferees = new Referee[4];
    private Referee[] assistantReferees = new Referee[8];
    private String tournamentName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Group[] groups = new Group[2];

    /**
     * Description: Constructor of the Controller class. It initializes the groups
     * array with two groups, "A" and "B".
     * 
     * pre: The class should be instantiated.
     * pos: The groups array is initialized with two groups.
     */
    public Controller() {

        preChargeInfo();
        groups[0] = new Group("A");
        groups[1] = new Group("B");

    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Description: Pre-loads information about the tournament, including name,
     * start/end dates, pre-defined teams, players, and referees.
     * 
     * pre: The class should be instantiated.
     * pos: The `tournamentName`, `startDate`, `endDate`, `prevTeams`, `persons`,
     * `centralReferees`, and `assistantReferees` arrays are populated with initial
     * data. Eight teams with their respective players are created. Four central
     * referees and eight assistant referees are also created.
     */

    public void preChargeInfo() {
        tournamentName = "Torneo";
        startDate = LocalDate.of(2024, 6, 20);
        endDate = LocalDate.of(2024, 7, 02);

        Team madrid = new Team("Real Madrid", "España", "Ancheloti");
        Team manCity = new Team("Manchester City", "Inglaterra", "Guardiola");
        Team bayern = new Team("Bayern Munich", "Alemania", "Kompany");
        Team barcelona = new Team("Barcelona", "España", "Flick");
        Team liverpool = new Team("Liverpool", "Inglaterra", "Klopp");
        Team dormunt = new Team("Borussia Dormunt", "Alemania", "Terzic");
        Team milan = new Team("Milan", "Italia", "Fonseca");
        Team juventus = new Team("Juventus", "Italia", "Allegri");

        prevTeams[0] = madrid;
        prevTeams[1] = manCity;
        prevTeams[2] = bayern;
        prevTeams[3] = barcelona;
        prevTeams[4] = liverpool;
        prevTeams[5] = dormunt;
        prevTeams[6] = milan;
        prevTeams[7] = juventus;

        madrid.addPlayer(new Player("1", "Courtois", "Bélgica", 1, Position.ARQUERO));
        madrid.addPlayer(new Player("2", "Carvajal", "España", 2, Position.DEFENSA));
        madrid.addPlayer(new Player("4", "Alaba", "Austria", 4, Position.DEFENSA));
        madrid.addPlayer(new Player("5", "Mendy", "Francia", 5, Position.DEFENSA));
        madrid.addPlayer(new Player("6", "Rüdiger", "Alemania", 6, Position.DEFENSA));
        madrid.addPlayer(new Player("8", "Kroos", "Alemania", 8, Position.VOLANTE));
        madrid.addPlayer(new Player("10", "Modrić", "Croacia", 10, Position.VOLANTE));
        madrid.addPlayer(new Player("11", "Asensio", "España", 11, Position.DELANTERO));
        madrid.addPlayer(new Player("12", "Camavinga", "Francia", 12, Position.VOLANTE));
        madrid.addPlayer(new Player("14", "Valverde", "Uruguay", 14, Position.VOLANTE));
        madrid.addPlayer(new Player("15", "Tchouaméni", "Francia", 15, Position.VOLANTE));
        madrid.addPlayer(new Player("17", "Lucas Vázquez", "España", 17, Position.DELANTERO));
        madrid.addPlayer(new Player("19", "Ceballos", "España", 19, Position.VOLANTE));
        madrid.addPlayer(new Player("20", "Vinicius Jr.", "Brasil", 20, Position.DELANTERO));
        madrid.addPlayer(new Player("21", "Rodrygo", "Brasil", 21, Position.DELANTERO));
        madrid.addPlayer(new Player("22", "Mani", "Alemania", 22, Position.DEFENSA));
        madrid.addPlayer(new Player("23", "Mendy", "Francia", 23, Position.DEFENSA));
        madrid.addPlayer(new Player("24", "Mariano", "España", 24, Position.DELANTERO));
        madrid.addPlayer(new Player("25", "Lunin", "Ucrania", 25, Position.ARQUERO));

        manCity.addPlayer(new Player("31", "Ederson", "Brasil", 31, Position.ARQUERO));
        manCity.addPlayer(new Player("2", "Walker", "Inglaterra", 2, Position.DEFENSA));
        manCity.addPlayer(new Player("3", "Dias", "Portugal", 3, Position.DEFENSA));
        manCity.addPlayer(new Player("6", "Aké", "Países Bajos", 6, Position.DEFENSA));
        manCity.addPlayer(new Player("7", "Cancelo", "Portugal", 7, Position.DEFENSA));
        manCity.addPlayer(new Player("8", "Gündogan", "Alemania", 8, Position.VOLANTE));
        manCity.addPlayer(new Player("10", "Grealish", "Inglaterra", 10, Position.VOLANTE));
        manCity.addPlayer(new Player("14", "Laporte", "España", 14, Position.DEFENSA));
        manCity.addPlayer(new Player("16", "Rodri", "España", 16, Position.VOLANTE));
        manCity.addPlayer(new Player("17", "De Bruyne", "Bélgica", 17, Position.VOLANTE));
        manCity.addPlayer(new Player("19", "Álvarez", "Argentina", 19, Position.DELANTERO));
        manCity.addPlayer(new Player("20", "Bernardo Silva", "Portugal", 20, Position.VOLANTE));
        manCity.addPlayer(new Player("21", "Sergio Gómez", "España", 21, Position.DEFENSA));
        manCity.addPlayer(new Player("25", "Akanji", "Suiza", 25, Position.DEFENSA));
        manCity.addPlayer(new Player("26", "Mahrez", "Argelia", 26, Position.DELANTERO));
        manCity.addPlayer(new Player("33", "Carson", "Inglaterra", 33, Position.ARQUERO));
        manCity.addPlayer(new Player("47", "Foden", "Inglaterra", 47, Position.VOLANTE));
        manCity.addPlayer(new Player("80", "Palmer", "Inglaterra", 80, Position.VOLANTE));
        manCity.addPlayer(new Player("82", "Lewis", "Inglaterra", 82, Position.DEFENSA));
        manCity.addPlayer(new Player("9", "Haaland", "Noruega", 9, Position.DELANTERO));

        bayern.addPlayer(new Player("1", "Neuer", "Alemania", 1, Position.ARQUERO));
        bayern.addPlayer(new Player("2", "Upamecano", "Francia", 2, Position.DEFENSA));
        bayern.addPlayer(new Player("4", "De Ligt", "Países Bajos", 4, Position.DEFENSA));
        bayern.addPlayer(new Player("5", "Pavard", "Francia", 5, Position.DEFENSA));
        bayern.addPlayer(new Player("6", "Kimmich", "Alemania", 6, Position.VOLANTE));
        bayern.addPlayer(new Player("7", "Gnabry", "Alemania", 7, Position.DELANTERO));
        bayern.addPlayer(new Player("8", "Goretzka", "Alemania", 8, Position.VOLANTE));
        bayern.addPlayer(new Player("9", "Lewandowski", "Polonia", 9, Position.DELANTERO));
        bayern.addPlayer(new Player("10", "Sané", "Alemania", 10, Position.DELANTERO));
        bayern.addPlayer(new Player("11", "Coman", "Francia", 11, Position.DELANTERO));
        bayern.addPlayer(new Player("13", "Choupo-Moting", "Camerún", 13, Position.DELANTERO));
        bayern.addPlayer(new Player("14", "Wanner", "Alemania", 14, Position.VOLANTE));
        bayern.addPlayer(new Player("17", "Sadio Mané", "Senegal", 17, Position.DELANTERO));
        bayern.addPlayer(new Player("18", "Sabitzer", "Austria", 18, Position.VOLANTE));
        bayern.addPlayer(new Player("19", "Davies", "Canadá", 19, Position.DEFENSA));
        bayern.addPlayer(new Player("20", "Bouna Sarr", "Senegal", 20, Position.DEFENSA));
        bayern.addPlayer(new Player("21", "Lucas Hernández", "Francia", 21, Position.DEFENSA));
        bayern.addPlayer(new Player("23", "Blind", "Países Bajos", 23, Position.DEFENSA));
        bayern.addPlayer(new Player("24", "Tel", "Francia", 24, Position.DELANTERO));
        bayern.addPlayer(new Player("25", "Müller", "Alemania", 25, Position.DELANTERO));

        barcelona.addPlayer(new Player("1", "Ter Stegen", "Alemania", 1, Position.ARQUERO));
        barcelona.addPlayer(new Player("2", "Sergi Roberto", "España", 2, Position.DEFENSA));
        barcelona.addPlayer(new Player("3", "Piqué", "España", 3, Position.DEFENSA));
        barcelona.addPlayer(new Player("4", "Araujo", "Uruguay", 4, Position.DEFENSA));
        barcelona.addPlayer(new Player("5", "Sergio Busquets", "España", 5, Position.VOLANTE));
        barcelona.addPlayer(new Player("7", "Ousmane Dembélé", "Francia", 7, Position.DELANTERO));
        barcelona.addPlayer(new Player("8", "Pedri", "España", 8, Position.VOLANTE));
        barcelona.addPlayer(new Player("9", "Lewandowski", "Polonia", 9, Position.DELANTERO));
        barcelona.addPlayer(new Player("10", "Ansu Fati", "España", 10, Position.DELANTERO));
        barcelona.addPlayer(new Player("11", "Ferran Torres", "España", 11, Position.DELANTERO));
        barcelona.addPlayer(new Player("14", "Memphis Depay", "Países Bajos", 14, Position.DELANTERO));
        barcelona.addPlayer(new Player("15", "Andreas Christensen", "Dinamarca", 15, Position.DEFENSA));
        barcelona.addPlayer(new Player("17", "Marcos Alonso", "España", 17, Position.DEFENSA));
        barcelona.addPlayer(new Player("18", "Jordi Alba", "España", 18, Position.DEFENSA));
        barcelona.addPlayer(new Player("19", "Franck Kessié", "Costa de Marfil", 19, Position.VOLANTE));
        barcelona.addPlayer(new Player("20", "Sergiño Dest", "Estados Unidos", 20, Position.DEFENSA));
        barcelona.addPlayer(new Player("21", "Frenkie de Jong", "Países Bajos", 21, Position.VOLANTE));
        barcelona.addPlayer(new Player("22", "Raphinha", "Brasil", 22, Position.DELANTERO));
        barcelona.addPlayer(new Player("23", "Jules Koundé", "Francia", 23, Position.DEFENSA));
        barcelona.addPlayer(new Player("24", "Eric García", "España", 24, Position.DEFENSA));

        liverpool.addPlayer(new Player("1", "Alisson", "Brasil", 1, Position.ARQUERO));
        liverpool.addPlayer(new Player("4", "Van Dijk", "Países Bajos", 4, Position.DEFENSA));
        liverpool.addPlayer(new Player("5", "Konaté", "Francia", 5, Position.DEFENSA));
        liverpool.addPlayer(new Player("6", "Thiago", "España", 6, Position.VOLANTE));
        liverpool.addPlayer(new Player("7", "Luis Díaz", "Colombia", 7, Position.DELANTERO));
        liverpool.addPlayer(new Player("8", "Naby Keïta", "Guinea", 8, Position.VOLANTE));
        liverpool.addPlayer(new Player("9", "Firmino", "Brasil", 9, Position.DELANTERO));
        liverpool.addPlayer(new Player("11", "Salah", "Egipto", 11, Position.DELANTERO));
        liverpool.addPlayer(new Player("14", "Henderson", "Inglaterra", 14, Position.VOLANTE));
        liverpool.addPlayer(new Player("15", "Oxlade-Chamberlain", "Inglaterra", 15, Position.VOLANTE));
        liverpool.addPlayer(new Player("17", "Curtis Jones", "Inglaterra", 17, Position.VOLANTE));
        liverpool.addPlayer(new Player("19", "Elliott", "Inglaterra", 19, Position.VOLANTE));
        liverpool.addPlayer(new Player("20", "Diogo Jota", "Portugal", 20, Position.DELANTERO));
        liverpool.addPlayer(new Player("21", "Tsimikas", "Grecia", 21, Position.DEFENSA));
        liverpool.addPlayer(new Player("26", "Robertson", "Escocia", 26, Position.DEFENSA));
        liverpool.addPlayer(new Player("27", "Núñez", "Uruguay", 27, Position.DELANTERO));
        liverpool.addPlayer(new Player("32", "Matip", "Camerún", 32, Position.DEFENSA));
        liverpool.addPlayer(new Player("66", "Alexander-Arnold", "Inglaterra", 66, Position.DEFENSA));
        liverpool.addPlayer(new Player("62", "Kelleher", "Irlanda", 62, Position.ARQUERO));
        liverpool.addPlayer(new Player("23", "Arthur", "Brasil", 23, Position.VOLANTE));

        dormunt.addPlayer(new Player("1", "Kobel", "Suiza", 1, Position.ARQUERO));
        dormunt.addPlayer(new Player("2", "Morey", "España", 2, Position.DEFENSA));
        dormunt.addPlayer(new Player("4", "Schlotterbeck", "Alemania", 4, Position.DEFENSA));
        dormunt.addPlayer(new Player("5", "Hummels", "Alemania", 5, Position.DEFENSA));
        dormunt.addPlayer(new Player("6", "Can", "Alemania", 6, Position.VOLANTE));
        dormunt.addPlayer(new Player("7", "Reyna", "Estados Unidos", 7, Position.VOLANTE));
        dormunt.addPlayer(new Player("8", "Dahoud", "Alemania", 8, Position.VOLANTE));
        dormunt.addPlayer(new Player("9", "Haller", "Costa de Marfil", 9, Position.DELANTERO));
        dormunt.addPlayer(new Player("10", "Hazard", "Bélgica", 10, Position.DELANTERO));
        dormunt.addPlayer(new Player("11", "Reus", "Alemania", 11, Position.DELANTERO));
        dormunt.addPlayer(new Player("13", "Raphael Guerreiro", "Portugal", 13, Position.DEFENSA));
        dormunt.addPlayer(new Player("15", "Schulz", "Alemania", 15, Position.DEFENSA));
        dormunt.addPlayer(new Player("19", "Brandt", "Alemania", 19, Position.VOLANTE));
        dormunt.addPlayer(new Player("20", "Modeste", "Francia", 20, Position.DELANTERO));
        dormunt.addPlayer(new Player("21", "Malen", "Países Bajos", 21, Position.DELANTERO));
        dormunt.addPlayer(new Player("22", "Bellingham", "Inglaterra", 22, Position.VOLANTE));
        dormunt.addPlayer(new Player("23", "Emre Can", "Alemania", 23, Position.VOLANTE));
        dormunt.addPlayer(new Player("25", "Süle", "Alemania", 25, Position.DEFENSA));
        dormunt.addPlayer(new Player("30", "Passlack", "Alemania", 30, Position.DEFENSA));
        dormunt.addPlayer(new Player("33", "Meyer", "Alemania", 33, Position.ARQUERO));

        milan.addPlayer(new Player("16", "Mike Maignan", "Francia", 16, Position.ARQUERO));
        milan.addPlayer(new Player("2", "Davide Calabria", "Italia", 2, Position.DEFENSA));
        milan.addPlayer(new Player("24", "Simon Kjær", "Dinamarca", 24, Position.DEFENSA));
        milan.addPlayer(new Player("23", "Fikayo Tomori", "Inglaterra", 23, Position.DEFENSA));
        milan.addPlayer(new Player("19", "Theo Hernández", "Francia", 19, Position.DEFENSA));
        milan.addPlayer(new Player("8", "Sandro Tonali", "Italia", 8, Position.VOLANTE));
        milan.addPlayer(new Player("4", "Ismaël Bennacer", "Argelia", 4, Position.VOLANTE));
        milan.addPlayer(new Player("30", "Junior Messias", "Brasil", 30, Position.DELANTERO));
        milan.addPlayer(new Player("10", "Brahim Díaz", "España", 10, Position.VOLANTE));
        milan.addPlayer(new Player("17", "Rafael Leão", "Portugal", 17, Position.DELANTERO));
        milan.addPlayer(new Player("9", "Olivier Giroud", "Francia", 9, Position.DELANTERO));
        milan.addPlayer(new Player("1", "Ciprian Tătărușanu", "Rumania", 1, Position.ARQUERO));
        milan.addPlayer(new Player("7", "Yacine Adli", "Francia", 7, Position.VOLANTE));
        milan.addPlayer(new Player("14", "Alessandro Florenzi", "Italia", 14, Position.DEFENSA));
        milan.addPlayer(new Player("20", "Pierre Kalulu", "Francia", 20, Position.DEFENSA));
        milan.addPlayer(new Player("27", "Divock Origi", "Bélgica", 27, Position.DELANTERO));
        milan.addPlayer(new Player("33", "Rade Krunić", "Bosnia y Herzegovina", 33, Position.VOLANTE));
        milan.addPlayer(new Player("46", "Matteo Gabbia", "Italia", 46, Position.DEFENSA));
        milan.addPlayer(new Player("56", "Alexis Saelemaekers", "Bélgica", 56, Position.VOLANTE));
        milan.addPlayer(new Player("90", "Charles De Ketelaere", "Bélgica", 90, Position.DELANTERO));

        juventus.addPlayer(new Player("1", "Szczęsny", "Polonia", 1, Position.ARQUERO));
        juventus.addPlayer(new Player("3", "Bremer", "Brasil", 3, Position.DEFENSA));
        juventus.addPlayer(new Player("6", "Danilo", "Brasil", 6, Position.DEFENSA));
        juventus.addPlayer(new Player("7", "Chiesa", "Italia", 7, Position.DELANTERO));
        juventus.addPlayer(new Player("8", "McKennie", "Estados Unidos", 8, Position.VOLANTE));
        juventus.addPlayer(new Player("9", "Vlahović", "Serbia", 9, Position.DELANTERO));
        juventus.addPlayer(new Player("10", "Pogba", "Francia", 10, Position.VOLANTE));
        juventus.addPlayer(new Player("11", "Cuadrado", "Colombia", 11, Position.DEFENSA));
        juventus.addPlayer(new Player("12", "Alex Sandro", "Brasil", 12, Position.DEFENSA));
        juventus.addPlayer(new Player("14", "Milik", "Polonia", 14, Position.DELANTERO));
        juventus.addPlayer(new Player("15", "Federico Gatti", "Italia", 15, Position.DEFENSA));
        juventus.addPlayer(new Player("17", "Kostic", "Serbia", 17, Position.VOLANTE));
        juventus.addPlayer(new Player("18", "Moise Kean", "Italia", 18, Position.DELANTERO));
        juventus.addPlayer(new Player("20", "Miretti", "Italia", 20, Position.VOLANTE));
        juventus.addPlayer(new Player("21", "Kaio Jorge", "Brasil", 21, Position.DELANTERO));
        juventus.addPlayer(new Player("22", "Di María", "Argentina", 22, Position.DELANTERO));
        juventus.addPlayer(new Player("24", "Rugani", "Italia", 24, Position.DEFENSA));
        juventus.addPlayer(new Player("25", "Rabiot", "Francia", 25, Position.VOLANTE));
        juventus.addPlayer(new Player("30", "Soulé", "Italia", 30, Position.DELANTERO));
        juventus.addPlayer(new Player("36", "Perin", "Italia", 36, Position.ARQUERO));

        Referee referees1 = new Referee("R1", "Björn Kuipers", "Países Bajos", Rtype.CENTRAL);
        Referee referees2 = new Referee("R2", "Felix Brych", "Alemania", Rtype.CENTRAL);
        Referee refeeree3 = new Referee("R3", "Clément Turpin", "Francia", Rtype.CENTRAL);
        Referee referee4 = new Referee("R4", "Daniele Orsato", "Italia", Rtype.CENTRAL);

        Referee referee5 = new Referee("RA1", "Sander van Roekel", "Países Bajos", Rtype.ASISTENTE);
        Referee referee6 = new Referee("RA2", "Mark Borsch", "Alemania", Rtype.ASISTENTE);
        Referee referee7 = new Referee("RA3", "Nicolas Danos", "Francia", Rtype.ASISTENTE);
        Referee referee8 = new Referee("RA4", "Alessandro Giallatini", "Italia", Rtype.ASISTENTE);
        Referee referee9 = new Referee("RA5", "Erwin Zeinstra", "Países Bajos", Rtype.ASISTENTE);
        Referee referee10 = new Referee("RA6", "Stefan Lupp", "Alemania", Rtype.ASISTENTE);
        Referee referee11 = new Referee("RA7", "Cyril Gringore", "Francia", Rtype.ASISTENTE);
        Referee referee12 = new Referee("RA8", "Ciro Carbone", "Italia", Rtype.ASISTENTE);

        centralReferees[0] = referees1;
        centralReferees[1] = referees2;
        centralReferees[2] = refeeree3;
        centralReferees[3] = referee4;
        assistantReferees[0] = referee5;
        assistantReferees[1] = referee6;
        assistantReferees[2] = referee7;
        assistantReferees[3] = referee8;
        assistantReferees[4] = referee9;
        assistantReferees[5] = referee10;
        assistantReferees[6] = referee11;
        assistantReferees[7] = referee12;
    }

    /**
     * Description: This method registers a new team in the prevTeams array.
     * 
     * @param String name The name of the team.
     * @param String country The country of the team.
     * @param String coach The coach of the team.
     * @return True if the team was registered successfully, false otherwise.
     * 
     *         pre: The name, country and coach of the team should be provided.
     *         pos: The new team is added to the prevTeams array.
     */

    public boolean registerTeams(String name, String country, String coach) {
        Team newTeam = new Team(name, country, coach);
        for (int l = 0; l < prevTeams.length; l++) {
            if (prevTeams[l] == null) {
                prevTeams[l] = newTeam;
                return true;
            }
        }
        return false;

    }

    /**
     * Description: This method registers a new player in the persons array and adds
     * it to the specified team.
     *
     * @param String teamName The name of the team to which the player will be
     *               added.
     * @param String id The player's identification.
     * @param String name The player's name.
     * @param String country The player's country of origin.
     * @param int    shirtNumber The player's shirt number.
     * @param int    intPosition An integer representing the player's position (1
     *               for
     *               goalkeeper, 2 for defender, 3 for midfielder, 4 for
     *               forward).
     * @return True if the player was registered and added to the team successfully,
     *         false otherwise.
     * 
     *         pre: The teamName must correspond to an existing team, the id should
     *         be unique, the intPosition must be within the range of 1 to 4 and the
     *         shirtNumber mustn't exist.
     *         pos: If the preconditions are met the new player is added to the
     *         persons array and to the team's players list. If not, the player is
     *         not registered and the method returns false.
     */

    public boolean registerPlayers(String teamName, String id, String name, String country, int shirtNumber,
            int intPosition) {
        Position newPosition;

        switch (intPosition) {
            case 1:
                newPosition = Position.ARQUERO;
                break;

            case 2:
                newPosition = Position.DEFENSA;
                break;

            case 3:
                newPosition = Position.VOLANTE;
                break;

            case 4:
                newPosition = Position.DELANTERO;
                break;

            default:

                newPosition = null;

                break;
        }

        Player newPlayer = new Player(id, name, country, shirtNumber, newPosition);

        return addPlayerToTeam(newPlayer, teamName);
    }

    /**
     * Description: This method adds a player to a specific team.
     *
     * @param Player player The player to be added.
     * @param String teamName The name of the team to add the player to.
     * @return True if the player was successfully added to the team, false
     *         otherwise.
     * 
     *         pre: The player object should be valid and the team with the given
     *         teamName must exist. Also the persons array and the team players
     *         array must not be full.
     *         pos: The player is added to the persons array and to the players
     *         array of the team. If the team is not found or if the maximum number
     *         of players is reached, the player is not added and the method returns
     *         false.
     */

    public boolean addPlayerToTeam(Player player, String team) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null) {
                persons[i] = player;
                searchTeam(team).addPlayer(player);
                return true;
            }
        }
        return false;

    }

    /**
     * Description: This method analyzes if an ID already exists within the
     * registered persons (players or referees).
     *
     * @param String id The ID to analyze.
     * @return True if the ID already exists, false otherwise.
     *
     *         pre: The id should be provided.
     *         pos: Returns true if the ID is found in either the players or
     *         referees lists, false otherwise.
     */

    public boolean analyzeID(String id) {
        for (Person person : persons) {
            if ((person instanceof Player || person instanceof Referee) && person.getId().equals(id)) {
                return true; // ID already exists for a player or referee
            }
        }
        return false; // ID not found
    }

    /**
     * Description: This method analyzes if a shirt number already exists within the
     * registered players.
     *
     * @param int shirtNumber The shirt number to analyze.
     * @return True if the shirt number already exists, false otherwise.
     *
     *         pre: The shirtNumber should be provided.
     *         pos: Returns true if the shirtNumber is found in the players list,
     *         false otherwise.
     */
    public boolean analyzeNumber(int shirtNumber) {
        for (Person person : persons) {
            if (person instanceof Player && ((Player) person).getShirtNumber() == shirtNumber) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This method displays the information of a specific player.
     *
     * @param String id The ID of the player to search for.
     * @param Strig  teamName The name of the team the player belongs to. This helps
     *               narrow down the search if multiple players share the same
     *               ID.
     * @param String groupName The name of the group the team belongs to. This
     *               further
     *               specifies the search.
     * @return A String containing the player's information if found, or a message
     *         indicating the player was not found.
     *
     *         pre: The id, teamName, and groupName should be provided. The player
     *         with the given ID should exist within the specified team and group.
     *         pos: If the player is found, their information is returned as a
     *         String. If not, a message indicating that the player was not found is
     *         returned.
     */

    public String showPlayerInfo(String id, String team, String groupName) {
        Player player = searchPlayer(id, team, groupName);
        if (player != null) {
            return player.toString();
        } else
            return "Jugador no encontrado";
    }

    /**
     * Description: This method displays a list of players for a given team within a
     * specific group.
     *
     * @param String groupName The name of the group the team belongs to.
     * @param String teamName The name of the team whose players are to be listed.
     * @return A String containing a formatted list of players if the team and group
     *         exist,
     *         or an appropriate message if the group or team are not found.
     *
     *         pre: The groupName and teamName should correspond to an existing
     *         group and team respectively.
     *         pos: A formatted string is returned listing the players' ID, name,
     *         shirt number, and position.
     *         If the group or team doesn't exist, a message indicating the error is
     *         returned.
     */

    public String showPlayerList(String groupName, String teamName) {
        Group group = searchGroup(groupName);

        if (group != null) {
            Team team = group.searchTeam(teamName);
            if (team != null) {
                return team.showPlayerList();
            } else {
                return "Equipo no encontrado en el grupo.";
            }
        } else {
            return "Grupo no encontrado.";
        }
    }

    /**
     * Description: This method registers a new referee in the system.
     *
     * @param String id The referee's identification.
     * @param String name The referee's name.
     * @param String country The referee's country of origin.
     * @param String type An integer representing the referee's type (1 for central,
     *               2
     *               for assistant).
     * @return True if the referee was registered successfully, false otherwise.
     *
     *         pre: The id should be unique and the type should be either 1 or 2.
     *         There should be available space in the corresponding referee array
     *         (centralReferees or assistantReferees) and the persons array.
     *         pos: If the preconditions are met, the new referee is added to the
     *         persons array and to the correct referee array (centralReferees or
     *         assistantReferees) based on their type. If the type is invalid, or if
     *         the maximum number of referees of the specified type is reached the
     *         referee is not added and the method returns false.
     */

    public boolean registerReferees(String id, String name, String country, int type) {
        Rtype newType;
        switch (type) {
            case 1:
                newType = Rtype.CENTRAL;
                break;

            case 2:
                newType = Rtype.ASISTENTE;
                break;

            default:

                newType = null;

                break;
        }

        Referee newReferee = new Referee(id, name, country, newType);
        return addReferee(newReferee);
    }

    /**
     * Description: This method adds a referee to the appropriate referee array
     * (either centralReferees or assistantReferees) and also to the persons array.
     *
     * @param Referee referee The referee object to be added.
     * @return True if the referee was added successfully, false otherwise.
     *
     *         pre: The referee object should be valid, and there should be space
     *         available in both the appropriate referee array (based on Rtype) and
     *         the persons array.
     *         pos: The referee is added to the persons array and to either the
     *         centralReferees or assistantReferees array, based on the referee's
     *         type. If no space is available in either array, the referee is not
     *         added and the method returns false.
     */

    public boolean addReferee(Referee referee) {
        if (referee.getRtype() == Rtype.CENTRAL) {
            for (int i = 0; i < centralReferees.length; i++) {
                if (centralReferees[i] == null) {
                    centralReferees[i] = referee;
                    for (int l = 0; l < persons.length; l++) {
                        if (persons[l] == null) {
                            persons[l] = referee;
                            break;
                        }
                    }
                    return true;
                }
            }
        } else if (referee.getRtype() == Rtype.ASISTENTE) {
            for (int i = 0; i < assistantReferees.length; i++) {
                if (assistantReferees[i] == null) {
                    assistantReferees[i] = referee;
                    for (int l = 0; l < persons.length; l++) {
                        if (persons[l] == null) {
                            persons[l] = referee;
                            break;
                        }
                    }
                    return true;
                }
            }
        }
        return false; // No space in either array
    }

    /**
     * Description: This method searches for a central referee by their ID.
     *
     * @param Strinh id The ID of the central referee to search for.
     * @return The central referee if found, null otherwise.
     *
     *         pre: The id should be a valid referee ID.
     *         pos: The central referee with the matching ID is returned. If no such
     *         referee is found, null is returned.
     */

    public Referee searchCentralReferee(String id) {

        for (int i = 0; i < centralReferees.length; i++) {
            if (centralReferees[i] != null && centralReferees[i].getId().equals(id)) {
                return centralReferees[i];
            }
        }
        return null;

    }

    /**
     * Description: This method returns a string with the list of teams.
     * 
     * @return A string with the list of teams.
     * 
     *         pre: The prevTeams array should be initialized.
     *         pos: A string with the list of teams is returned.
     */

    public String teamsList() {
        String list = "";
        boolean validar = false;
        for (int j = 0; j < prevTeams.length; j++) {
            if (prevTeams[j] != null) {
                list += "\n" + prevTeams[j].getName() + " - " + prevTeams[j].getCountry() + " - "
                        + prevTeams[j].getCoach() + "\n";
                validar = true;
            }

        }
        if (validar == false) {
            list = "No hay equipos registrados";

        }

        return list;

    }

    /**
     * Description: This method searches for a player within a specific team and
     * group by their ID.
     *
     * @param String id The ID of the player to search for.
     * @param String teamName The name of the team the player belongs to.
     * @param String groupName The name of the group the team belongs to.
     * @return The Player object if found, null otherwise.
     *
     *         pre: The id, teamName, and groupName should be provided.
     *         pos: If a player with the matching ID is found within the specified
     *         team and group, the Player object is returned. Otherwise, null is
     *         returned.
     */

    public Player searchPlayer(String id, String teamName, String groupName) {
        Group group = searchGroup(groupName);
        if (group != null) {
            Team team = searchTeamInGroup(groupName, teamName); // Using teamName to search
            if (team != null) { // Make sure the team exists
                return team.searchPlayer(id); // The bug is corrected here.
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Description: This method adds goals to a player's statistics.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String groupName The name of the group the team belongs to.
     * @param String id The ID of the player.
     * 
     *               pre: The teamName, groupName, and id should correspond to a
     *               valid team, group, and player, respectively.
     *               pos: The specified player's goal count is incremented. If
     *               the player is not found, no changes are made.
     */

    public void addGoalsToPlayer(String teamName, String groupName, String id) {
        Group group = searchGroup(groupName);
        if (group != null) {
            group.addGoalsToPlayer(teamName, id);
        }
    }

    /**
     * Description: This method adds assists to a player's statistics.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String groupName The name of the group the team belongs to.
     * @param String id The ID of the player.
     * 
     *               pre: The teamName, groupName, and id should correspond to a
     *               valid team, group, and player, respectively.
     *               pos: The specified player's assist count is incremented. If
     *               the player is not found, no changes are made.
     */

    public void addAssistsToPlayer(String teamName, String groupName, String id) {
        Group group = searchGroup(groupName);
        if (group != null) {
            group.addAssistsToPlayer(teamName, id);
        }
    }

    /**
     * Description: This method adds a yellow card to a player's statistics.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String groupName The name of the group the team belongs to.
     * @param String id The ID of the player.
     * 
     *               pre: The teamName, groupName, and id should correspond to a
     *               valid team, group, and player, respectively.
     *               pos: The specified player's yellow card count is
     *               incremented. If the player is not found, no changes are
     *               made.
     */

    public void addYelllowCardToPlayer(String teamName, String groupName, String id) {
        Group group = searchGroup(groupName);
        if (group != null) {
            group.addYelllowCardToPlayer(teamName, id);
            ;
        }
    }

    /**
     * Description: This method adds a red card to a player's statistics.
     *
     * @param String teamName The name of the team the player belongs to.
     * @param String groupName The name of the group the team belongs to.
     * @param String id The ID of the player.
     * 
     *               pre: The teamName, groupName, and id should correspond to a
     *               valid team, group, and player, respectively.
     *               pos: The specified player's red card count is incremented.
     *               If the player is not found, no changes are made.
     */

    public void addRedCardToPlayer(String teamName, String groupName, String id) {
        Group group = searchGroup(groupName);
        if (group != null) {
            group.addRedCardToPlayer(teamName, id);
        }
    }

    /**
     * Description: This method retrieves the ID of the central referee assigned to
     * a specific match.
     *
     * @param String groupName The name of the group where the match took place.
     * @param String team1 The name of the first team in the match.
     * @param String team2 The name of the second team in the match.
     * @return The ID of the central referee for the specified match, or null if the
     *         match is not found.
     *
     *         pre: The groupName, team1, and team2 must correspond to a valid
     *         match.
     *         pos: The ID of the central referee is returned. If no match is found
     *         or if the match doesn't have an assigned referee, null is returned.
     */

    public String getRefereeIdFromMatch(String groupName, String team1, String team2) {
        Match match = searchMatch(groupName, team1, team2);
        if (match != null) {
            return match.getMatchReferees()[0].getId(); // Assuming central referee is at index 0
        } else {
            return null; // Or handle the error appropriately
        }
    }

    /**
     * Description: This method adds a card to a referee's statistics
     * during a specific match.
     *
     * @param String groupName The name of the group where the match took place.
     * @param String team1 The name of the first team in the match.
     * @param String team2 The name of the second team in the match.
     * @param String refereeId The ID of the referee who received the card. It is
     *               assumed
     *               the card is for the central referee.
     * 
     *               pre: The groupName, team1, team2, and refereeId must
     *               correspond to a valid match and referee. cardType must be a
     *               valid card type.
     *               pos: The specified referee's card count (either yellow or
     *               red depending on cardType) is incremented for the indicated
     *               match. If the referee or match is not found, no changes are
     *               made. No validation is performed to prevent excessive cards.
     */
    public void addCardToReferee(String groupName, String team1, String team2, String refereeId) {
        Match match = searchMatch(groupName, team1, team2);
        if (match != null) {
            match.addCardToReferee(refereeId);
        }
    }

    /**
     * Description: This method searches for a team in the prevTeams array.
     * 
     * @param String teamName The name of the team to search for.
     * @return The team if it is found, null otherwise.
     * 
     *         pre: The team name should be provided.
     *         pos: The team is returned if it is found, null otherwise.
     */

    public Team searchTeam(String teamName) {
        if (prevTeams == null) {
            return null;
        } else {
            for (int k = 0; k < prevTeams.length; k++) {
                if (prevTeams[k].getName().equals(teamName)) {
                    return prevTeams[k];
                }
            }
        }
        return null;
    }

    /**
     * Description: This method searches for a team within a specific group by its
     * name.
     *
     * @param String groupName The name of the group to search within.
     * @param String teamName The name of the team to search for.
     * @return The Team object if found, null otherwise.
     *
     *         pre: The groupName and teamName should be provided.
     *         pos: If a team with the matching teamName is found within the
     *         specified group, the Team object is returned. Otherwise, null is
     *         returned.
     */

    public Team searchTeamInGroup(String groupName, String teamName) {
        Group group = searchGroup(groupName);
        if (group != null) {
            return group.searchTeam(teamName);
        } else {
            return null;
        }
    }

    /**
     * Description: This method adds a played match to a specific group.
     *
     * @param String team1 The name of the first team.
     * @param String team2 The name of the second team.
     * @param String groupName The name of the group to add the match to.
     * @param String idReferee The ID of the central referee for the match.
     * @return A string indicating success or failure, including error messages if
     *         necessary. Could return the generated Match object's ID if
     *         successful.
     *
     *         pre: The team1, team2, groupName, and idReferee should correspond to
     *         valid team names, a group name, and a central referee's ID
     *         respectively. The two teams should belong to the specified group. The
     *         referee should not be from the same country as either team. The match
     *         should not already exist in the group.
     *         pos: A new Match object is created and added to the specified group's
     *         matches array. The scores, goals, and assists are not recorded at
     *         this stage. Returns a success message, or a failure message
     *         indicating why the operation failed.
     */

    public String addMatchPlayed(String team1, String team2, String groupName, String idReferee) {
        Group group = searchGroup(groupName);
        return group.addMatchPlayed(team1, team2, idReferee);

    }

    /**
     * Description: This method generates the groups for the tournament.
     * 
     * pre: The prevTeams array should be initialized.
     * pos: The groups array is filled with the generated groups.
     */

    public void generateGroups() {
        Random rand = new Random();
        for (int i = prevTeams.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            Team temp = prevTeams[i];
            prevTeams[i] = prevTeams[j];
            prevTeams[j] = temp;
        }

        for (int i = 0; i < prevTeams.length; i++) {
            int groupIndex = i / 4;

            groups[groupIndex].addTeam(prevTeams[i], i % 4);
        }
    }

    /**
     * Description: This method returns a string with the list of groups.
     * 
     * @return A string with the list of groups.
     * 
     *         pre: The groups array should be initialized.
     *         pos: A string with the list of groups is returned.
     */

    public String showGroupList() {
        String list2 = "";
        boolean validar2 = false;
        for (int j = 0; j < groups.length; j++) {
            if (groups[j] != null) {
                list2 += "\n" + groups[j].getName() + "\n";
                for (int a = 0; a < groups[j].getTeams().length; a++) {
                    if (groups[j].getTeams()[a] != null) {
                        list2 += "-" + groups[j].getTeams()[a].getName() + "\n";
                    }
                }

                validar2 = true;
            }

        }
        if (validar2 == false) {
            list2 = "No hay equipos registrados";

        }

        return list2;
    }

    /**
     * Description: This method returns a string with the list of matches.
     * 
     * @return A string with the list of matches.
     * 
     *         pre: The groups array should be initialized.
     *         pos: A string with the list of matches is returned.
     */

    public String showMatchList() {
        String list2 = "";
        generateMatches();

        for (int j = 0; j < groups.length; j++) {
            list2 += "\nPartidos:\n";
            int matchCounter = 1;

            for (Match match : groups[j].getMatches()) {
                if (match != null) {
                    list2 += matchCounter + ". " + match.getTeam1().getName() + " vs " + match.getTeam2().getName()
                            + " - "
                            + match.getMatchDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
                    list2 += "Árbitro: " + match.getMatchReferees()[0].getName() + " ("
                            + match.getMatchReferees()[0].getCountry() + ")\n";
                    list2 += "Asistente 1: " + match.getMatchReferees()[1].getName() + " ("
                            + match.getMatchReferees()[1].getCountry() + ")\n";
                    list2 += "Asistente 2: " + match.getMatchReferees()[2].getName() + " ("
                            + match.getMatchReferees()[2].getCountry() + ")\n\n";

                    matchCounter++;
                }
            }
        }

        return list2;
    }

    /**
     * Description: This method searches for a group in the groups array.
     * 
     * @param String groupName The name of the group to search for.
     * @return The group if it is found, null otherwise.
     * 
     *         pre: The group name should be provided.
     *         pos: The group is returned if it is found, null otherwise.
     */

    public Group searchGroup(String groupName) {
        for (Group group : groups) {
            if (group.getName().equalsIgnoreCase(groupName)) {
                return group;
            }
        }
        return null;
    }

    /**
     * Description: This method searches for a match in the groups array.
     * 
     * @param String team1Name The name of the first team in the match.
     * @param String team2Name The name of the second team in the match.
     * @return The match if it is found, null otherwise.
     * 
     *         pre: The names of the teams should be provided.
     *         pos: The match is returned if it is found, null otherwise.
     */

    public Match searchMatch(String groupName, String team1Name, String team2Name) {
        Group group = searchGroup(groupName);
        if (group != null) {
            return group.searchMatch(team1Name, team2Name);
        } else {
            return null;
        }

    }

    /**
     * Description: This method schedules the matches for a given group.
     * 
     * @param Group group The group for which to schedule the matches.
     * 
     *              pre: The group object should be provided.
     *              pos: The matches are scheduled for the given group.
     */

    public void scheduleMatch(Group group) {
        Team[] teams = group.getTeams();
        Match[] matches = group.getMatches();

        int daysAvailable = (int) startDate.until(endDate).getDays();

        int daysPerMatch = daysAvailable / (teams.length - 1);

        LocalDate matchDate = startDate;
        int matchIndex = 0;

        for (int i = 0; i < teams.length - 1; i++) {
            for (int j = i + 1; j < teams.length; j++) {

                matches[matchIndex++] = new Match(teams[i], teams[j], matchDate);

                do {
                    matchDate = matchDate.plusDays(2);
                } while (hasMatchOnDate(teams[i], matchDate, matches) ||
                        hasMatchOnDate(teams[j], matchDate, matches));
            }

            matchDate = matchDate.plusDays(daysPerMatch - (teams.length - 2));
        }

        matches[matches.length - 2] = new Match(teams[1], teams[3], endDate);
        matches[matches.length - 1] = new Match(teams[0], teams[2], endDate);
    }

    /**
     * Description: This method checks if a team has a match on a given date.
     * 
     * @param Team      team The team to check for.
     * @param LocalDate date The date to check for.
     * @param Match[]   matches The array of matches to check in.
     * @return True if the team has a match on the given date, false otherwise.
     * 
     *         pre: The team, date and matches array should be provided.
     *         pos: True is returned if the team has a match on the given date,
     *         false otherwise.
     */

    private boolean hasMatchOnDate(Team team, LocalDate date, Match[] matches) {
        for (Match match : matches) {
            if (match != null && match.getMatchDate() != null &&
                    match.getMatchDate().isEqual(date) &&
                    (match.getTeam1() == team || match.getTeam2() == team)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This method generates the matches for the tournament.
     * 
     * pre: The groups array should be initialized.
     * pos: The matches are generated for each group.
     */

    public void generateMatches() {
        Random rand = new Random();

        for (Group group : groups) {
            scheduleMatch(group);

            for (Match match : group.getMatches()) {
                if (match != null) {

                    do {
                        int j = rand.nextInt(4);
                        Referee temp = centralReferees[j];
                        match.getMatchReferees()[0] = temp;
                    } while (match.getMatchReferees()[0] == null
                            || match.getMatchReferees()[0].getRtype() != Rtype.CENTRAL
                            || match.getMatchReferees()[0].getCountry() == match.getTeam1().getCountry()
                            || match.getMatchReferees()[0].getCountry() == match.getTeam2().getCountry());

                    do {
                        int j = rand.nextInt(8);
                        Referee temp = assistantReferees[j];
                        match.getMatchReferees()[1] = temp;
                    } while (match.getMatchReferees()[1] == null
                            || match.getMatchReferees()[1].getRtype() != Rtype.ASISTENTE
                            || match.getMatchReferees()[1].getCountry() == match.getTeam1().getCountry()
                            || match.getMatchReferees()[1].getCountry() == match.getTeam2().getCountry());

                    do {
                        int j = rand.nextInt(8);
                        Referee temp = assistantReferees[j];
                        match.getMatchReferees()[2] = temp;
                    } while (match.getMatchReferees()[2] == null
                            || match.getMatchReferees()[2].getRtype() != Rtype.ASISTENTE
                            || match.getMatchReferees()[2].getCountry() == match.getTeam1().getCountry()
                            || match.getMatchReferees()[2].getCountry() == match.getTeam2().getCountry()
                            || match.getMatchReferees()[2] == match.getMatchReferees()[1]);

                }
            }

        }
    }

    /**
     * Description: This method sets the goals for a given match.
     * 
     * @param int goalsTeam1 The goals scored by the first team.
     * @param int goalsTeam2 The goals scored by the second team.
     * 
     *            pre: The goals scored by each team should be provided.
     *            pos: The goals are set for the given match.
     */

    public String showPendingMatches(Group group) {
        String mensaje = "";

        if (group == null) {
            mensaje = "Grupo no encontrado.";
            return mensaje;
        }

        mensaje = "Partidos pendientes del grupo " + group.getName() + ":\n"; // Initial message

        for (Match match : group.getMatches()) {
            if (match != null && match.getTeam1() != null && match.getTeam2() != null &&
                    match.getScoreTeam1() == 0 && match.getScoreTeam2() == 0) {
                // Concatenate to the existing mensaje
                mensaje += match.getTeam1().getName() + " vs. " + match.getTeam2().getName() + "\n";
            }
        }

        if (mensaje.equals("Partidos pendientes del grupo " + group.getName() + ":\n")) {
            // If no matches were added, indicate that
            mensaje += "No hay partidos pendientes en este grupo.\n";
        }

        return mensaje;
    }

    /**
     * Description: This method sets the goals scored by each team in a specific
     * match.
     *
     * @param String groupName The name of the group the match belongs to.
     * @param String team1 The name of the first team in the match.
     * @param String team2 The name of the second team in the match.
     * @param int    goals1 The number of goals scored by the first team.
     * @param int    goals2 The number of goals scored by the second team.
     * @return A message indicating success or failure, including an explanation if
     *         the match isn't found.
     *
     *         pre: The groupName, team1, and team2 must correspond to a valid,
     *         existing match within the tournament. goals1 and goals2 must be
     *         non-negative integers.
     *         pos: The specified match's scores are updated with the given goals.
     *         If the match isn't found, no changes are made, and an error message
     *         is returned.
     */
    public String setGoals(String groupName, String team1, String team2, int goalsTeam1, int goalsTeam2) {
        Group group = searchGroup(groupName);
        if (group != null) {
            return group.setMatchResult(team1, team2, goalsTeam1, goalsTeam2);
        } else {

            return "Error: Group not found.";
        }
    }

    /**
     * Description: This method calculates and returns the top goal scorer of the
     * tournament.
     *
     * @return The Player object representing the top goal scorer, or null if no
     *         players have scored any goals.
     *
     *         pre: The tournament must have started and player goal statistics must
     *         have been recorded.
     *         pos: The player with the highest number of goals in the tournament is
     *         returned. If multiple players are tied for the top spot, one of them
     *         is chosen arbitrarily.
     */

    public String calcTopGoalScorer() {
        Player topScorer = null;
        int maxGoals = -1;

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != null) {
                Player groupTopScorer = groups[i].calcTopGoalScorer();
                if (groupTopScorer != null && groupTopScorer.getGoals() > maxGoals) {
                    topScorer = groupTopScorer;
                    maxGoals = topScorer.getGoals();
                }
            }
        }

        String topScorerInfo;
        if (topScorer != null) {
            topScorerInfo = "Top Scorer:\n" + topScorer.toString();
        } else {
            topScorerInfo = "No goals scored yet.";
        }

        return topScorerInfo;
    }

    /**
     * Description: This method calculates and returns the team with the best fair
     * play score in the tournament.
     *
     * @return The Team object with the lowest accumulated penalty points (best fair
     *         play score), or null if no teams are registered or if no matches have
     *         been played.
     *
     *         pre: The tournament should have started, teams should be registered,
     *         and matches should have been played. Cards issued during matches
     *         should have been recorded.
     *         pos: The team with the lowest sum of penalty points from yellow and
     *         red cards is returned. If multiple teams have the same lowest score,
     *         one of them is returned arbitrarily. Yellow cards are assumed to have
     *         a weight of 1 point and red cards a weight of 2 points (or another
     *         predefined weighting if specified in the Match or related classes.)
     */

    public String calcFairPlay() {
        Team fairPlayTeam = null;
        int lessCards = -1;

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != null) {
                Team groupFairPlayTeam = groups[i].calcFairPlayTeam();
                if (groupFairPlayTeam != null && groupFairPlayTeam.getCards() < lessCards) {
                    fairPlayTeam = groupFairPlayTeam;
                    lessCards = fairPlayTeam.getCards();
                }
            }
        }

        String fairPlayTeamInfo;
        if (fairPlayTeam != null) {
            fairPlayTeamInfo = "Fair Play Team:\n" + fairPlayTeam.toString();
        } else {
            fairPlayTeamInfo = "No fair play teams yet.";
        }

        return fairPlayTeamInfo;

    }

    /**
     * Description: This method calculates and displays the efficiency of a specific
     * team in the tournament.
     *
     * @param String groupName The name of the group in which the team participates.
     * @param String teamName The name of the team whose efficiency is to be
     *               calculated.
     * @return A double as the calculation of team's efficiency, or a message
     *         indicating that the team or group was not found or that no matches
     *         have been played.
     *
     *         pre: The tournament should have started, the team should be
     *         registered, and matches involving the team should have been played
     *         and results recorded.
     *         pos: A string representing the calculated efficiency of the specified
     *         team is returned. If the team or group is not found or if no matches
     *         have been played by the team, an appropriate message is returned
     *         instead.
     */
    public double calcTeamEfficiency(String groupName, String teamName) {
        Group group = searchGroup(groupName);
        if (group != null) {
            return group.calcTeamEfficiency(teamName);
        } else {
            return 0.0;
        }
    }

    /**
     * Description: This method calculates and displays the efficiency of a specific
     * player in the tournament.
     *
     * @param String groupName The name of the group the player's team belongs to.
     * @param String teamName The name of the team the player belongs to.
     * @param String playerId The ID of the player whose efficiency is to be
     *               calculated.
     * @return A string representation of the player's efficiency, or a message
     *         indicating that the player, team, or group was not found.
     * 
     *
     *         pre: The tournament should have started, the player should be
     *         registered, and matches involving the player's team should have been
     *         played with player statistics recorded.
     *         pos: A double result of the calculated efficiency of the specified
     *         player is returned. If the player, team or group are not found, an
     *         appropriate message is returned instead.
     */
    public double calcPlayerEfficiency(String playerId, String teamName, String groupName) {
        Group group = searchGroup(groupName);

        return group.calcPlayerEfficiency(playerId, teamName);

    }

    /**
     * Description: This method calculates and returns the index of a referee based
     * on the number of cards they've issued.
     *
     * @param String refereeId The ID of the referee whose index is to be
     *               calculated.
     * @return A string representing the referee's card index, or a message
     *         indicating that the referee was not found. The card index is
     *         calculated as cards given divided by games played.
     *
     *         pre: The referee with the given ID should exist. Card statistics for
     *         the referee should have been recorded.
     *         pos: A string containing the calculated card index for the specified
     *         referee is returned. If the referee is not found, an appropriate
     *         message is returned.
     */

    public double calcRefereeCardIndex(String refereeId) {
        Referee referee = searchCentralReferee(refereeId);

        return referee.calcCardIndex();

    }

    /**
     * Description: This method generates and returns the leaderboard for a
     * specified group.
     *
     * @param groupName The name of the group for which to generate the leaderboard.
     * @return A formatted string representing the leaderboard for the given group,
     *         or a message indicating the group was not found or no matches have
     *         been played.
     *
     *         pre: The group with the specified groupName should exist. Matches
     *         within the group should have been played and results recorded.
     *         pos: A string containing the leaderboard is returned. The leaderboard
     *         should display teams ranked by points, considering tiebreakers if
     *         necessary (e.g., goal difference, goals scored, head-to-head
     *         results). If the group is not found or no matches have been played,
     *         an appropriate message is returned.
     */

    public String generateLeaderboard(String groupName) {
        Group group = searchGroup(groupName);
        if (group == null) {
            return "Grupo no encontrado.";
        }

        Team[] teams = group.getTeams();

        if (teams != null) {
            // Bubble Sort Implementation (Simplified for Leaderboard)
            int n = teams.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (teams[j].getPoints() < teams[j + 1].getPoints() ||
                            (teams[j].getPoints() == teams[j + 1].getPoints()
                                    && teams[j].goalDifference() < teams[j + 1].goalDifference())
                            ||
                            (teams[j].getPoints() == teams[j + 1].getPoints()
                                    && teams[j].goalDifference() == teams[j + 1].goalDifference()
                                    && teams[j].getGoalsScored() < teams[j + 1].getGoalsScored())) {

                        // Swap
                        Team temp = teams[j];
                        teams[j] = teams[j + 1];
                        teams[j + 1] = temp;

                    } else if (teams[j] == null) {

                        Team temp = teams[j]; // Move the null team to the end of the list
                        teams[j] = teams[j + 1];
                        teams[j + 1] = temp;

                        System.out.print("Null team detected, position: " + j);
                    }

                }

            }

            // Leaderboard Formatting
            StringBuilder leaderboard = new StringBuilder();

            leaderboard.append("Tabla de Posiciones - Grupo ").append(groupName).append("\n");
            leaderboard.append("Equipo | PJ | GF | GC | DG | Pts | PG | PE | PP\n");
            leaderboard.append("--------------------------------------------------\n");

            for (Team team : teams) {
                if (team != null) {
                    leaderboard.append(String.format("%s | %d | %d | %d | %d | %d | %d | %d | %d\n",
                            team.getName(), team.getGamesPlayed(), team.getGoalsScored(), team.getGoalsConceded(),
                            team.goalDifference(), team.getPoints(), team.getGamesWon(), team.getGamesDrawn(),
                            team.getGamesLost()));
                }
            }

            return leaderboard.toString();
        } else

        {
            return "No teams found for this group."; // Handle null teams array
        }
    }
}
