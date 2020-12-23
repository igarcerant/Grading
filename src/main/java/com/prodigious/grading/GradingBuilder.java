/*
 * Copyright (C) 2020 by Ivan Garcerant <igarcerant@gmail.com>
 *
 * All rights reserved. See LICENSE.md for details.
 */
package com.prodigious.grading;

/**
 *  Creates GradingDigest objects given the proper parameters
 */
public class GradingBuilder {
    public static GradingDigest createGradingDigest(float assignments, float tests, float additionals) {
        return new GradingDigest(new Course(assignments, tests, additionals));
    }
    public static GradingDigest createGradingDigest(Course parameters) {
        return new GradingDigest(parameters);
    }
}
