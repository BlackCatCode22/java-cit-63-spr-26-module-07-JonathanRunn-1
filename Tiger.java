public class Tiger extends Animal {
    private static int numOfTigers = 0;
    public Tiger() {
        super();
        numOfTigers++;
        this.setSpecies("tiger"); //
    }
    public void genUniqueID() {
        setAnimalID("Ti" + String.format("%02d", numOfTigers));
    }
}