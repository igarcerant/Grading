/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prodigious.grading;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivan
 */
public class AccumulatorTest {
    
    public AccumulatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Accumulator.
     */
    @Test
    public void testUpdate_int() {
        System.out.println("update_int");
        int grade = 30;
        Accumulator instance = new Accumulator();
        instance.update(grade);
        double calification = instance.grade();
        assertEquals(0.3f, calification, 0.01f);
    }

    /**
     * Test of update method, of class Accumulator.
     */
    @Test
    public void testUpdate_int_int() {
        System.out.println("update_int_int");
        int grade = 30;
        int over = 100;
        Accumulator instance = new Accumulator();
        instance.update(grade, over);
        double calification = instance.grade();
        assertEquals(0.3f, calification, 0.01f);
    }

    /**
     * Test of extra method, of class Accumulator.
     */
    @Test
    public void testExtra() {
        System.out.println("extra");
        double percent = 0.02;
        int grade = 30;
        int over = 100;
        Accumulator instance = new Accumulator();
        instance.update(grade,over);
        instance.extra(percent);
        double calification = instance.grade();
        assertEquals(0.32f, calification, 0.01f);
    }

}
