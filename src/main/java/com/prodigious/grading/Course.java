/*
 * Copyright (C) 2020 by Ivan Garcerant <igarcerant@gmail.com>
 *
 * All rights reserved. See LICENSE.md for details.
 */

package com.prodigious.grading;

/**
 *  Capture the configuration setted by a Teacher for their courses
 * 
 *  NOTE: this class is better expressed as Java Records, In order to do this
 *  we should activate preview features on JDK 14
 *  see https://docs.oracle.com/en/java/javase/14/language/records.html
 */
public class Course {
    private final float assignmentsWeight;
    private final float testsWeight;
    private final float additionalsWeight;
    /**
     * Constructs a course given its three weights
     * 
     * @param assignmentsWeight weight of the assignments
     * @param testsWeight weight of the tests
     * @param additionalsWeight weight of the extra points
     * @throws IllegalArgumentException none of the arguments can be negative
     */
    public Course(float assignmentsWeight, float testsWeight, float additionalsWeight) throws IllegalArgumentException {
        if (assignmentsWeight < 0.0f) {
            throw new IllegalArgumentException("assignmentsWeight cannot be negative");
        } else {
            this.assignmentsWeight = assignmentsWeight;
        }
        if (testsWeight < 0.0f) {
            throw new IllegalArgumentException("testsWeight cannot be negative");
        } else {
            this.testsWeight = testsWeight;
        }
        if (additionalsWeight < 0.0f) {
            throw new IllegalArgumentException("additionalsWeight cannot be negative");
        } else {
            this.additionalsWeight = additionalsWeight;
        }
    }
    public float getAssignmentWeight() {
        return assignmentsWeight;
    }
    public float getTestsWeight() {
        return testsWeight;
    }
    public float getAdditionalsWeight() {
        return additionalsWeight;
    }
}
