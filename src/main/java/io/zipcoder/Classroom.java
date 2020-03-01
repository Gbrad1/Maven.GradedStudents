package io.zipcoder;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.logging.Logger;

public class Classroom {
    private static final Logger LOGGER = Logger.getLogger(Classroom.class.getName());
    private ArrayList<Student> students;
    private int maxNumberOfStudents;
    private TreeMap<String, ArrayList<Student>> gradeBook;
    private ArrayList<Student> letterGrade;

    public Classroom(ArrayList<Student> students) {
        this.students = students;
    }

    public Classroom() {
        students = new ArrayList<>();
    }

    public Classroom(int maxStudents) {
        students = new ArrayList<>(30);
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                       *
     *                     Methods                           *
     *                                                       *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    public ArrayList<Student> getStudents() {
        return students;
    }

    public double getAverageClassroomExamScore() {
        double sum = 0;
        for (Student index : students) {
            sum += index.getAverageExamScore();
        }
        double average = sum / students.size();
        return average;
    }

    public void addStudent(Student student) {
        students.add(student);
    }


    public void removeStudent(String firstName, String lastName) {
        for (Student element : students) {
            if (element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)) {
                students.remove(element);
                break;
            }
        }
    }

    public void getStudentsByScore() {
        Collections.sort(students);

    }

    public void determineLetterGrade() {
        for (Student element : students) {
            if (element.getAverageExamScore()) {

            }
        }
    }

    public TreeMap<String, ArrayList<Student>> getGradeBook() {
        gradeBook = new TreeMap<>();
        letterGrade = new ArrayList<>();
        for (Student element : students) {
            if (element.getAverageExamScore() >= 90) {
                letterGrade.add(element);
                gradeBook.put("A", letterGrade);
            } else if (element.getAverageExamScore() < 89 && element.getAverageExamScore() >= 71) {
                gradeBook.put("B", letterGrade);
            } else if (element.getAverageExamScore() < 70 && element.getAverageExamScore() >= 50) {
                gradeBook.put("C", letterGrade);
            } else if (element.getAverageExamScore() < 49 && element.getAverageExamScore() > 11) {
                gradeBook.put("D", letterGrade);
            } else {
                gradeBook.put("F", letterGrade);
            }
        }
        return gradeBook;
    }


    public void printGradeBook() {
        System.out.println("hey");
    }
}
