package vn.edu.iuh.fit.backEnd.enums;

public enum SkillType {
    SOFT_SKILL(1),
    UNSPECIFC(2),
    TECHNICAL_SKILL(3);

    private int value;

    public int getValue() {
        return value;
    }

    SkillType(int value) {
        this.value = value;
    }
}
