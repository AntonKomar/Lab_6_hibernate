package optionshibernate;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MethodStudent {
    private static SessionFactory sessionFactory;

    public MethodStudent(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addStudent(int id, String Name, String SName, int fac_id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Student student = new Student(id, Name, SName, fac_id);
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void updateStudent(int id, String Name, String SName, int fac_id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        student.setName(Name);
        student.setSName(SName);
        student.setFaculID(fac_id);
        session.update(student);
        transaction.commit();
        session.close();
    }

    public void removeStudent(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }

    public List listStudents() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List students = session.createQuery("FROM students").list();

        transaction.commit();
        session.close();
        return students;
    }
}
