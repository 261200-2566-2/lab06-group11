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

    /*
    * อัพเดทสถานะตัวละคร แสดงชื่อและเลเวลบนหน้าจอ
    */
    public void status() {
        System.out.println("///////////// " + name + " /////////////////");
        System.out.println("Your Level is: " + level);
    }

    /*
    * ลดเลือดของตัวละครตามจำนวนamount
    * effect: ทำให้ HP ลดลงตาม amount ที่ได้รับ
    */
    public void decreaseHP(double amount) {
        currentHP -= amount;
    }

    /*
    * ทำการป้องกัน
    * effect: แสดงสถานะการป้องกันและแสดงออกทางหน้าจอว่าตัวละครนั้นเหลือเลือดปัจจุบันเท่าไร
    */
    @Override
    public void def(){
        System.out.println(name + " ทำการป้องกัน ทำให้ HP " + name + " เหลือ: " + getCurrentHP());
    }

    /*
    * เรียกชื่อของตัวละครนั้นและส่งค่าของชื่อตัวละคร
    * returns: name ของตัวละคร
    */
    @Override
    public String getName() {
        return name;
    }

    /*
    * เรียกจำนวนเลือดที่เหลือปัจจุบันและส่งค่า
    * returns: HP ปัจจุบัน
    */
    @Override
    public double getCurrentHP() {
        return currentHP;
    }

    /*
    * เรียกจำนวนมานาที่เหลือปัจจุบันและส่งค่า
    * returns: Mana ปัจจุบัน
    */
    @Override
    public double getCurrentMana() {
        return currentMana;
    }

    /*
    * เพิ่มบัพให้กับเพื่อน
    * effect: เพิ่มเลือดให่ตัวละคร30หน่วย
    */
    @Override
    public void friendBuff() {
        currentHP += 30;
    }

    /*
    * ลดค่ามานาของตัวละคร
    * effect: มานาปัจจุบันของตัวละคร - จำนวนมานาที่เสีย
    *         ถ้ามานานปัจจุบันของตัวละครน้อยกว่า0 ให้เซ็ตค่าเป็น0
    */
    public void decreaseMana(double amount) {
        currentMana -= amount;
        if (currentMana < 0) {
            currentMana = 0;
        }
    }

}