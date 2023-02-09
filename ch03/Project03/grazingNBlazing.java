/* This exercise showcases abstraction, interfaces, and inheritance through categorizing farm animals by their
 * respective types of eating habits.
 *
 * R Stone
*/

interface RuminantTester {
    void testIfRuminant();

    void testHasMultipleStomachs();

    void grazes();

    void chewsCud();
}

abstract class Mammal {
    public void nursesYoung() {
        String className = this.getClass().getSimpleName();
        System.out.println("This " + className + " nurses their young.");
    }
}

abstract class GrazingAnimal extends Mammal implements RuminantTester {
    @Override
    public void grazes() {
        String className = this.getClass().getSimpleName();
        System.out.println("I am a " + className + ", and I am grazing and blazing.");
    }

    @Override
    public void testIfRuminant() {
        String className = this.getClass().getSimpleName();
        if (this instanceof Ruminant) {
            System.out.println("I am a " + className + ". I am ruminant.");
        } else {
            System.out.println("I am a " + className + ". I am NOT ruminant.");
        }
    }

    @Override
    public void testHasMultipleStomachs() {
        String className = this.getClass().getSimpleName();
        if (this instanceof Ruminant) {
            System.out.println("I, the " + className + ", have multiple stomachs. I am better than you.");
        }
    }

    @Override
    public void chewsCud() {
        String className = this.getClass().getSimpleName();
        System.out.println("Since I am a " + className + ", I chew some cud. Yum yum.");
    }
}

abstract class Ruminant extends GrazingAnimal {
}

class Cow extends Ruminant {
}

class Goat extends Ruminant {
}

class Horse extends GrazingAnimal {
}

public class grazingNBlazing {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.nursesYoung();
        cow.grazes();
        cow.chewsCud();
        cow.testIfRuminant();
        cow.testHasMultipleStomachs();
        System.out.println();

        Goat goat = new Goat();
        goat.nursesYoung();
        goat.grazes();
        goat.chewsCud();
        goat.testIfRuminant();
        goat.testHasMultipleStomachs();
        System.out.println();

        Horse horse = new Horse();
        horse.nursesYoung();
        horse.grazes();
        horse.testIfRuminant();
        horse.testHasMultipleStomachs();

    }
}