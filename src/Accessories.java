interface Accessories {
    void statusAccessories();
    // คำสั่งแสดงสถานะของ Accessories
}

interface ArmAccessories extends Accessories {
    void getArm(String arm);
}

interface LegAccessories extends Accessories {
    void getLeg(String leg);
}

interface Ring extends ArmAccessories {
    void fuckyouEmote();
    // คำสั่งโชว์แหวนท่าชูนิ้วกลาง
}

interface Gauntlet extends ArmAccessories {
    void snapEmote();
    // คำสั่งโชว์ถุงท่าดีดนิ้ว
}

interface Bracelet extends ArmAccessories {
    void holdUp2FingerEmote();
    // คำสั่งโชว์สร้อยข้อมือท่าชูสองนิ้ว
}

interface Boots extends LegAccessories {
    void kickEmote();
    // คำสั่งโชว์รองเท้าท่าเตะ
}

interface Anklet extends LegAccessories {
    void handStandEmote();
    // คำสั่งโชว์กำไลข้อเท้าท่าหกสูง
}