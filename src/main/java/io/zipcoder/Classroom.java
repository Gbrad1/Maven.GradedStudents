package io.zipcoder;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class Classroom {
    private static final Logger LOGGER = Logger.getLogger(Classroom.class.getName());
    private Student[] students;
    private int maxNumberOfStudents;

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        students = new Student[30];
    }

    public Classroom(int maxStudents) {
        students = new Student[maxStudents];
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
        for (Student index : students) {
            sum += index.getAverageExamScore();
        }
        double average = sum / students.length;
        return average;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length - 1; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }


    public void removeStudent(String firstName, String lastName) {
        Student toRemove;
        ArrayList<Student> temp = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            temp.add(students[i]);
        }

        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getFirstName().equals(firstName) && temp.get(i).getLastName().equals(lastName)) {
                toRemove = null;
            }
        }
    }
}
