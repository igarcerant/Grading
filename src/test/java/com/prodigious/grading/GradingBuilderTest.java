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
 * @author ivan
 */
public class GradingBuilderTest {
    
    public GradingBuilderTest() {
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
     * Test of createGradingDigest method, of class GradingBuilder.
     */
    @Test
    public void testCreateGradingDigestIsNotNull_3args() {
        System.out.println("createGradingDigestIsNotNull_3args");
        float assignments = 0.1f;
        float tests = 0.9f;
        float additionals = 0.02f;
        GradingDigest expResult = null;
        GradingDigest result = GradingBuilder.createGradingDigest(assignments, tests, additionals);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of createGradingDigest method, of class GradingBuilder.
     */
    @Test
    public void testCreateGradingDigestIsNotNull_Course() {
        System.out.println("createGradingDigestIsNotNull_Course");
        float assignments = 0.1f;
        float tests = 0.9f;
        float additionals = 0.02f;
        Course parameters = new Course(assignments, tests, additionals);
        GradingDigest expResult = null;
        GradingDigest result = GradingBuilder.createGradingDigest(parameters);
        assertNotEquals(expResult, result);
    }
    
}
