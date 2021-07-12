package base;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
public static Scanner input = new Scanner(System.in);

public static Board  theBoard;
public static Board  player2Board;
    public static Board  play2Attac;
    public static Board  play1Attac;
public static boolean isGameOver=false;
public static void main(String[] args) {

Board board = new Board();
theBoard=board;
board.LoadBoard();
board.DisplayBoard();

Board player = new Board();
player.LoadBoard();
player2Board=player;

Board player1Attack = new Board();
player1Attack.LoadBoard();
play1Attac=player1Attack;
Board player2Attack = new Board();
player2Attack.LoadBoard();
play2Attac = player2Attack;
Start();


}

public static void Start() {

    System.out.println("Battleship Multiplayer");
    System.out.println("Enter Player one Name");
    String player1name = input.nextLine();
    Player player1 = new Player(player1name);
    System.out.println("Enter Player two Name");
    String player2name = input.nextLine();
    Player player2 = new Player(player2name);
    String attackCoordinates="";
    System.out.println(player1.getName() + ", please enter the coordinates for your ships");
    AddShipCoordinates(player1, theBoard);
    player2Board.DisplayBoard();
    System.out.println(player2.getName() + ", please enter the coordinates for your ships");
    AddShipCoordinates(player2, player2Board);
    while (isGameOver==false) {
        if (player2.GameOver(player1.getName())==false){
            System.out.println(player1name + " Enter attack coordinates");
         attackCoordinates = input.nextLine();
        attack(attackCoordinates, player1, player2, player2Board, play1Attac);
    }else{
            isGameOver =true;
            break;
        }
        if (player1.GameOver(player2.getName())==false) {
            player2Board.DisplayBoard();
            System.out.println(player1name + " Enter attack coordinates");
            attackCoordinates = input.nextLine();
            attack(attackCoordinates, player2, player1, theBoard, play2Attac);
            theBoard.DisplayBoard();
        }
        else{
            isGameOver=true;
            break;
        }
    }
}
    public static void AddShipCoordinates(Player player,Board theBoard){
   String coord="";
   String placement="";
   boolean checkCoord=false;
    for(var ship:player.getPlayerShips() ){
        while( checkCoord==false) {
            System.out.println("Enter the coordinates for the " + ship.getName());
             coord = input.nextLine();
            System.out.println("Place horizontally or vertically (h or v)?");
             placement = input.nextLine();
             checkCoord=theBoard.PointCheck(ship,theBoard,coord,placement);
            if (checkCoord == false) {
                System.out.println(ship.getName() + "is already located there ");
            }
        }
        checkCoord=false;

        ship.setCoordinates(coord);
        ship.setDirection(placement);
        theBoard.AddPointsToBoard(ship,theBoard);
    }

    theBoard.DisplayBoard();
    }

    public static void attack(String coord ,Player attackinPlayer,Player defendingPlayer,Board defPlayersBoard,Board attackBoard) {
        ArrayList<Integer> attackPoints = new ArrayList<>();


        String[] splitPoints = coord.split("");
        for (int i = 0; i < coord.length(); i++) {

            if (!splitPoints[i].equals("(") && !splitPoints[i].equals(")") && !splitPoints[i].equals(",")) {
                attackPoints.add(Integer.valueOf(splitPoints[i]));
            }

        }
        int point0 = attackPoints.get(0)-1;
        int point1 = attackPoints.get(1)-1;

        String pointOfAttack = defPlayersBoard.getGrid().get(point0).get(point1);

        switch (pointOfAttack) {
            case "C":
                System.out.println(defendingPlayer.getName()+" Your Carrier was hit!");
                defPlayersBoard.getGrid().get(point0).set(point1, "H");
                attackBoard.getGrid().get(point0).set(point1, "H");
                defendingPlayer.AddHitsTosShip("Carrier");

                break;
            case "D":
                System.out.println(defendingPlayer.getName()+" Your Destroyer was hit!");
                defPlayersBoard.getGrid().get(point0).set(point1, "H");
                attackBoard.getGrid().get(point0).set(point1, "H");
                defendingPlayer.AddHitsTosShip("Destroyer");
                break;
            case "M":
                System.out.println(defendingPlayer.getName()+" Your Cruiser was hit!");
                defPlayersBoard.getGrid().get(point0).set(point1, "H");
                attackBoard.getGrid().get(point0).set(point1, "H");
                defendingPlayer.AddHitsTosShip("Cruiser");
                break;
            case "S":
                System.out.println(defendingPlayer.getName()+" Your Sub was hit");
                defPlayersBoard.getGrid().get(point0).set(point1, "H");
                attackBoard.getGrid().get(point0).set(point1, "H");
                defendingPlayer.AddHitsTosShip("Submarine");
                break;
            case "B":
                System.out.println(defendingPlayer.getName()+" Your Battleship was hit");
                defPlayersBoard.getGrid().get(point0).set(point1, "H");
                attackBoard.getGrid().get(point0).set(point1, "H");
                defendingPlayer.AddHitsTosShip("Battleship");
                break;
            default:
                System.out.println(attackinPlayer +" You missed!");
                attackBoard.getGrid().get(point0).set(point1, "X");
                break;
        }

        attackBoard.DisplayBoard();
    }
}
