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
public class GradingDigestTest {
    
    public GradingDigestTest() {
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
     * Test of reset method, of class GradingDigest.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        GradingDigest instance = GradingBuilder.createGradingDigest(0.2f, 0.8f, 0.02f);
        instance.reset();
        assertNotNull(instance);
    }

    /**
     * Test of gradeAssignment method, of class GradingDigest.
     */
    @Test
    public void testGradeOneAssignment() {
        System.out.println("testGradeOneAssignment");
        int grade = 70;
        int over = 100;
        float assignmentWeight = 0.2f;
        double expected = 0.7f * assignmentWeight;
        GradingDigest instance = GradingBuilder.createGradingDigest(assignmentWeight, 0.8f, 0.02f);
        instance.gradeAssignment(grade,over);
        double calification = instance.calification();
        assertEquals(expected, calification, 0.01f);
    }

    /**
     * Test of gradeAssignment method, of class GradingDigest.
     */
    @Test
    public void testGradeOneAssignment_Course() {
        System.out.println("testGradeOneAssignment");
        int grade = 70;
        int over = 100;
        float assignmentWeight = 0.2f;
        double expected = 0.7f * assignmentWeight;
        Course course = new Course(assignmentWeight, 0.8f, 0.02f);
        GradingDigest instance = GradingBuilder.createGradingDigest(course);
        instance.gradeAssignment(grade,over);
        double calification = instance.calification();
        assertEquals(expected, calification, 0.01f);
    }    
    
    /**
     * Test of gradeAssignment method, of class GradingDigest.
     */
    @Test
    public void testGradeMultipleAssignment_Course() {
        System.out.println("testGradeMultipleAssignment_Course");
        int[] grade = {70,50,80,90};
        int over = 100;
        float assignmentWeight = 0.2f;
        double expected = 0.72f * assignmentWeight;
        Course course = new Course(assignmentWeight, 0.8f, 0.02f);
        GradingDigest instance = GradingBuilder.createGradingDigest(course);
        for (int i=0; i<grade.length; i++)
            instance.gradeAssignment(grade[i],over);
        double calification = instance.calification();
        assertEquals(expected, calification, 0.01f);
    }

    /**
     * Test of gradeTest method, of class GradingDigest.
     */
    @Test
    public void testGradeOneTest() {
        System.out.println("testGradeOneTest");
        int grade = 70;
        int over = 100;
        float testWeight = 0.2f;
        double expected = 0.7f * testWeight;
        GradingDigest instance = GradingBuilder.createGradingDigest(0.2f, testWeight, 0.02f);
        instance.gradeTest(grade,over);
        double calification = instance.calification();
        assertEquals(expected, calification, 0.01f);
    }

    /**
     * Test of gradeTest method, of class GradingDigest.
     */
    @Test
    public void testGradeMultipleTest() {
        System.out.println("testGradeMultipleTest");
        int[] grade = {70,50,80,90};
        int over = 100;
        float testWeight = 0.8f;
        double expected = 0.72f * testWeight;
        GradingDigest instance = GradingBuilder.createGradingDigest(0.2f, testWeight, 0.02f);
        for (int i=0; i<grade.length; i++)
            instance.gradeTest(grade[i],over);
        double calification = instance.calification();
        assertEquals(expected, calification, 0.01f);
    }
    
    /**
     * Test of gradeAdditionalAssignment(), of class GradingDigest.
     */
    @Test
    public void testGradeAdditionalAssignment() {
        System.out.println("testGradeAdditionalAssignment");
        GradingDigest instance = GradingBuilder.createGradingDigest(0.2f, 0.8f, 0.02f);
        instance.gradeAdditionalAssignment(true);
        double expected = 0.0f;
        double calification = instance.calification();
        assertEquals(expected, calification, 0.01f);
    }
    
    /**
     * This test came with the project statement
     */
    @Test
    public void testProjectStatement() {
        System.out.println("Project Statement's test");
        float tomAsig = 0.101f;
        float tomExam = 0.899f;
        float tomExtr = 0.020f;
        GradingDigest instance = GradingBuilder.createGradingDigest(tomAsig, tomExam, tomExtr);
        instance.gradeAssignment(85,100);
        instance.gradeAssignment(88,100);
        instance.gradeAdditionalAssignment(true);
        instance.gradeAssignment(92,100);
        instance.gradeTest(91,100);
        double calification = instance.calification();
        double expected = 0.9093f;
        assertEquals(expected, calification, 0.001f);
    }
    
}
