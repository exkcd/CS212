// This file is mainly used to test Java constructors as well as getters, setters and the toString method.

package experiments;

public class foodstuff {
    public static void main(String[] args) {
        StringCheese firefox = new StringCheese(1, "Mozzarella");
        Apples macbeth = new Apples();
        macbeth.setNumberOfApples(20);
        macbeth.setTypeOfApple("Macintosh");
        System.out.println(firefox);
        System.out.println(macbeth.getNumberOfApples());
        System.out.println(macbeth.getTypeOfApple());
    }
}

class StringCheese {    
    private final int numberOfCheeses;
    private final String typeOfCheese;

    public StringCheese(int numberOfCheeses, String typeOfCheese) {
        this.numberOfCheeses = numberOfCheeses;
        this.typeOfCheese = typeOfCheese;
    }

    @Override
    public String toString() {
        return "StringCheese{" +
                "numberOfCheeses=" + numberOfCheeses +
                ", typeOfCheese='" + typeOfCheese + '\'' +
                '}';
    }
}

class Apples {
    private String typeOfApple;
    private int numberOfApples;

    public String getTypeOfApple() {
        return typeOfApple;
    }

    public void setTypeOfApple(String typeOfApple) {
        this.typeOfApple = typeOfApple;
    }

    public int getNumberOfApples() {
        return numberOfApples;
    }

    public void setNumberOfApples(int numberOfApples) {
        this.numberOfApples = numberOfApples;
    }
}
