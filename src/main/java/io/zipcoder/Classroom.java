package io.zipcoder;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Classroom {
    private Student[] students;
    private int maxNumberOfStudents;
    private ArrayList<Double> classroomExamScores = new ArrayList<>();

    private static final Logger LOGGER = Logger.getLogger(Classroom.class.getName());

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        students = new Student[30];
    }

    public Classroom(int maxStudents) {
        this.maxNumberOfStudents = maxStudents;
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                       *
     *                     Methods                           *
     *                                                       *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public Student[] getStudents() {
        return students;
    }

    public double getAverageClassroomExamScore() {
        double sum = 0;
        for (Double index : classroomExamScores) {
            sum += index;
        }

        double average = sum / classroomExamScores.size();
        return average;
    }

    public void getClassroomExamScores() {

        for (Student index : students) {
            classroomExamScores.addAll(index.getExamScores());
        }
    }

}
