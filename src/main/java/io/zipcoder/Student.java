package io.zipcoder;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Student implements Comparable<Student>{
    String firstName;
    String lastName;
    ArrayList<Double> examScores;
    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

    public Student(String newFirstName, String newLastName, Double[] testScores) {
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.examScores = new ArrayList<>();
        for (Double element : testScores) {
            examScores.add(element);
        }
    }

    public Student() {
        this(" ", " ", new Double[0]);
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                       *
     *                     Methods                           *
     *                                                       *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public String getStringVersionOfExamScores() {
        String toReturn = "";
        int count = 1;
        for (Double element : examScores) {
            String newString = String.format("%1.0f", element);
            toReturn += "Exam " + count + " -> " + newString + "\n";
        }
        return toReturn;
    }

    public void addExamScore(double newExamScore) {
        examScores.add(newExamScore);
    }

    public void setExistingExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        double sum = 0;
        for (double element : examScores) {
            sum += element;
        }
        double average = sum / examScores.size();
        return (int)average;
    }

    @Override
    public String toString() {
        String toReturn = "Student Name: ";
        toReturn += this.getFirstName() + " " + this.getLastName() + "\n";
        toReturn += " Average Score: " + this.getAverageExamScore() + "\n";
        toReturn += "Exam Scores: \n";
        toReturn += this.getStringVersionOfExamScores();
        LOGGER.info(toReturn);
        return toReturn;
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                     *
     *               getters and setters                   *
     *                                                     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public void setFirstName(String newValue) {
        this.firstName = newValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String newValue) {
        this.lastName = newValue;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public int compareTo(Student otherStudent) {
        int difference = (int)otherStudent.getAverageExamScore() - (int)this.getAverageExamScore();
        if (difference == 0) {
            if (this.getLastName().equals(otherStudent.getLastName())) {
                return this.getFirstName().compareTo(otherStudent.getFirstName());
            }
                return this.getLastName().compareTo(otherStudent.getLastName());
            }   else {
            return difference;
        }
    }
}
