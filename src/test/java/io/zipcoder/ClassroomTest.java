package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

public class ClassroomTest {

    private static final Logger LOGGER = Logger.getLogger(ClassroomTest.class.getName());
    Classroom classroom;
    Student student;
    Student student2;
    Student student3;
    Student student4;
    ArrayList<Student> letterGradeA;
    ArrayList<Student> letterGradeB;
    ArrayList<Student> letterGradeC;
    ArrayList<Student> letterGradeD;
    ArrayList<Student> letterGradeF;

    @Before
    public void setupBeforeEachTest() {
        Double[] leonExamScores = { 100.0, 150.0, 250.0, 0.0 }; //125.0 average
        Double[] robertoExamScores = { 1.0, 13.0, 79.0, 32.0 }; //31.25 average
        Double[] chrisExamScores = { 110.0, 125.0, 35.0, 60.0 }; //82.50 average
        Double[] sianExamScores = { 300.0, 120.0, 45.0, 120.0 }; //146.25 average

        student = new Student("Leon", "Hunter", leonExamScores);
        student2 = new Student("Roberto", "DeDeus", robertoExamScores);
        student3 = new Student("Chris", "Nobles", chrisExamScores);
        student4 = new Student("Sian", "Carter", sianExamScores);

        classroom = new Classroom();
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
    }

    @Test
    public void getClassRoomAverageExamScore() {
        Double actual = classroom.getAverageClassroomExamScore();
        Double expected = 79.33333333333333;
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
    public void getStudentsByScoreTest() {
        classroom.addStudent(student4);
        classroom.getStudentsByScore();
        LOGGER.info("\n" + classroom.getStudents());
        Double actual = classroom.getStudents().get(0).getAverageExamScore();
        Double expected = 146.0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkATest() {
        letterGradeA = new ArrayList<>();
        classroom.addStudent(student4);
        Integer actualClassroomSize = classroom.getStudents().size();
        Integer expectedClassroomSize = 4;
        classroom.checkIfStudentIsA();
        Integer actualSize = classroom.getLetterGradeA().size();
        Integer expectedSize = 2;
        LOGGER.info("\n" + actualSize);
        Assert.assertEquals(expectedClassroomSize, actualClassroomSize);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void CheckBTest() {
        letterGradeB = new ArrayList<>();
        classroom.addStudent(student4);
        Integer actualClassroomSize = classroom.getStudents().size();
        Integer expectedClassroomSize = 4;
        classroom.checkIfStudentIsB();
        Integer actualSize = classroom.getLetterGradeB().size();
        Integer expectedSize = 1;
        LOGGER.info("\n" + actualSize);
        Assert.assertEquals(expectedClassroomSize, actualClassroomSize);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void CheckCTest() {
        letterGradeC = new ArrayList<>();
        classroom.addStudent(student4);
        Integer actualClassroomSize = classroom.getStudents().size();
        Integer expectedClassroomSize = 4;
        classroom.checkIfStudentIsC();
        Integer actualSize = classroom.getLetterGradeC().size();
        Integer expectedSize = 0;
        LOGGER.info("\n" + actualSize);
        Assert.assertEquals(expectedClassroomSize, actualClassroomSize);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void CheckDTest() {
        letterGradeD = new ArrayList<>();
        classroom.addStudent(student4);
        Integer actualClassroomSize = classroom.getStudents().size();
        Integer expectedClassroomSize = 4;
        classroom.checkIfStudentIsD();
        Integer actualSize = classroom.getLetterGradeD().size();
        Integer expectedSize = 1;
        LOGGER.info("\n" + actualSize);
        Assert.assertEquals(expectedClassroomSize, actualClassroomSize);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void CheckFTest() {
        letterGradeF = new ArrayList<>();
        classroom.addStudent(student4);
        Integer actualClassroomSize = classroom.getStudents().size();
        Integer expectedClassroomSize = 4;
        classroom.checkIfStudentIsF();
        Integer actualSize = classroom.getLetterGradeF().size();
        Integer expectedSize = 0;
        LOGGER.info("\n" + actualSize);
        Assert.assertEquals(expectedClassroomSize, actualClassroomSize);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void checkGradeBookTest() {
        classroom.addStudent(student4);
        classroom.checkIfStudentIsA();
        classroom.checkIfStudentIsB();
        classroom.checkIfStudentIsC();
        classroom.checkIfStudentIsD();
        classroom.checkIfStudentIsF();
        classroom.getGradeBook();
        for (Map.Entry<String, ArrayList<Student>> element : classroom.getGradeBook().entrySet()) {
            System.out.println("Grade: " + element.getKey() + " Student(s): " + element.getValue());
        }
        classroom.getGradeBook().entrySet();

        Integer expectedNumberOfAStudents = 2;
        Integer actualNumberOfAStudents = classroom.getLetterGradeA().size();
        Assert.assertEquals(expectedNumberOfAStudents, actualNumberOfAStudents);
    }
}
