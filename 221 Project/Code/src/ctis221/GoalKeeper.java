package ctis221;

public class GoalKeeper extends SquadPlayer{
    private int goalsAgainst;
    private int gkKitNumber;



    public GoalKeeper(String playerName) {
        super(playerName, 1);
        this.goalsAgainst = 0;
    }



    @Override
    public String displayPlayerProfile() {
        return "GoalKeeper{" +
                ", outfieldKitNumber=" + gkKitNumber +
                ", playerName='" + playerName + '\'' +
                ", playerID=" + playerID +
                "goalsAgainst=" + goalsAgainst +
                '}';
    }



    @Override
    public int checkKitNumber() {
        return 1;
    }
}
