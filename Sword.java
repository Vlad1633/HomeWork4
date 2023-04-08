package HomeWork1;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Sword {

    public <T extends Metal> void createSword(T sword) {
        System.out.println("Sword is create!");
    }

    public Boolean checkEnduranceSword(int endurance) {
        if (endurance > 49) {
            System.out.println("The sword passed the test!");
            return true;
        }
        else {
            System.out.println("The sword failed the test!");
            return false;
        }
    }
}