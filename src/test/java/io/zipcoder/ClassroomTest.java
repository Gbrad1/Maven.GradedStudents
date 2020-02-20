package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class ClassroomTest {

    private static final Logger LOGGER = Logger.getLogger(ClassroomTest.class.getName());

    @Test
    public void getAverageExamScore() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageClassroomExamScore();

        // Then
        LOGGER.info("\n" + output);
    }
}
