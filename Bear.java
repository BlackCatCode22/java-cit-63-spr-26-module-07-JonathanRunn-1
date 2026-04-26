public class Bear extends Animal {
    private static int numOfBears = 0;
    public Bear() {
        super();
        numOfBears++;
        this.setSpecies("bear"); //
    }
    public void genUniqueID() {
        setAnimalID("Be" + String.format("%02d", numOfBears));
    }
}