package base;

import java.util.ArrayList;

public class Board {
    private String vacant;
    private String coordinates;
    private String header;
    private int sidebar;
    private ArrayList<ArrayList<String>> grid = new ArrayList<>();
    private ArrayList<String>  row1 = new ArrayList<>();
    private ArrayList<String>  row2 = new ArrayList<>();
    private ArrayList<String>  row3 = new ArrayList<>();
    private ArrayList<String>  row4 = new ArrayList<>();
    private ArrayList<String>  row5 = new ArrayList<>();
    private ArrayList<String>  row6 = new ArrayList<>();
    private ArrayList<String>  row7 = new ArrayList<>();
    private ArrayList<String>  row8 = new ArrayList<>();
    private ArrayList<String>  row9 = new ArrayList<>();

    public Board(){
        setVacant("~");
        setHeader("  1 2 3 4 5 6 7 8 9");
        setSidebar(1);
    }
    public String getVacant(){
        return vacant;
    }

    public void setCoordinates(String coordinates){
        this.coordinates=coordinates;
    }

    public void setVacant(String vacant){
        this.vacant=vacant;
    }

    public void setHeader(String header){
        this.header=header;
    }

    public void setSidebar(int sidebar){
        this.sidebar =sidebar;
    }


    public ArrayList<String>getRow1(){
        return row1;
    }
    public ArrayList<String>getRow2(){
        return row2;
    }
    public ArrayList<String>getRow3(){
        return row3;
    }
    public ArrayList<String>getRow4(){
        return row4;
    }
    public ArrayList<String>getRow5(){
        return row5;
    }
    public ArrayList<String>getRow6(){
        return row6;
    }
    public ArrayList<String>getRow7(){
        return row7;
    }
    public ArrayList<String>getRow8(){
        return row8;
    }
    public ArrayList<String>getRow9(){
        return row9;
    }
    public ArrayList<ArrayList<String>>getGrid(){
        return grid;
    }


    public void DisplayBoard(){

        boolean elementsLeft = true;
        int column = 0;

        System.out.println(header);
        while (elementsLeft) {
            if(sidebar<=9) {
                System.out.print(sidebar++);
                System.out.print(" ");
            }
            for (ArrayList<String> subList : grid) {

                if (subList.size() > column) {

                    System.out.print(subList.get(column) + " ");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();

            elementsLeft = isElementsLeft(grid, column);
            column++;
        }
            sidebar=1;


    }

    public boolean isElementsLeft(ArrayList<ArrayList<String>> someArray, int column) {
        for (ArrayList<String> subList : someArray) {
            if (subList.size() > column) {
                return true;
            }
        }
        return false;
    }

    public  void LoadBoard(){
        for( int i = 0; i<9; i++){
            getRow1().add(getVacant());
            getRow2().add(getVacant());
            getRow3().add(getVacant());
            getRow4().add(getVacant());
            getRow5().add(getVacant());
            getRow6().add(getVacant());
            getRow7().add(getVacant());
            getRow8().add(getVacant());
            getRow9().add(getVacant());


        }

        getGrid().add(getRow1());
        getGrid().add(getRow2());
        getGrid().add(getRow3());
        getGrid().add(getRow4());
        getGrid().add(getRow5());
        getGrid().add(getRow6());
        getGrid().add(getRow7());
        getGrid().add(getRow8());
        getGrid().add(getRow9());

    }

    public void AddPointsToBoard(Ship ship,Board playersBoard) {
        System.out.println("add points started");
        ArrayList<Integer> pointstoplot = new ArrayList<>();


        String[] splitPoints = ship.getCoordinates().split("");
        for (int i = 0; i < ship.getCoordinates().length(); i++) {

            if (!splitPoints[i].equals("(") && !splitPoints[i].equals(")") && !splitPoints[i].equals(",")) {
                pointstoplot.add(Integer.valueOf(splitPoints[i]));
            }

        }

        if (ship.getDirection().equalsIgnoreCase("v")) {

            int point0 = pointstoplot.get(0)-1;
            int point1=pointstoplot.get(1)-1;
            for (int i = 1; i <= ship.getLength(); i++) {
                System.out.println("entering vertical loop");
                getGrid().get(point0).set(point1, ship.getShipInitial());
                point1++;
            }
            playersBoard.DisplayBoard();
        } else if (ship.getDirection().equalsIgnoreCase("h")) {
            System.out.println("the H if");
            int point1 = pointstoplot.get(1)-1;
            int point0=pointstoplot.get(0)-1;
            for (int i = 1; i <= ship.getLength(); i++) {
                System.out.println("entering horizontal loop");
                playersBoard.getGrid().get(point0).set(point1, ship.getShipInitial());
                    point0++;
            }
            playersBoard.DisplayBoard();
        }
        else{
            System.out.println("you entered the wrong direction");
        }

    }

    public boolean PointCheck(Ship ship,Board playersBoard, String coord, String direction){
        System.out.println("point check started");
        ArrayList<Integer> pointstoplot = new ArrayList<>();
        boolean check = true;

        String[] splitPoints = coord.split("");
        for (int i = 0; i < splitPoints.length; i++) {

            if (!splitPoints[i].equals("(") && !splitPoints[i].equals(")") && !splitPoints[i].equals(",")) {
                pointstoplot.add(Integer.valueOf(splitPoints[i]));
            }

        }
        System.out.println(direction);
        if (direction.equalsIgnoreCase("v")) {

            int point0 = pointstoplot.get(0)-1;
            int point1=pointstoplot.get(1)-1;
            for (int i = 1; i <= ship.getLength(); i++) {
                System.out.println("entering vertical loop");
               if( getGrid().get(point0).get(point1).equals("~")){
                   System.out.println(point0+","+point1);
                   System.out.println(playersBoard.getGrid().get(point0).get(point1));
                   check = true;
               }
               else{
                   check = false;
                   break;
               }
                point1++;
            }
        } else if (direction.equalsIgnoreCase("h")) {
            System.out.println("the H if in the checkpoints");
            int point1 = pointstoplot.get(1)-1;
            int point0=pointstoplot.get(0)-1;
            for (int i = 1; i <= ship.getLength(); i++) {
                System.out.println("Entering horizontal loop");
                System.out.println(i + ship.getLength());

                if(playersBoard.getGrid().get(point0).get(point1).equals("~")){
                    System.out.println(i+","+point1);
                    System.out.println(playersBoard.getGrid().get(i).get(point1));
                    check = true;
                }
                else
                {
                    System.out.println("spot taken");
                    check = false;
                    break;
                }
                point0++;
            }

        }else{
            System.out.println("there was a problem");
        }
        System.out.println(check);
      return check;

    }


}
