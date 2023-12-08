public class Main {
//    String[] nameHero = ["nameHero", "baseHP", "baseMana", "baseRunSpeed"];
    static String[] unjiMan = {"UnjiMan", "300", "60", "10"};
    static String[] spermMan = {"SpermMan", "200", "50", "10"};
    static String[] pennisMan = {"PennisMan", "250", "70", "12"};

//    String[] nameSword = {"NameEquip", "Damage", "RunSpeedDecrease"};
    static String[] sword = {"sword", "25", "-1"};
    static String[] dagger = {"dagger", "20", "-0.6"};
    static String[] knife = {"knife", "15", "-0.3"};

//    String[] nameShield = {"NameEquip", "Def", "RunSpeedDecrease"};
    static String[] shield = {"shield", "10", "-2"};
    static String[] pan = {"pan", "5", "-1"};

//    Arm
    static String Ring = "Ring";
    static String Gauntlet = "Gauntlet";
    static String Bracelet = "Bracelet";

//    Leg
    static String Boots = "Boots";
    static String Anklet = "Anklet";

    public static void main(String[] args) {
        UnjiMan hero = new Equipment(unjiMan, dagger, pan);
        hero.emoteSmile();

        SpermMan enemy = new Equipment(spermMan,knife, shield);
        enemy.emoteLove();

        hero.status();
        enemy.status();

        ((Equipment) hero).getLeg(Boots);
        ((Equipment) hero).statusAccessories();
        ((Equipment) hero).getArm(Ring);
        ((Equipment) hero).statusAccessories();
        ((Equipment) hero).kickEmote();

        hero.attack(enemy);
        hero.attack(enemy);
        enemy.def();

        enemy.getAtk();
        enemy.friendBuff();
        enemy.status();

        hero.status();

    }
}