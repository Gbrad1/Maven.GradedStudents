package io.zipcoder;

import org.junit.*;

import java.util.logging.Logger;

public class StudentTest {

    private static final Logger LOGGER = Logger.getLogger(StudentTest.class.getName());

    @Test
    public void setFirstNameTest() {
        Student newStudent = new Student();
        newStudent.setFirstName("Amanda");
        String expected = "Amanda";
        String actual = newStudent.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstNameTest() {
        Student newStudent = new Student();
        newStudent.setFirstName("Amanda");
        String expected = "Amanda";
        String actual = newStudent.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastNameTest() {
        Student newStudent = new Student();
        newStudent.setLastName("Defilippis");
        String expected = "Defilippis";
        String actual = newStudent.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastNameTest() {
        Student newStudent = new Student();
        newStudent.setLastName("Defilippis");
        String expected = "Defilippis";
        String actual = newStudent.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        Student newStudent = new Student();
        int actual = newStudent.getNumberOfExamsTaken();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamsTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getStringVersionOfExamScores();

        // Then
        LOGGER.info("\n" + output);
    }

    @Test
    public void addExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        String output = student.getStringVersionOfExamScores();

        // Then
        LOGGER.info("\n" + output);
    }

    @Test
    public void setExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExistingExamScore(1, 150.0);
        String output = student.getStringVersionOfExamScores();

        // Then
        LOGGER.info("\n" + output);
    }

    @Test
    public void getIndividualAverageExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        double output = student.getAverageExamScore();

        // Then
        LOGGER.info("\n" + output);
    }

    @Test
    public void toStringTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.toString();

        // Then
        LOGGER.info("\n" + output);
    }
}