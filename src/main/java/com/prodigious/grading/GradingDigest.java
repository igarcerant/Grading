/*
 * Copyright (C) 2020 by Ivan Garcerant <igarcerant@gmail.com>
 *
 * All rights reserved. See LICENSE.md for details.
 */

package com.prodigious.grading;

/**
 * Calculate the student's grading following an digest-like API model
 * 
 * To use this class, you need to instantace one using GradingBuilder
 * with the propers parameters, then call any of the grade() methods
 * to report the individual grades, and finally call calification()
 * to get the final grade
 * 
 */
public class GradingDigest {
    /**
     * activities weights
     */
    private final Course parameters;
    /**
     * used to accumulate assignment grades
     */
    private Accumulator assignments;
    /**
     * used to accumulate test grades
     */
    private Accumulator tests;
    /**
     * how many decimals we wish to use. We need at least 3.
     */
    private final int places;
    /**
     * constructor
     * 
     * @param parameters parameters given as a Course instance
     */
    public GradingDigest (Course parameters) {
        this.parameters = parameters;
        places = 3;
        assignments = new Accumulator();
        tests = new Accumulator();
    }
    /**
     * set the accumulator to zero
     */
    public void reset() {
        assignments = new Accumulator();
        tests = new Accumulator();
    }
    /**
     * add one grade to the assignments
     * 
     * @param grade points achieved by the student
     */
    public void gradeAssignment(int grade) {
        assignments.update(grade);
    }
    /**
     * add one grade to the assignments
     * 
     * @param grade points achieved by the student
     * @param over max possible grade
     */
    public void gradeAssignment(int grade, int over) {
        assignments.update(grade,over);
    }
    /**
     * add one grade to the tests
     * 
     * @param grade points (over 100) achieved by the student
     */
    public void gradeTests(int grade) {
        tests.update(grade);
    }
    /**
     * add one grade to the tests
     * 
     * @param grade points achieved by the student
     * @param over max possible grade
     */
    public void gradeTest(int grade, int over) {
        tests.update(grade,over);
    }
    /**
     * add one grade to the special activities
     * 
     * @param approved true if the student approved the extra activity
     */
    public void gradeAdditionalAssignment(boolean approved) {
        assignments.extra(parameters.getAdditionalsWeight());
        tests.extra(parameters.getAdditionalsWeight());
    }
    /**
     * get the student's final calification
     * 
     * @return student's final grade as in the range (0.0f - 1.0f)
     */
    public double calification() {
        double scale = Math.pow(10,places);
        double finalAssignment = Math.round(assignments.grade()*parameters.getAssignmentWeight()*scale)/scale;
        double finalTests = Math.round(tests.grade()*parameters.getTestsWeight()*scale)/scale;
        return Math.round((finalAssignment + finalTests)*scale)/scale;
    }
}
