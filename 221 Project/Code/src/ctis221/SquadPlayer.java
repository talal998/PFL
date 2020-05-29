package ctis221;

public abstract class SquadPlayer implements PlayerProfile {

    protected String playerName;
    protected int playerID;
    protected int goals;
    protected int kit;

    static int playerCount;




    public SquadPlayer(String playerName, int kit) {
        this.playerName = playerName;
        this.playerID++;
        this.goals = 0;
        this.kit = kit;
    }

    public int getKit() {
        return kit;
    }

    public void setKit(int kit) {
        this.kit = kit;
    }

    @Override
    public String toString() {
        return "SquadPlayer{" +
                "playerName='" + playerName + '\'' +
                ", playerID=" + playerID +
                ", goals=" + goals +
                ", kit=" + kit +
                '}';
    }

    abstract public int checkKitNumber();

    public String getPlayerName() {
        return playerName;
    }


    public int getPlayerID() {
        return playerID;
    }

    public int getGoals() {
        return this.goals;
    }

    public void setGoals(int goals) {
        this.goals = this.goals + goals;
    }
}
