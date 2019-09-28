package com.example.demo.enums;

public enum EnumDeleteType {
    NOT_DELETED(0),
    DELETED(1);
    private final Integer type;

    public Integer getType() {
        return type;
    }

    EnumDeleteType(Integer type) {
        this.type = type;
    }

    public static EnumDeleteType forType(Integer type) {
        for (EnumDeleteType deleteType : values()) {
            if (deleteType.getType().equals(type)) {
                return deleteType;
            }
        }
        throw new IllegalStateException("EnumDeleteType type error");
    }
}
