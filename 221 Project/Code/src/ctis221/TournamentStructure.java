package ctis221;

import java.util.ArrayList;

public interface TournamentStructure {
    ArrayList<Team> addTeams();
    ArrayList<Matches> addMatches(ArrayList<Team> teamList);
    void playMatches(ArrayList<Matches> matchList);
    String tournamentStats();

}
