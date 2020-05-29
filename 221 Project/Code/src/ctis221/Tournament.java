package ctis221;

import javafx.css.Match;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Tournament implements TournamentStructure {


    ArrayList<Matches> matchList = new ArrayList<Matches>();
    ArrayList<Team> teamList  = new ArrayList<Team>();



    @Override
    public ArrayList<Team> addTeams() {
        Scanner scan = new Scanner(System.in);
        int numOfPlayers = 0;


        do{
            System.out.println("Enter Number of Players per team (at least 4)");
            numOfPlayers = scan.nextInt();
        } while (numOfPlayers> 3);


        System.out.println("Enter number of teams:");
        int numTeams = scan.nextInt();
        scan.skip("\n");


        for (int i = 0; i < numTeams; i++) {
            System.out.println("Enter team#"+(i+1));
            ArrayList<SquadPlayer> squad = new ArrayList<SquadPlayer>();

            System.out.println("Enter name:");
            String s = scan.nextLine();

            Team t1 = new Team(s);
            t1.addPlayer(numOfPlayers);

            teamList.add(t1);
        }
        return null;
    }

    public ArrayList<Matches> addMatches(ArrayList<Team> teamList) {

        int pass = 1;

        for (int i = 0; i < (((teamList.size() - 1) * teamList.size())/2); i++) {
            for (int j = i+1; j < (((teamList.size() - 1) * teamList.size())/2); j++) {
                Matches mHome = new Matches(teamList.get(i),teamList.get(j));
                Matches mAway = new Matches(teamList.get(j),teamList.get(i));

                this.matchList.add(mHome);
                this.matchList.add(mAway);

            }


        }
        return null;
    }

    @Override
    public void playMatches(ArrayList<Matches> matchList) {

        for(Matches i:matchList){
            i.playMatch();
        }

    }

    @Override
    public String tournamentStats() {

        int maxGoals = 0;
        SquadPlayer mostGoals = null;

        int minGoals = Integer.MAX_VALUE;
        SquadPlayer minGoalie = null;

        int maxPoints = 0;
        int teamPoints = 0;
        Team won = new Team("name");

        for (Team i: teamList){
            teamPoints = ((i.getWon()*3) + (i.getWon()));
            if (teamPoints > maxPoints){
                won = i;
                maxPoints = teamPoints;
            }
            else if ((teamPoints == maxPoints) && (i.getGoalsFor() > won.getGoalsFor())){
                won = i;
                maxPoints = teamPoints;
            }
            else if ((teamPoints == maxPoints) && (i.getGoalsFor() == won.getGoalsFor()) && (i.getGoalsAgainst() < won.getGoalsAgainst())){
                won = i;
                maxPoints = teamPoints;
            }

            for (SquadPlayer p: i.teamSquad){
                if (p.getGoals() > maxGoals){
                    mostGoals = p;
                    maxGoals = p.getGoals();
                }
            }
            for (Team goalie: teamList){
                if (goalie.getGoalsAgainst() < minGoals){
                    minGoals = goalie.getGoalsAgainst();
                    for (SquadPlayer p: goalie.teamSquad){
                        if (p instanceof GoalKeeper){
                            minGoalie = p;
                        }
                    }
                }
            }

        }

        return  "Tournament Winner: " + won + "\nTop scorer: " + mostGoals + "\nBest GoalKeeper:" + minGoalie;






    }
}
