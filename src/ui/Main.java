package ui;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Controller;

public class Main {
    private Scanner reader = new Scanner(System.in);
    private Controller controller = new Controller();

    /**
     * Description: Main method that starts the application.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();

    }

    /**
     * Description: Displays the main menu of the application and manages user
     * options.
     * 
     * pre: The controller object must be initialized.
     * pos: The user is interacted with and the selected options are executed.
     */
    public void menu() {
        int opcion = 0;
        boolean close = false;
        System.out.println("Bienvenido al programa de gestion del torneo de futbol");
        do {

            System.out.println("Menu principal");
            System.out.println("1. Registrar un torneo");
            System.out.println("2. Registrar un equipo");
            System.out.println("3. Registrar jugadores a un equipo");
            System.out.println("4. Registrar un arbitro");
            System.out.println("5. Generar Grupos y fixture");
            System.out.println("6. Registrar Marcador de un partido");
            System.out.println("7. Mostrar Estadisticas");
            System.out.println("8. Calcular la eficiencia de un equipo");
            System.out.println("9. Calcular la eficiencia de un jugador");
            System.out.println("10. Calcular el indice de tarjetas de un arbitro central");
            System.out.println("11. Mostrar tabla de posiciones");
            System.out.println("0. Salir");
            opcion = reader.nextInt();
            reader.nextLine();

            switch (opcion) {

                case 1:
                    registerTournament();
                    break;

                case 2:
                    registerTeams();

                    break;

                case 3:
                    registerPlayers();

                    break;

                case 4:
                    registerReferee();
                    break;

                case 5:
                    controller.generateGroups();
                    showGroupList();
                    showMatchList();

                    break;
                case 6:
                    registerScore();
                    break;

                case 7:
                    calcTopGoalscorer();
                    calcFairPlay();
                    break;

                case 8:
                    calcTeamEfficiency();
                    break;
                case 9:
                    calcPlayerEfficiency();
                    break;
                case 10:
                    calcRefereeCardIndex();
                    break;
                case 11:
                    showLaderBoard();
                    break;

                case 0:
                    close = true;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!close);

    }

    /**
     * Description: Registers a new tournament with name, start date and end date.
     * 
     * pre: The controller object must be initialized.
     * pos: If the input dates are valid, a new tournament is registered in the
     * controller with the provided name, start date, and end date. If the date
     * format is incorrect, the tournament is not registered. A success or failure
     * message is printed to the console.
     */

    public void registerTournament() {
        System.out.println("Seleccionaste Registrar un torneo");
        System.out.println("Ingrese el nombre del torneo");
        String name = reader.nextLine();

        // Give the date a format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Ingrese la fecha de inicio del torneo en formato (dd/MM/yyyy): ");
        String startDate = reader.nextLine();

        LocalDate date = LocalDate.parse(startDate, formatter);

        System.out.println("Ingrese la fecha de finalizacion del torneo en formato (dd/MM/yyyy): ");
        String endDate = reader.nextLine();

        // Convert the date using the formatter
        LocalDate date2 = LocalDate.parse(endDate, formatter);

        controller.setName(name);
        controller.setStartDate(date);
        controller.setEndDate(date2);

        boolean result3 = true;

        if (result3 == true) {
            System.out.println("Torneo registrado correctamente");
        } else {
            System.out.println("No se pudo registrar el torneo");
        }

    }

    /**
     * Description: Registers a new team with name, country and coach.
     * 
     * pre: The controller object must be initialized.
     * pos: A new team is registered in the controller.
     */
    public void registerTeams() {

        System.out.println("Seleccionaste Registrar un equipo");
        System.out.println("Ingrese el nombre del equipo");
        String name = reader.nextLine();

        System.out.println("Ingrese el pais del equipo");
        String country = reader.nextLine();
        System.out.println("Ingrese el entrenador del equipo");
        String coach = reader.nextLine();

        boolean result = controller.registerTeams(name, country, coach);

        if (result == true) {
            System.out.println("Equipo registrado correctamente");
        } else {
            System.out.println("No se pudo registrar el equipo");
        }

    }

    /**
     * Description: Displays the list of teams registered in the controller.
     * 
     * pre: The controller object must be initialized.
     * pos: There are no changes to global variables.
     */
    public void showTeams() {
        System.out.println(controller.teamsList());
    }

    /**
     * Description: Displays the list of groups generated in the controller.
     * 
     * pre: The controller object must be initialized.
     * pos: There are no changes to global variables.
     */
    public void showGroupList() {
        System.out.println(controller.showGroupList());
    }

    /**
     * Description: Displays the list of matches generated in the controller.
     * 
     * pre: The controller object must be initialized.
     * pos: There are no changes to global variables.
     */

    public void showMatchList() {
        System.out.println(controller.showMatchList());
    }

    /**
     * Description: Registers players to a team selected by the user.
     * 
     * pre: The controller object must be initialized.
     * pos: Players are registered to the selected team within the controller.
     */

    public void registerPlayers() {
        int player = 1;
        boolean result2;
        String playerId;
        int shirtNumber;
        System.out.println("Seleccionaste Registrar jugadores a un equipo");
        System.out.println(controller.teamsList());
        System.out.println("A que equipo desea añadirle jugadores?");
        String teamName = reader.nextLine();

        if (controller.searchTeam(teamName) != null) {

            do {
                do {
                    System.out.println("Ingrese los datos del jugador No." + player);
                    do {
                        System.out.print("id: ");
                        playerId = reader.nextLine();
                    } while (controller.analyzeID(playerId));
                    System.out.print("Nombre: ");
                    String playerName = reader.nextLine();
                    System.out.print("Pais de origen: ");
                    String playerCountry = reader.nextLine();
                    do {
                        System.out.print("Dorsal: ");
                        shirtNumber = reader.nextInt();
                        reader.nextLine();
                    } while (controller.analyzeNumber(shirtNumber));
                    System.out.print("Posicion (1. ARQUERO, 2. DEFENSA, 3. VOLANTE, 4. DELANTERO): ");
                    int intPosition = reader.nextInt();

                    reader.nextLine();

                    result2 = controller.registerPlayers(teamName, playerId, playerName, playerCountry, shirtNumber,
                            intPosition);

                    if (result2 == true && intPosition >= 1 && intPosition <= 4) {
                        System.out.println("Jugador registrado correctamente");
                        player++;
                    } else {
                        System.out.println("No se pudo registrar el jugador");
                    }

                } while (result2 == true);

            } while (player <= 20);
        } else {
            System.out.println("Equipo no encontrado");

        }

    }

    /**
     * Description: Registers a referee with their ID, name, country, and type
     * (central or assistant).
     * 
     * pre: The controller object must be initialized. The provided ID should not
     * already be in use by another person (player or referee). Input for referee
     * type must be either 1 (Central) or 2(Assistant).
     * pos: If successful, a new referee is registered in the controller with the
     * given details. If the ID is already in use or if there is no space to add
     * another referee, the registration fails and no changes are made. A success or
     * failure message is printed to the console.
     */
    public void registerReferee() {
        String id;

        System.out.println("Seleccionaste Registrar un arbitro");
        do {
            System.out.println("Ingres el id del arbitro");
            id = reader.nextLine();
        } while (controller.analyzeID(id));
        System.out.println("Ingrese el nombre del arbitro");
        String name = reader.nextLine();
        System.out.println("Ingrese el pais del arbitro");
        String country = reader.nextLine();
        System.out.println("Que tipo de arbitro es: 1. Central o 2. Asistente");
        int type = reader.nextInt();
        reader.nextLine();

        if (controller.registerReferees(id, name, country, type)) {
            System.out.println("Arbitro registrado correctamente");
        } else {
            System.out.println("No se pudo registrar el arbitro");
        }

    }

    /**
     * Description: Registers the score of a match, including goals, assists, and
     * cards.
     * 
     * pre: The controller object must be initialized.
     * pos: The user must provide valid
     * group name, team names, player IDs, and card types when prompted. The match
     * between the specified teams must exist and be pending (not already played).
     * If all inputs are valid, the score, goals, assists, and cards are
     * registered in the controller for the specified match. The match is marked as
     * played. If any input is invalid (e.g., incorrect team name, non-existent
     * player ID, invalid card type), the corresponding data is not registered, and
     * appropriate error messages are printed. The console displays messages
     * confirming successful registration or indicating specific input errors.
     */

    public void registerScore() {
        String idReferee = null;
        String idScorer;
        String idAssist;
        String id;
        System.out.println("Seleccionaste Registrar estadisticas de un partido");
        System.out.println("Ingrese el grupo al que pertenece el partido");
        String groupName = reader.nextLine();

        if (controller.searchGroup(groupName) != null) {
            System.out.println(controller.showPendingMatches(controller.searchGroup(groupName)));
            System.out.println("Ingrese el nombre del equipo local");
            String team1 = reader.nextLine();
            System.out.println("Ingrese el nombre del equipo visitante");
            String team2 = reader.nextLine();

            if (team1 != null && team2 != null) {
                if (controller.searchMatch(groupName, team1, team2) != null) {

                    if (controller.searchTeamInGroup(groupName, team1) != null
                            && controller.searchTeamInGroup(groupName, team2) != null) {
                        System.out.println("Ingrese el numero de goles de " + team1 + ":");
                        int goalsTeam1 = reader.nextInt();
                        reader.nextLine();

                        for (int i = 1; i <= goalsTeam1; i++) {
                            System.out.println(controller.showPlayerList(groupName, team1));
                            do {
                                System.out.println("Ingrese el Id del jugador que anoto el gol No " + i + ":");
                                idScorer = reader.nextLine();
                            } while (controller.searchPlayer(idScorer, team1, groupName) == null);
                            if (controller.searchPlayer(idScorer, team1, groupName) != null) {
                                controller.addGoalsToPlayer(team1, groupName, idScorer);
                                System.out.println(
                                        "El jugador es: \n" + controller.showPlayerInfo(idScorer, team1, groupName));

                            } else {
                                System.out.println("Jugador no encontrado");

                            }
                            do {
                                System.out.println("Ingrese el Id del jugador que asistio el gol No " + i + ":");
                                idAssist = reader.nextLine();
                            } while (controller.searchPlayer(idAssist, team1, groupName) == null);
                            if (controller.searchPlayer(idAssist, team1, groupName) != null) {
                                controller.addAssistsToPlayer(team1, groupName, idAssist);
                                System.out.println(
                                        "El jugador es: \n" + controller.showPlayerInfo(idAssist, team1, groupName));

                            } else {
                                System.out.println("Jugador no encontrado");

                            }

                        }
                        System.out.println("Ingrese el numero de goles de " + team2 + ":");
                        int goalsTeam2 = reader.nextInt();
                        reader.nextLine();
                        System.out.println(controller.showPlayerList(groupName, team2));

                        for (int i = 1; i <= goalsTeam2; i++) {
                            do {
                                System.out.println("Ingrese el Id del jugador que anoto el gol No " + i + ":");
                                idScorer = reader.nextLine();
                            } while (controller.searchPlayer(idScorer, team2, groupName) == null);
                            if (controller.searchPlayer(idScorer, team2, groupName) != null) {
                                controller.addGoalsToPlayer(team2, groupName, idScorer);
                                System.out.println(
                                        "El jugador es: \n" + controller.showPlayerInfo(idScorer, team2, groupName));

                            } else {
                                System.out.println("Jugador no encontrado");

                            }
                            do {
                                System.out.println("Ingrese el Id del jugador que asistio el gol No " + i + ":");
                                idAssist = reader.nextLine();
                            } while (controller.searchPlayer(idAssist, team2, groupName) == null);
                            if (controller.searchPlayer(idAssist, team2, groupName) != null) {
                                controller.addAssistsToPlayer(team2, groupName, idAssist);
                                System.out.println(
                                        "El jugador es: \n" + controller.showPlayerInfo(idAssist, team2, groupName));
                            } else {
                                System.out.println("Jugador no encontrado");

                            }

                        }

                        controller.setGoals(groupName, team1, team2, goalsTeam1, goalsTeam2);
                        System.out.println("Marcador registrado correctamente");

                        System.out.println("Se registraron tarjetas? 1. Si 2. No");
                        int opc = reader.nextInt();

                        switch (opc) {
                            case 1:
                                System.out.println("Cuantas tarjetas se registraron?");
                                int numCards = reader.nextInt();
                                reader.nextLine();

                                for (int i = 1; i <= numCards; i++) {
                                    String team = "";
                                    do {
                                        System.out.println("De que equipo es el jugador que recibio la tarjeta?");
                                        team = reader.nextLine();
                                    } while (controller.searchTeamInGroup(groupName, team) == null);
                                    if (controller.searchTeamInGroup(groupName, team) != null) {
                                        do {
                                            System.out
                                                    .println("Ingrese el Id del jugador que recibio la tarjeta No " + i
                                                            + ":");
                                            id = reader.nextLine();
                                        } while (controller.searchPlayer(id, team, groupName) == null);
                                        if (controller.searchPlayer(id, team, groupName) != null) {
                                            System.out.println("Que tipo de tarjeta recibio? 1. Amarilla 2. Roja");
                                            int type = reader.nextInt();
                                            reader.nextLine();

                                            switch (type) {
                                                case 1:
                                                    controller.addYelllowCardToPlayer(team, groupName, id);
                                                    System.out.println("El jugador es: \n"
                                                            + controller.showPlayerInfo(id, team, groupName));
                                                    idReferee = controller.getRefereeIdFromMatch(groupName, team1,
                                                            team2);
                                                    if (idReferee != null) {
                                                        controller.addCardToReferee(groupName, team1, team2, idReferee);
                                                    } else {
                                                        System.out.println("Arbitro no encontrado");
                                                    }
                                                    break;

                                                case 2:
                                                    controller.addRedCardToPlayer(team, groupName, id);
                                                    System.out.println("El jugador es: \n"
                                                            + controller.showPlayerInfo(id, team, groupName));
                                                    idReferee = controller.getRefereeIdFromMatch(groupName, team1,
                                                            team2);
                                                    if (idReferee != null) {
                                                        controller.addCardToReferee(groupName, team1, team2, idReferee);
                                                    } else {
                                                        System.out.println("Arbitro no encontrado");
                                                    }
                                                    break;

                                                default:
                                                    System.out.println("Opcion no valida");
                                                    break;
                                            }

                                        } else {
                                            System.out.println("Jugador no encontrado");
                                        }

                                    }
                                }
                                break;
                            case 2:
                                System.out.println("No se registraron tarjetas");
                                break;

                            default:
                                System.out.println("Opcion no valida");
                                break;

                        }

                        System.out.println("Marcador registrado correctamente");

                        System.out.println(controller.setGoals(groupName, team1, team2, goalsTeam1, goalsTeam2));
                        controller.addMatchPlayed(team1, team2, groupName, idReferee);
                    }
                } else {
                    System.out.println("Partido no encontrado");
                }

            } else {
                System.out.println("Grupo no encontrado");
            }
        } else {
            System.out.println("Equipo no encontrado");
        }

    }

    /**
     * Description: Displays the leaderboard for a specified group.
     * 
     * pre: The controller object must be initialized.
     * pos: The `groupName` must be a
     * valid group name (e.g., "A" or "B"). Matches within the group should have
     * been played and scores registered to generate meaningful standings.
     * The leaderboard for the specified group is printed to the console. The
     * leaderboard includes team rankings based on points, goal difference, and
     * goals scored. If the group name is invalid, an appropriate error message is
     * displayed. No changes are made to any objects.
     */
    public void showLaderBoard() {
        System.out.println("Ingrese el nombre del grupo (A o B):");
        String groupName = reader.nextLine();

        String leaderboard = controller.generateLeaderboard(groupName);
        System.out.println(leaderboard);
    }

    /**
     * Description: Calculates and displays the top goal scorer(s) of the
     * tournament.
     * 
     * pre: The controller object must be initialized. At least some matches must
     * have been played and scores registered for goal data to exist.
     * pos: The name(s) of the player(s) with the highest number of goals in the
     * tournament, along with their goal count, are printed to the console. In case
     * of a tie, multiple players are displayed. If no goals have been scored, an
     * appropriate message is printed. No changes are made to any objects.
     */
    public void calcTopGoalscorer() {
        System.out.println(controller.calcTopGoalScorer());
    }

    /**
     * Description: Calculates and displays the Fair Play ranking of teams in the
     * tournament.
     * 
     * pre: The controller object must be initialized. Matches must have been
     * played, and cards must have been registered for the Fair Play calculations to
     * be meaningful.
     * pos: The Fair Play ranking is printed to the console. Teams are ranked from
     * fewest to most cards received (yellow cards count as 1 point, red cards as 2
     * points). Tie-breaking criteria, if any (e.g., goal difference, goals scored),
     * should be explained in the output. No changes are made to any objects.
     */
    public void calcFairPlay() {
        System.out.println(controller.calcFairPlay());
    }

    /**
     * Description: Calculates and displays the efficiency of a specified team.
     *
     * pre: The controller object must be initialized. Matches involving the
     * team must have been played for efficiency calculations to be meaningful.
     * pos: The team's efficiency is calculated and printed to the console.
     * If the group or team is not found, an appropriate message is
     * displayed. No changes are made to any objects.
     */
    public void calcTeamEfficiency() {
        System.out.println("Ingrese el grupo del equipo");
        String groupName = reader.nextLine();
        if (controller.searchGroup(groupName) != null) {

            System.out.println("Ingrese el nombre del equipo");
            String teamName = reader.nextLine();

            if (controller.searchTeam(teamName) != null) {
                controller.calcTeamEfficiency(groupName, teamName);
                System.out
                        .println("La eficiencia del equipo es: " + controller.calcTeamEfficiency(groupName, teamName));
            } else {

                System.out.println("Equipo no encontrado");
            }
        } else {
            System.out.println("Grupo no encontrado");
        }

    }

    /**
     * Description: Calculates and displays the efficiency of a specified player.
     * 
     * pre: The controller object must be initialized. The player must have
     * participated
     * in at least one match for the calculation to be meaningful.
     * pos: The player's efficiency is calculated and printed to the console.
     * If the group, team, or player is not found, an
     * appropriate message is displayed. No changes are made to any objects.
     */
    public void calcPlayerEfficiency() {
        System.out.println("Ingrese el grupo");
        String groupName = reader.nextLine();
        if (controller.searchGroup(groupName) != null) {
            System.out.println(controller.showGroupList());
            System.out.println("Ingrese el nombre del equipo");
            String teamName = reader.nextLine();

            if (controller.searchTeamInGroup(groupName, teamName) != null) {
                System.out.println("Ingrese el id del jugador");
                String playerId = reader.nextLine();

                if (controller.searchPlayer(playerId, teamName, groupName) != null) {
                    System.out.println("La eficiencia del jugador es: "
                            + controller.calcPlayerEfficiency(playerId, teamName, groupName));
                } else {
                    System.out.println("Jugador no encontrado");
                }
            } else {
                System.out.println("Equipo no encontrado");

            }

        }

    }

    /**
     * Description: Calculates and displays the card index of a specified central
     * referee.
     * 
     * pre: The controller object must be initialized. 
     * pos: The `refereeId` must
     * correspond to a registered central referee. The referee must have overseen at
     * least one match where cards were given for the calculation to be meaningful.
     * The referee's card index is calculated and printed to the console. The
     * card index represents the average number of cards (yellow and red combined,
     * possibly weighted) given per match overseen by the referee. If the referee is
     * not found or has not given any cards, an appropriate message is displayed. No
     * changes are made to any objects.
     */
    public void calcRefereeCardIndex() {
        System.out.println("Ingrese el id del arbitro central");
        String refereeId = reader.nextLine();

        if (controller.searchCentralReferee(refereeId) != null) {
            System.out.println("El indice de tarjetas del arbitro es: " + controller.calcRefereeCardIndex(refereeId));
        } else {
            System.out.println("Arbitro no encontrado");
        }

    }

}
