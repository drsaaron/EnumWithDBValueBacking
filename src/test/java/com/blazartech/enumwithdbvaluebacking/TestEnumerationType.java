/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.blazartech.enumwithdbvaluebacking;

/**
 *
 * @author scott
 */
public enum TestEnumerationType implements EnumWithDBValueBacking<Character>{

    First('f'), Second('s'), Third('t'), None('n');

    private final char dbValue;

    private TestEnumerationType(char dbValue) {
        this.dbValue = dbValue;
    }
    
    @Override
    public Character getDBValue() {
        return dbValue;
    }
    
    public static TestEnumerationType getFromDBValue(char t) {
        return EnumWithDBValueBacking.getFromDBValue(TestEnumerationType.class, t);
    }
    
    public static TestEnumerationType getFromDBValue(char t, TestEnumerationType defaultValue) {
        return EnumWithDBValueBacking.getFromDBValue(TestEnumerationType.class, t, defaultValue);
    }
}
