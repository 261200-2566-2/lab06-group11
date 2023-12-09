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

    /*
    */
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

    /*
    * แสดง status พื้นฐาน
    * effect: แสดงผล status พื่นฐานออกทางหน้าจอ
    */
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

    /*
    * แสดง status ของ Equipment
    * effect: แสดงผล status ของEquipment ออกทางหน้าจอ
    */
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

    /*
    * โจมตี
    * effect: ลด Mana, ทำการโจมตี enemy
    *         และแสดงผลออกทางหน้าจอ
    */
    @Override
    public void attack(RPGCharacter enemy) {
        decreaseMana(3);
        enemy.decreaseHP(swordDamage);
        System.out.println(name + " attacks " + enemy.getName());
        System.out.println("ทำให้ HP ของ " + enemy.getName() + " ลดเหลือ: " + enemy.getCurrentHP());
    }

    /*
    * ป้องกันดาเมจตาม shieldDef ที่มี
    * effect: ลดค่าของ Mana, เปลี่ยนแปลง HP ขึ้นตาม shieldDef
    *         และแสดงผลข้อมูลออกทางหน้าจอ
    */
    public void def() {
        decreaseMana(3);
        decreaseHP(-shieldDef);
        System.out.println(name + " ป้องกันไว้ได้บางส่วน ทำให้เหลือ HP: " + getCurrentHP());
    }

    /*
    * เพิ่มบัพให้กับเพื่อน
    * effect: ลดค่าของ Mana ,เรียกfriendBuff()ใน RPGCharacters
    *         ,เพื่มค่า swordDamage,shieldDef
    *         และแสดงผลข้อมูลออกทางหน้าจอ
    */
    @Override
    public void friendBuff() {
        decreaseMana(6);
        super.friendBuff();
        swordDamage += 5;
        shieldDef += 5;
        friendBuff = true;
        System.out.println(name + " ใช้ friendBuff ทำให้ HP+30 Def+15 Damage+5");
    }

    /*
    * วิชาตัวเบา
    * effect: ลดค่าของ Mana , เพิ่ม MoveSpeed
    *         ,แสดงผลข้อมูลออกทางหน้าจอ
    */
    @Override
    public void lostWeight() {
        decreaseMana(5);
        lostWeight = true;
        System.out.println(name + " ใช้วิชาตัวเบาทำให้ Move Speed ลดลง 2");
    }

    /*
    * สร้างเกราะป้องกันบาเรีย
    * effect: ลดค่าของ Mana , เพิ่ม HP
    *         ,แสดงผลข้อมูลออกทางหน้าจอ
    */
    @Override
    public void barrier() {
        decreaseMana(10);
        decreaseHP(-100);
        System.out.println(name + " สร้างบาเรียป้องกัน 100 ดาเมจ ทำให้ HP: " + getCurrentHP());
    }

    /*
    * เพิ่ม HP
    * effect: ลดค่าของ Mana , เพิ่ม HP
    *         ,แสดงผลข้อมูลออกทางหน้าจอ
    */
    @Override
    public void friendhealing() {
        decreaseMana(10);
        decreaseHP(-20);
        System.out.println(name + " ได้เพิ่มเลือด ทำให้ HP+20");
    }

    /*
    * วิชาวิ่งไว
    * effect: ลดค่าของ Mana , เพิ่ม MoveSpeed
    *         ,แสดงผลข้อมูลออกทางหน้าจอ
    */
    @Override
    public void getSpeed() {
        decreaseMana(2);
        getSpeed = true;
        System.out.println(name + " ได้วิ่งไว ทำให้ MoveSpeed=16");
    }

    /*
    * วิชาโจมตีแรง
    * effect: ลดค่าของ Mana , เพิ่ม swordDamage
    *         ,แสดงผลข้อมูลออกทางหน้าจอ
    */
    @Override
    public void getAtk() {
        decreaseMana(6);
        getAtk = true;
        System.out.println(name + " ได้เพิ่มความแรงดาบ ทำให้ Damage เพิ่ม");
    }

    /*
    * วิชาเพิ่มเลือด
    * effect: ลดค่าของ Mana , เพิ่ม HP
    */
    @Override
    public void getHP() {
        decreaseMana(6);
        currentHP += 500;
    }

    /*
    * ทำท่ายิ้ม
    * effect: แสดงผลท่ายิ้ม
    */
    @Override
    public void emoteSmile() {
        System.out.println(name + " ทำท่า 😆");
    }

    /*
    * ทำท่าหัวใจ
    * effect: แสดงผลท่าหัวใจ
    */
    @Override
    public void emoteLove() {
        System.out.println(name + " ทำท่า 🫶");
    }

    /*
    * ทำท่าเบ่งกล้าม
    * effect: แสดงผลท่าเบ่งกล้าม
    */
    @Override
    public void emoteHulk() {
        System.out.println(name + " ทำท่า 💪");
    }

    /*
    * แสดง status ของ Accessories
    * effect: แสดงผล status ออกมาทางหน้าจอ
    */
    @Override
    public void statusAccessories() {
        System.out.println("///////////////////////////////////////////");
        System.out.println("Your AccessoriesArm: " + nameArm);
        System.out.println("Your AccessoriesLeg: " + nameLeg);
        System.out.println("///////////////////////////////////////////");
    }

    /*
    * ทำท่าฟักยู
    * effect: แสดงผลท่าฟักยู
    */
    @Override
    public void fuckyouEmote() {
        System.out.println(name + " ทำท่า 👃");
    }

    /*
    * ใส่ Accessories ที่แขน
    * effect: ใส่ Accessories ชิ้นนั้นถ้ามี
    */
    @Override
    public void getArm(String arm) {
        if (arm.equals("Ring") || arm.equals("Gauntlet") || arm.equals("Bracelet")) {
            this.nameArm = arm;
            System.out.println(name + "ได้ใส่ " + nameArm + " แล้วทำให้ Damage+2");
        } else {
            this.nameArm = "";
        }
    }

    /*
    * ทำท่าตบ
    * effect: แสดงผลท่าตบ
    */
    @Override
    public void snapEmote() {
        System.out.println(name + " ทำท่า 👋");
    }

    /*
    * ทำท่าชูสองนิ้ว
    * effect: แสดงผลท่าชูสองนิ้ว
    */
    @Override
    public void holdUp2FingerEmote() {
        System.out.println(name + " ทำท่า ✌️");
    }

    /*
    * ใส่ Accessories ที่ขา
    * effect: ใส่ Accessories ชิ้นนั้นถ้ามี
    */
    @Override
    public void getLeg(String leg) {
        if (leg.equals("Boots") || leg.equals("Anklet")) {
            this.nameLeg = leg;
            System.out.println(name + "ได้ใส่ " + nameLeg + " แล้วทำให้ MoveSpeed+2");
        } else {
            this.nameLeg = "";
        }
    }

    /*
    * ทำท่าแตะ
    * effect: แสดงผลท่าแตะ
    */
    @Override
    public void kickEmote() {
        System.out.println(name + " ทำท่า 🦵");
    }

    /*
    * ทำท่าหกสูง
    * effect: แสดงผลท่าหกสูง
    */
    @Override
    public void handStandEmote() {
        System.out.println(name + " ทำท่า 🤸‍♀️");
    }
}
