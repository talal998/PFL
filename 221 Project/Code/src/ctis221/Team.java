package ctis221;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    private String teamName;
    private int won;
    private int lost;
    private int drawn;
    private int goalsFor;
    private int goalsAgainst;

    public ArrayList<SquadPlayer> teamSquad;

    public Team(String name) {
        this.teamName = name;
        this.won = 0;
        this.lost = 0;
        this.drawn = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }



    Scanner scan = new Scanner(System.in);


    public void addPlayer(int numOfPlayers){


        teamSquad = new ArrayList<SquadPlayer>();

        addGoalie();
        addOutfield(numOfPlayers);

    }
    public void deletePlayer()
    {
        int kit = 0;
        System.out.println("Enter player kit number to delete: ");
        kit = scan.nextInt();
        boolean remove = false;

        for(SquadPlayer i: teamSquad){
            if (i.checkKitNumber() == kit){
                teamSquad.remove(i);
                remove = true;
            }
        }
        if ((remove) && (kit == 1)){
            addGoalie();

        } else if (remove){
            addOutfield(2);
        }
    }
    public SquadPlayer searchPlayer(int kit){
        for(SquadPlayer i: teamSquad){
            if (i.checkKitNumber() == kit){
                return i;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", won=" + won +
                ", lost=" + lost +
                ", drawn=" + drawn +
                ", goalsFor=" + goalsFor +
                ", goalsAgainst=" + goalsAgainst +
                ", teamSquad=" + teamSquad +

                '}';
    }



    public boolean searchKit(int thisKit){
        for(SquadPlayer i: teamSquad){
            if (i.checkKitNumber() == thisKit)
                return false;
        }
        return true;
    }


    public void addGoalie(){
        String goalierName ="";

        System.out.println("Enter Goal Keeper Name:");
        goalierName = scan.nextLine();
        GoalKeeper g = new GoalKeeper(goalierName);
        teamSquad.add(g);
    }
    public void addOutfield(int numOfPlayers){

        String playerName ="";


        for(int n = 0; n< numOfPlayers - 1; n++) {
            int kit = 0;

            System.out.println("Enter Player Name:");
            playerName = scan.nextLine();
            do {
                System.out.println("Enter a unique kit Number:");
                kit = scan.nextInt();

            } while (!searchKit(kit));


            OutfieldPlayer o = new OutfieldPlayer(playerName, kit);
            teamSquad.add(o);

        }

    }




    public String getTeamName() {
        return teamName;
    }

    public int getWon() {
        return won;
    }

    public void setWon() {
        this.won++;
    }

    public int getLost() {
        return lost;
    }

    public void setLost() {
        this.lost++;
    }

    public int getDrawn() {
        return drawn;
    }

    public void setDrawn() {
        this.drawn++;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor =  this.goalsFor+goalsFor;

    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = this.goalsAgainst + goalsAgainst;
        for(SquadPlayer i: teamSquad){
            if (i instanceof GoalKeeper){
            i.setGoals(goalsAgainst);
            }
        }
    }

}
