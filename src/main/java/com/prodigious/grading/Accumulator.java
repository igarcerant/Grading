/*
 * Copyright (C) 2020 by Ivan Garcerant <igarcerant@gmail.com>
 *
 * All rights reserved. See LICENSE.md for details.
 */
package com.prodigious.grading;

/**
 * Represents an updatable mean; it is used to accumulate partial grades
 * up to the course's end
 */
class Accumulator {
    /**
     * sum of all grades obteined by the student
     */
    private int grade = 0;
    /**
     * sum of all points evaluated by the teacher
     */
    private int over = 0;
    /**
     * how many decimals we need
     * (keep in mind that our percents are doubles, so we need at least 3 here)
     */
    private final int places = 3;
    /**
     * add one grade to the accumulation as points over 100
     * 
     * Each update() represent the grade obteined by the student in one
     * activity.
     * 
     * @param grade points obteined by the student
     */
    public void update(int grade) {
        update(grade, 100);
    }
    /**
     * add one grade to the accumulation, given the max possible calification
     * 
     * Each update() represent the grade obteined by the student in on
     * activity.
     * 
     * @param grade points obteined by the student
     * @param over max calification possible
     */
    public void update(int grade, int over) {
        this.over += over;
        this.grade += grade;
    }
    /**
     * add some extra points as percent of the accumulate
     * 
     * @param percent percent to be added to the accumulate
     */
    public void extra(double percent) {
        grade += Math.round(over*percent);
    }
    /**
     * returns the student's final calification
     * 
     * @return calification as 0.0f - 1.0f
     */
    public double grade() {
        double scale = Math.pow(10, places);
        return Math.round((scale*this.grade)/(1.0f*over))/scale;
    }
}
