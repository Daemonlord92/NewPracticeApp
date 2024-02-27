package myclass;

import lombok.Data;

@Data
public class PlayerClass extends MyClass{
    private String playerClass;
    private int strength;
    private int consitution;
    private int intelligence;
    private int agility;
    private int wisdom;

    public PlayerClass() {
        this.setName("Player Class");
        this.setNum(5);
        this.setFloatNum(8.5f);
        playerClass = "Class";
        strength = rollDice(18);
        consitution = rollDice(18);
        intelligence = rollDice(18);
        agility = rollDice(18);
        wisdom = rollDice(18);
    }

    public  PlayerClass(String _name,
                        String _playerClass,
                        int _num,
                        float _floatNum,
                        int _strength,
                        int _consitution,
                        int _intelligence,
                        int _agility,
                        int _wisdom) {
        setName(_name);
        setNum(_num);
        setFloatNum(_floatNum);
        playerClass = _playerClass;
        strength = _strength;
        consitution = _consitution;
        intelligence = _intelligence;
        agility = _agility;
        wisdom = _wisdom;
    }

    public PlayerClass(MyClass cl, String _playerClass) {
        setName(cl.getName());
        setNum(cl.getNum());
        setFloatNum(cl.getFloatNum());
        playerClass = _playerClass;
        strength = rollDice(18);
        consitution = rollDice(18);
        intelligence = rollDice(18);
        agility = rollDice(18);
        wisdom = rollDice(18);
    }

    public PlayerClass(PlayerClass pc) {
        setName(pc.getName());
        setNum(pc.getNum());
        setFloatNum(pc.getFloatNum());
        playerClass = pc.playerClass;
        strength = pc.strength;
        consitution = pc.consitution;
        intelligence = pc.intelligence;
        agility = pc.agility;
        wisdom = pc.wisdom;
    }
    public void setPlayerClass(String playerClass) {
        char[] classNameArray = playerClass.toCharArray();
        for (char c : classNameArray) {
            if(Character.isDigit(c)) {
                throw new IllegalArgumentException("Player class cannot contain numbers");
            }
        }

        this.playerClass = playerClass;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \nClass: %s \nNum: %d \nFloat Num: %.2f \nStrength: %d \nConsitution: %d \nIntelligence: %d \nAgility: %d \nWisdom: %d",
                getName(),
                getPlayerClass(),
                getNum(),
                getFloatNum(),
                getStrength(),
                getConsitution(),
                getIntelligence(),
                getAgility(),
                getWisdom());
    }
}
