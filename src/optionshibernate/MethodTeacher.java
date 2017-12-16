package optionshibernate;

import models.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MethodTeacher {
    private static SessionFactory sessionFactory;

    public MethodTeacher(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTeacher(int id, String Name, String SName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Teacher teacher = new Teacher(id, Name, SName);
        session.save(teacher);
        transaction.commit();
        session.close();
    }

    public void updateTeacher(int id, String Name, String SName) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Teacher teacher = (Teacher) session.get(Teacher.class, id);
        teacher.setTeachName(Name);
        teacher.setSName(SName);
        session.update(teacher);
        transaction.commit();
        session.close();
    }

    public void removeTeacher(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Teacher teacher = (Teacher) session.get(Teacher.class, id);
        session.delete(teacher);
        transaction.commit();
        session.close();
    }

    public List listTeachers() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List teachers = session.createQuery("FROM teachers").list();

        transaction.commit();
        session.close();
        return teachers;
    }
}
