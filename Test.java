package HomeWork1;

public class Test {

    public static void main(String[] args) {
        Metal iron = new Iron();
        Metal copper = new Copper();
        Metal steel = new Steel();
        Plastic plastic = new Plastic();
        Sword sword = new Sword();
        sword.createSword(steel);
        sword.checkEnduranceSword(steel.getEndurance());
    }
}
