package base;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String name;

    public Player(String name){
        this.name=name;
        AddShips();
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }

    private ArrayList<Ship> playerShips = new ArrayList<>();



    public ArrayList<Ship> getPlayerShips() {
        return playerShips;
    }

    public void AddShips(){
        Carrier carrier = new Carrier();
        Destroyer destroyer = new Destroyer();
        Cruiser cruiser = new Cruiser();
        Submarine sub = new Submarine();
        BattleShip battleship = new BattleShip();
        playerShips.add(carrier);
        playerShips.add(destroyer);
        playerShips.add(cruiser);
        playerShips.add(sub);
        playerShips.add(battleship);


    }

    public void AddHitsTosShip(String shipname){
        for(var ship:playerShips){
            if(ship.getName().equals(shipname)){
                ship.setHits(ship.getHits()+1);
            }
        }
    }

    public boolean GameOver(String name){
        boolean isOver=false;
        for(var ship:playerShips){
            if(ship.getHits()==ship.getLength()){
                System.out.println("Game over "+name +" Wins!");
                isOver=true;
            }

        }
        return isOver;
    }

}
