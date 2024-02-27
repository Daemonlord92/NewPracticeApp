package myclass;

import lombok.Data;

import java.util.Random;

@Data
public class MyClass {
    private static final Random rand = new Random();
    private int num;
    private float floatNum;
    private String name;

    public MyClass() {
        num = 5;
        floatNum = 3.5f;
        name = "MyClass";
    }

    public MyClass(int _num, float _floatNum, String _name) {
        num = _num;
        floatNum = _floatNum;
        name = _name;
    }

    public MyClass(MyClass cl) {
        name = cl.name;
        num = cl.num;
        floatNum = cl.floatNum;
    }

    public MyClass assign(MyClass copy) {
        this.num = copy.num;
        this.name = copy.name;
        this.floatNum = copy.floatNum;
        return this;
    }

    public void setName(String name) {
        char[] nameArray = name.toCharArray();
        for (char c : nameArray) {
            if(Character.isDigit(c)) {
                throw new IllegalArgumentException("There cannot be numbers in the Name");
            }
        }
        this.name = name;
    }

    public static int rollDice(int diceSize) {
        return rand.nextInt(diceSize);
    }

    @Override
    public String toString() {
        return String.format("Name: %s , Num: %d , FloatNum: %.2f",
                getName(),
                getNum(),
                 getFloatNum());
    }
}
