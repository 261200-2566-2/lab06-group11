public class Equipment extends RPGCharacters implements UnjiMan, SpermMan, PennisMan, Ring, Gauntlet, Bracelet, Boots, Anklet {
    private String nameSword;
    private double swordBaseDamage;
    private double runSpeedDecreaseSword;
    private double swordDamage;
    private int levelSword;

    private String nameShield;
    private double shieldBaseDef;
    private double runSpeedDecreaseShield;
    private double shieldDef;
    private int levelShield;

    private boolean friendBuff = false;
    private boolean lostWeight = false;
    private boolean getSpeed = false;
    private boolean getAtk = false;

    private String nameArm = "";
    private String nameLeg = "";

    private double runSpeed;

    public Equipment(String[] hero, String[] sword, String[] shield) {
        super(hero);

        this.nameSword = sword[0];
        this.swordBaseDamage = Double.parseDouble(sword[1]);
        this.runSpeedDecreaseSword = Double.parseDouble(sword[2]);
        this.levelSword = 1;

        this.nameShield = shield[0];
        this.shieldBaseDef = Double.parseDouble(shield[1]);
        this.runSpeedDecreaseShield = Double.parseDouble(shield[2]);
        this.levelShield = 1;
    }

    @Override
    public void status() {
        update();
        super.status();
        System.out.println("Your HP is: " + currentHP);
        System.out.println("Your Mana is: " + currentMana);
        System.out.println("Your Move Speed is: " + runSpeed);
        System.out.println("Your Damage: " + swordDamage);
        System.out.println("Your Defense: " + shieldDef);
        System.out.println("///////////////////////////////////////////");
    }

    private void update() {
        swordDamage = swordBaseDamage * (1 * (0.1 + levelSword));
        if(getAtk) swordDamage *= 1.75;
        if(friendBuff) swordDamage += 5;
        if(!nameArm.isEmpty()) swordDamage += 2;
        shieldDef = shieldBaseDef*(0.8+ 0.05*levelShield);
        if(friendBuff) shieldDef += 5;
        runSpeed = baseRunSpeed + runSpeedDecreaseSword + runSpeedDecreaseShield;
        if(lostWeight) runSpeed += 2;
        if(getSpeed) runSpeed = 16;
        if(!nameLeg.isEmpty()) runSpeed += 2;
    }

    public void statusEquipment() {
        System.out.println("///////////// " + name + " /////////////////");
        System.out.println("Equipped Sword: " + nameSword);
        System.out.println("Sword Level: " + levelSword);
        System.out.println("Sword Damage: " + swordBaseDamage);
        System.out.println("Sword Run Speed Decrease: " + runSpeedDecreaseSword);

        System.out.println("Equipped Shield: " + nameShield);
        System.out.println("Shield Level: " + levelShield);
        System.out.println("Shield Defense: " + shieldBaseDef);
        System.out.println("Shield Run Speed Decrease: " + runSpeedDecreaseShield);
        System.out.println("///////////////////////////////////////////");
    }

    @Override
    public int attack(RPGCharacter enemy) {
        decreaseMana(3);
        enemy.decreaseHP(swordDamage);
        System.out.println(name + " attacks " + enemy.getName());
        System.out.println("ทำให้ HP ของ " + enemy.getName() + " ลดเหลือ: " + enemy.getCurrentHP());
        return 0;
    }

    public void def() {
        decreaseMana(3);
        decreaseHP(-shieldDef);
        System.out.println(name + " ป้องกันไว้ได้บางส่วน ทำให้เหลือ HP: " + getCurrentHP());
    }

    @Override
    public void friendBuff() {
        decreaseMana(6);
        super.friendBuff();
        swordDamage += 5;
        shieldDef += 5;
        friendBuff = true;
        System.out.println(name + " ใช้ friendBuff ทำให้ HP+30 Def+15 Damage+5");
    }

    @Override
    public void lostWeight() {
        decreaseMana(5);
        lostWeight = true;
        System.out.println(name + " ใช้วิชาตัวเบาทำให้ Move Speed ลดลง 2");
    }

    @Override
    public int friendHealing() {
        return 0;
    }

    @Override
    public void barrier() {
        decreaseMana(10);
        decreaseHP(-100);
        System.out.println(name + " สร้างบาเรียป้องกัน 100 ดาเมจ ทำให้ HP: " + getCurrentHP());
    }

    @Override
    public void friendhealing() {
        decreaseMana(10);
        decreaseHP(-20);
        System.out.println(name + " ได้เพิ่มเลือด ทำให้ HP+20");
    }

    @Override
    public void getSpeed() {
        decreaseMana(2);
        getSpeed = true;
        System.out.println(name + " ได้วิ่งไว ทำให้ MoveSpeed=16");
    }

    @Override
    public void getAtk() {
        decreaseMana(6);
        getAtk = true;
        System.out.println(name + " ได้เพิ่มความแรงดาบ ทำให้ Damage เพิ่ม");
    }

    @Override
    public void getHP() {
        decreaseMana(6);
        currentHP += 500;
    }

    @Override
    public void emoteSmile() {
        System.out.println(name + " ทำท่า 😆");
    }

    @Override
    public void emoteLove() {
        System.out.println(name + " ทำท่า 🫶");
    }

    @Override
    public void emoteHulk() {
        System.out.println(name + " ทำท่า 💪");
    }

    @Override
    public void statusAccessories() {
        System.out.println("///////////////////////////////////////////");
        System.out.println("Your AccessoriesArm: " + nameArm);
        System.out.println("Your AccessoriesLeg: " + nameLeg);
        System.out.println("///////////////////////////////////////////");
    }

    @Override
    public void fuckyouEmote() {
        System.out.println(name + " ทำท่า 👃");
    }

    @Override
    public void getArm(String arm) {
        if (arm.equals("Ring") || arm.equals("Gauntlet") || arm.equals("Bracelet")) {
            this.nameArm = arm;
            System.out.println(name + "ได้ใส่ " + nameArm + " แล้วทำให้ Damage+2");
        } else {
            this.nameArm = "";
        }
    }

    @Override
    public void snapEmote() {
        System.out.println(name + " ทำท่า 👋");
    }

    @Override
    public void holdUp2FingerEmote() {
        System.out.println(name + " ทำท่า ✌️");
    }

    @Override
    public void getLeg(String leg) {
        if (leg.equals("Boots") || leg.equals("Anklet")) {
            this.nameLeg = leg;
            System.out.println(name + "ได้ใส่ " + nameLeg + " แล้วทำให้ MoveSpeed+2");
        } else {
            this.nameLeg = "";
        }
    }

    @Override
    public void kickEmote() {
        System.out.println(name + " ทำท่า 🦵");
    }

    @Override
    public void handStandEmote() {
        System.out.println(name + " ทำท่า 🤸‍♀️");
    }
}
