package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {
    @Test
    void returnF() throws IllegalAccessException {
        var grader = new Grader();
        assertEquals('F',grader.determineLetterGrade(59));
    }

}