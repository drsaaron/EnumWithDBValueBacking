/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.blazartech.enumwithdbvaluebacking;

import static com.blazartech.enumwithdbvaluebacking.TestEnumerationType.Second;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author scott
 */
@ExtendWith(SpringExtension.class)
@Slf4j
public class EnumWithDBValueBackingTest {
    
    public EnumWithDBValueBackingTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getFromDBValue method, of class EnumWithDBValueBacking.
     */
    @Test
    public void testGetFromDBValue() {
        log.info("getFromDBValue");
        
        char dbValue = 's';
        TestEnumerationType expResult = Second;
        TestEnumerationType result = TestEnumerationType.getFromDBValue(dbValue);
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFromDBValue_throwInvalid() {
        log.info("getFromDBValue_throwInvalid");
        
        char dbValue = 'q';
        Exception e = assertThrows(IllegalArgumentException.class, () -> TestEnumerationType.getFromDBValue(dbValue));
        assertTrue(e.getMessage().startsWith("no enum found for db value"));
    }
    
    @Test
    public void testGetFromDBValue_defaultValue() {
        log.info("getFromDBValue");
        
        char dbValue = '1';
        TestEnumerationType expResult = Second;
        TestEnumerationType result = TestEnumerationType.getFromDBValue(dbValue, expResult);
        
        assertEquals(expResult, result);
    }
}
