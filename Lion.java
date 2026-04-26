public class Lion extends Animal {
    private static int numOfLions = 0;
    public Lion() {
        super();
        numOfLions++;
        setSpecies("lion");
    }
    public void genUniqueID() {
        setAnimalID("Li" + String.format("%02d", numOfLions));
    }
}