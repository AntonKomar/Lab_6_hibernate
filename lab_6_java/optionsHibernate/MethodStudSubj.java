package optionsHibernate;

import models.StudentSubject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MethodStudSubj {
    private static SessionFactory sessionFactory;

    public MethodStudSubj(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addStudSubj(int idSt, int idSu) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        StudentSubject studSubj = new StudentSubject(idSt, idSu);
        session.save(studSubj);
        transaction.commit();
        session.close();
    }

    public void updateStudSubj(int idSt, int idSu) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        StudentSubject studSubj = (StudentSubject) session.get(StudentSubject.class, idSt);
        studSubj.setStudId(idSu);
        session.update(studSubj);
        transaction.commit();
        session.close();
    }

    public void removeStudSubj(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        StudentSubject studSubj = (StudentSubject) session.get(StudentSubject.class, id);
        session.delete(studSubj);
        transaction.commit();
        session.close();
    }

    public List listStudSubjs() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List studSubjs = session.createQuery("FROM students_subjects").list();

        transaction.commit();
        session.close();
        return studSubjs;
    }
}
