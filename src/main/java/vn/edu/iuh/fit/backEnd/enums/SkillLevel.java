package vn.edu.iuh.fit.backEnd.enums;

public enum SkillLevel {
    MASTER(1),
    BEGINER(2),
    ADVANCED(3),
    PROFESSIONAL(4),
    IMTERMEDIATE(5);

    private int value;

    public int getValue() {
        return value;
    }

    SkillLevel(int value) {
        this.value = value;
    }
}
