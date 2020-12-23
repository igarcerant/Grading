/*
 * Copyright (C) 2020 by Ivan Garcerant <igarcerant@gmail.com>
 *
 * All rights reserved. See LICENSE.md for details.
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
 */
public class CourseTest {
    
    public CourseTest() {
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
     * Test of getAssignmentWeight method, of class Course.
     */
    @Test
    public void testGetAssignmentWeight() {
        System.out.println("getAssignmentWeight");
        Course instance = new Course(0.1f, 0.9f, 0.02f);
        float expResult = 0.1f;
        float result = instance.getAssignmentWeight();
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of getAssignmentWeight method, of class Course.
     */
    @Test
    public void testAssignmentWeightIsZero() {
        System.out.println("AssignmentWeightIsZero");
        Course instance = new Course(0.0f, 0.9f, 0.02f);
        float expResult = 0.0f;
        float result = instance.getAssignmentWeight();
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test invalid assignmentWeight parameter in constructor, of class Course
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAssignmentWeightIsNegative() {
        System.out.println("assignmentWeight");
        Course instance = new Course(-0.1f, 0.9f, 0.02f);
    }

    /**
     * Test of getAdditionalsWeight method, of class Course.
     */
    @Test
    public void testGetTestsWeight() {
        System.out.println("getTestsWeight");
        Course instance = new Course(0.1f, 0.9f, 0.02f);
        float expResult = 0.9f;
        float result = instance.getTestsWeight();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getAdditionalsWeight method, of class Course.
     */
    @Test
    public void testGetTestsWeightIsZero() {
        System.out.println("getTestsWeightIsZero");
        Course instance = new Course(0.1f, 0.0f, 0.02f);
        float expResult = 0.0f;
        float result = instance.getTestsWeight();
        assertEquals(expResult, result, 0.01);
    }    
    
    /**
     * Test invalid testsWeight parameter in constructor, of class Course
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTestsWeightIsNegative() {
        System.out.println("testsWeight");
        Course instance = new Course(0.1f, -0.9f, 0.02f);
    }
    
    /**
     * Test of getAdditionalsWeight method, of class Course.
     */
    @Test
    public void testGetAdditionalsWeight() {
        System.out.println("getAdditionalsWeight");
        Course instance = new Course(0.1f, 0.9f, 0.02f);
        float expResult = 0.02f;
        float result = instance.getAdditionalsWeight();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getAdditionalsWeight method, of class Course.
     */
    @Test
    public void testGetAdditionalsWeightIsZero() {
        System.out.println("getAdditionalsWeightIsZero");
        Course instance = new Course(0.1f, 0.9f, 0.0f);
        float expResult = 0.0f;
        float result = instance.getAdditionalsWeight();
        assertEquals(expResult, result, 0.01);
    }    
    
    /**
     * Test invalid testsWeight parameter in constructor, of class Course
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAdditionalsWeightIsNegative() {
        System.out.println("additionalsWeight");
        Course instance = new Course(0.1f, -0.9f, 0.02f);
    }


    
}
