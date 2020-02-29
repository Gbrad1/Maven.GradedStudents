package io.zipcoder;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Classroom {
    private Student[] students;
    private int maxNumberOfStudents;

    private static final Logger LOGGER = Logger.getLogger(Classroom.class.getName());

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
        int i = 0;
        Student[] newStudent = new Student[students.length + 1];
        for (Student element : students) {
            newStudent[i] = element;
            i++;
        }
        newStudent[newStudent.length - 1] = student;
        students = newStudent;
    }

    /*public void printNewStudent() {
        String nameToPrint = "";
        for (int i = 0; i < students.length; i++) {
            nameToPrint += students[i];
        }

    }*/

    public void removeStudent(String firstName, String lastName) {
        int i = 0;
        Student[] newStudentList = new Student[students.length];
        for (Student e : students) {
            if (e.getFirstName().equals(firstName)) {
                if (e.getLastName().equals(lastName)) {
                    i++;
                    continue;
                } else {
                    newStudentList[i] = e;
                    i++;
                }
            } else {
                newStudentList[i] = e;
                i++;
            }
        }
        students = newStudentList;
    }
}
