package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Logger;

public class ClassroomTest {

    private static final Logger LOGGER = Logger.getLogger(ClassroomTest.class.getName());

    @Test
    public void getClassRoomAverageExamScore() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageClassroomExamScore();
        double expected = 125.0;
        // Then
        //Assert.assertEquals(expected, output);
        LOGGER.info("\n" + output);
    }

    @Test
    public void addStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        LOGGER.info("\n" + preEnrollmentAsString);
        LOGGER.info("\n" + postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest() {
        int maxNumberOfStudents = 5;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] leonExamScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] robertoExamScores = { 100.0, 125.0, 45.0, 138.0};
        Double[] chrisExamScores = { 110.0, 125.0, 35.0, 138.0};
        Student student = new Student("Leon", "Hunter", leonExamScores);
        Student student2 = new Student("Roberto", "DeDeus", robertoExamScores);
        Student student3 = new Student("Chris", "Nobles", chrisExamScores);

        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        classroom.removeStudent("Chris", "Nobles");

        Integer a = classroom.getStudents().length;

        LOGGER.info("\n" + a);
    }

}
