package ctis221;

public class OutfieldPlayer extends SquadPlayer{

    private int outfieldKitNumber;


    public OutfieldPlayer(String playerName, int kitNumber) {
        super(playerName, kitNumber);
        this.outfieldKitNumber = kitNumber;
    }




    @Override
    public String displayPlayerProfile() {
        return "OutfieldPlayer{" +
                ", outfieldKitNumber=" + outfieldKitNumber +
                ", playerName='" + playerName + '\'' +
                ", playerID=" + playerID +
                '}';
    }


    @Override
    public int checkKitNumber() {
        return this.outfieldKitNumber;
    }


    public int getOutfieldKitNumber() {
        return outfieldKitNumber;
    }
}
