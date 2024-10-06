package org.example;

public class Grader {
    public char determineLetterGrade (int numberGrade) throws IllegalAccessException {
        if (numberGrade < 0){
            try {
                throw new IllegalAccessException("Number grade cannot be");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else if (numberGrade < 60) {
            return 'F';
        } else if (numberGrade < 70) {
            return 'D';
        } else if (numberGrade < 80) {
            return 'C';
        } else if (numberGrade < 90) {
            return 'B';
        }
        else{
            return 'A';
        }
    }
}
