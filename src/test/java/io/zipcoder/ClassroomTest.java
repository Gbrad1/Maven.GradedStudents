package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class ClassroomTest {

    private static final Logger LOGGER = Logger.getLogger(ClassroomTest.class.getName());
    Classroom classroom;
    Student s1;
    Student s2;
    Student student;
    Student student2;
    Student student3;
    Student student4;

    @Before
    public void setupBeforeEachTest() {
        Double[] leonExamScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] robertoExamScores = { 1.0, 13.0, 79.0, 32.0 };
        Double[] chrisExamScores = { 110.0, 125.0, 35.0, 138.0 };
        Double[] sianExamScores = { 300.0, 120.0, 45.0, 120.0 };

        student = new Student("Leon", "Hunter", leonExamScores);
        student2 = new Student("Roberto", "DeDeus", robertoExamScores);
        student3 = new Student("Chris", "Nobles", chrisExamScores);
        student4 = new Student("Sian", "Carter", sianExamScores);

        ArrayList<Student> listOfStudents = new ArrayList<Student>();
        listOfStudents.add(student);
        listOfStudents.add(student2);
        listOfStudents.add(student3);

        classroom = new Classroom(listOfStudents);

    }

    @Test
    public void getClassRoomAverageExamScore() {
        Double actual = classroom.getAverageClassroomExamScore();
        Double expected = 109.66666666666667;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest() {
        classroom.addStudent(student4);
        Integer actual = classroom.getStudents().size();
        Integer expected = 4;
        LOGGER.info("\n" + classroom.getStudents().toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeStudentTest() {
        Integer a = classroom.getStudents().size();
        LOGGER.info("\n" + a);
        classroom.removeStudent("Chris", "Nobles");

        Integer actual = classroom.getStudents().size();
        Integer expected = 2;

        LOGGER.info("\n" + actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScore() {
        classroom.addStudent(student4);
        classroom.getStudentsByScore();
        LOGGER.info("\n" + classroom.getStudents());
        Double actual = classroom.getStudents().get(0).getAverageExamScore();
        Double expected = 146.0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void gradeBookTest() {
        classroom.getGradeBook();
        classroom.getGradeBook().entrySet();
        LOGGER.info("\n" + classroom.getGradeBook().entrySet());
    }

}
