interface RPGCharacter {
    void status();
    void attack(RPGCharacter enemy);
    void def();
    void decreaseHP(double i);
    void decreaseMana(double i);
    double getCurrentHP();
    String getName();
    double getCurrentMana();
    void friendBuff();
    void lostWeight();
    void barrier();
    void friendhealing();
    void getSpeed();
    void getAtk();

    void getHP();

    void emoteSmile();

    void emoteLove();

    void emoteHulk();
}

interface Priest extends RPGCharacter {
    void friendBuff();
    // คำสั่งเพิ่ม AllStat(ATK,DEF,HP) ให้เพื่อน
}

interface Assassin extends RPGCharacter {
    void lostWeight();
    // คำสั่งทำที่ทำให้ตัวเบา
}

interface Tank extends RPGCharacter {
    void barrier();
    // คำสั่งสร้างบาเรียป้องกัน บาเรียป้องกันได้100ดาเมจ
}

interface Heal extends Priest {
    void friendhealing();
    // คำสั่งฮีลให้ตัวเองและเพื่อนรอบตัว
}

interface Active extends Priest, Assassin {
    void getSpeed();
    // คำสั่งทำให้ตัวเองวิ่งไวขึ้น RunSpeed = 16
}

interface Strength extends Assassin, Tank {
    void getAtk();
    // คำสั่งที่ทำตีแรงขึ้นเป็น 1.75 เท่าของความแรงเดิมช่วงเวลาหนึ่ง
    // output คือ 1.75*baseDamage
}

interface Vitality extends Tank {
    void getHP();
    // คำสั่งเพิ่มHPให้ตัวเองอย่างมหาศาล
}

interface UnjiMan extends Heal {
    void emoteSmile();
    // ทำท่ายิ้ม
}

interface SpermMan extends Active, Strength {
    void emoteLove();
    // ทำท่าหัวใจ
}

interface PennisMan extends Strength, Vitality {
    void emoteHulk();
    // ทำท่าเบ่งกล้าม
}