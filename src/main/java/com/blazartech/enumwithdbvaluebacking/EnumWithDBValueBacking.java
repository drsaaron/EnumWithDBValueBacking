/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.enumwithdbvaluebacking;

import java.util.stream.Stream;

/**
 * an interface for enumeration types that have database value backing.
 * 
 * @author scott
 */
public interface EnumWithDBValueBacking<T> {
    
    /**
     * get the database value corresponding to the enumeration value
     * @return 
     */
    public T getDBValue();
    
    /**
     * utility method to search the enum values for a given DB value.  If no value
     * is found, throw an IllegalArgumentException.
     * 
     * @param <E> the enumeration type
     * @param <T> the database value type
     * @param enumClass
     * @param dbValue
     * @return the enumeration value
     */
    static <E extends Enum<E> & EnumWithDBValueBacking<T>, T> E getFromDBValue(Class<E> enumClass, T dbValue) {
        
        return Stream.of(enumClass.getEnumConstants())
                .filter(t -> t.getDBValue().equals(dbValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no enum found for db value " + dbValue + " in " + enumClass.getSimpleName()));
    }
    
    /**
     * utility method to search the enum values for a given DB value.  If no value
     * is found, return the provided default value.
     * 
     * @param <E> enumeration type
     * @param <T> the database value type
     * @param enumClass
     * @param dbValue
     * @param defaultValue the default value
     * @return the enumeration value
     */
    static <E extends Enum<E> & EnumWithDBValueBacking<T>, T> E getFromDBValue(Class<E> enumClass, T dbValue, E defaultValue) {
        
        return Stream.of(enumClass.getEnumConstants())
                .filter(t -> t.getDBValue().equals(dbValue))
                .findFirst()
                .orElse(defaultValue);
    }
}
