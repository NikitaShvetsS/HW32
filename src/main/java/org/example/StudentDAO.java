package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {

    private final SessionFactory factory;

    public StudentDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public void addStudent(Student student) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    public void updateStudent(Student student) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        }
    }

    public void deleteStudent(int id) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        }
    }

    public Student getStudentById(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Student.class, id);
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }
}
