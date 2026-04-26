public class Hyena extends Animal {
    private static int numOfHyenas = 0;
    public Hyena() {
        super();
        numOfHyenas++;
        setSpecies("hyena");
    }
    public void genUniqueID() {
        setAnimalID("Hy" + String.format("%02d", numOfHyenas));
    }
}