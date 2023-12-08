public abstract class RPGCharacters implements RPGCharacter, Accessories {
    protected String name;
    protected double baseHP;
    protected double baseMana;
    protected double baseRunSpeed;
    protected int level;
    protected double currentHP;
    protected double currentMana;

    RPGCharacters (String[] Hero){
        this.name = Hero[0];
        this.baseHP = Double.parseDouble(Hero[1]);
        this.baseMana = Double.parseDouble(Hero[2]);
        this.baseRunSpeed = Double.parseDouble(Hero[3]);
        this.level = 1;
        this.currentHP = baseHP;
        this.currentMana = baseMana;
    }

    public void status() {
        System.out.println("///////////// " + name + " /////////////////");
        System.out.println("Your Level is: " + level);
    }

    @Override
    public int attack(RPGCharacter enemy) {
        return 0;
    }

    public void decreaseHP(double amount) {
        currentHP -= amount;
    }

    @Override
    public void def(){
        System.out.println(name + " ทำการป้องกัน ทำให้ HP " + name + " เหลือ: " + getCurrentHP());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCurrentHP() {
        return currentHP;
    }

    @Override
    public double getCurrentMana() {
        return currentMana;
    }

    @Override
    public void friendBuff() {
        currentHP += 30;
    }

    @Override
    public int resurrect(String nameFriend) {
        return 0;
    }

    public void decreaseMana(double amount) {
        currentMana -= amount;
        if (currentMana < 0) {
            currentMana = 0;  // Ensure Mana doesn't go below 0
        }
    }

}
