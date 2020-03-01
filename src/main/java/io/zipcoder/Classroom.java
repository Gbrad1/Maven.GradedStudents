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
    private ArrayList<Student> letterGradeA;
    private ArrayList<Student> letterGradeB;
    private ArrayList<Student> letterGradeC;
    private ArrayList<Student> letterGradeD;
    private ArrayList<Student> letterGradeF;


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


    public ArrayList<Student> checkIfStudentIsA() {
        letterGradeA = new ArrayList<>();
        for (Student element : students) {
            if (element.getAverageExamScore() >= 90) {
                letterGradeA.add(element);
            }
        }
        return letterGradeA;
    }

    public ArrayList<Student> checkIfStudentIsB() {
        letterGradeB = new ArrayList<>();
        for (Student element : students) {
            if (element.getAverageExamScore() < 89 && element.getAverageExamScore() >= 71) {
                letterGradeB.add(element);
            }
        }
        return letterGradeB;
    }

    public ArrayList<Student> checkIfStudentIsC() {
        letterGradeC = new ArrayList<>();
        for (Student element : students) {
            if (element.getAverageExamScore() < 70 && element.getAverageExamScore() >= 50) {
                letterGradeC.add(element);
            }
        }
        return letterGradeC;
    }

    public ArrayList<Student> checkIfStudentIsD() {
        letterGradeD = new ArrayList<>();
        for (Student element : students) {
            if (element.getAverageExamScore() < 49 && element.getAverageExamScore() >= 11) {
                letterGradeD.add(element);
            }
        }
        return letterGradeD;
    }

    public ArrayList<Student> checkIfStudentIsF() {
        letterGradeF = new ArrayList<>();
        for (Student element : students) {
            if (element.getAverageExamScore() < 11) {
                letterGradeF.add(element);
            }
        }
        return letterGradeF;
    }

    public TreeMap<String, ArrayList<Student>> getGradeBook() {
        gradeBook = new TreeMap<>();
        gradeBook.put("A", letterGradeA);
        gradeBook.put("B", letterGradeB);
        gradeBook.put("C", letterGradeC);
        gradeBook.put("D", letterGradeD);
        gradeBook.put("F", letterGradeF);

        return gradeBook;
    }

    public ArrayList<Student> getLetterGradeA () {
        return letterGradeA;
    }

    public ArrayList<Student> getLetterGradeB () {
        return letterGradeB;
    }

    public ArrayList<Student> getLetterGradeC () {
        return letterGradeC;
    }

    public ArrayList<Student> getLetterGradeD () {
        return letterGradeD;
    }

    public ArrayList<Student> getLetterGradeF () {
        return letterGradeF;
    }

    public void printGradeBook() {
        System.out.println("hey");
    }
}
