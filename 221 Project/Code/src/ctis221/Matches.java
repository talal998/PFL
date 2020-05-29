package ctis221;

import java.util.Scanner;

public class Matches {
    Team homeTeam;
    Team awayTeam;

    public Matches(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    public void playMatch(int hScore, int aScore) {

        homeTeam.setGoalsFor(hScore);

        awayTeam.setGoalsFor(aScore);


        homeTeam.setGoalsAgainst(aScore);
        awayTeam.setGoalsAgainst(hScore);


        if (hScore > aScore) {
            homeTeam.setWon();
            awayTeam.setLost();
        } else if (aScore > hScore) {
            awayTeam.setWon();
            homeTeam.setLost();
        } else {
            homeTeam.setDrawn();
            awayTeam.setDrawn();
        }
        addGoal();
    }

    public void addGoal(int kit) {
        int kit = 0;
        int goals = 0;
        while (hScore>0) {
            System.out.println("Enter Home scorers kit number:");
            kit = scan.nextInt();
            do {
                System.out.println("Enter number of Goals");
                goals = scan.nextInt();
            } while (goals <= hScore);
            homeTeam.searchPlayer(kit).setGoals(goals);
            hScore = hScore - goals;
        }

        while (aScore>0) {
            System.out.println("Enter Away scorers kit number:");
            kit = scan.nextInt();
            do {
                System.out.println("Enter number of Goals");
                goals = scan.nextInt();
            } while (goals <= hScore);
            awayTeam.searchPlayer(kit).setGoals(goals);
            aScore = aScore - goals;
        }








    }
}
