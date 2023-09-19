package org.example;

import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = HibernateSession.getSessionFactory();
        StudentDAO studentDAO = new StudentDAO(factory);

        Student student1 = new Student(1, "John", "john@mail.com");
        Student student2 = new Student(2, "Chris", "cp3@mail.com");

        studentDAO.addStudent(student1);
        studentDAO.addStudent(student2);

        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }

        Student studentToUpdate = studentDAO.getStudentById(1);
        if (studentToUpdate != null) {
            studentToUpdate.setEmail("updatedl@mail.com");
            studentDAO.updateStudent(studentToUpdate);
        }

        studentDAO.deleteStudent(2);

        factory.close();
    }
}
