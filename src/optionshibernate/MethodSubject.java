package optionshibernate;

import models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MethodSubject {
    private static SessionFactory sessionFactory;

    public MethodSubject(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addSubject(int id, String Name, int teach_id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Subject subject = new Subject(id, Name, teach_id);
        session.save(subject);
        transaction.commit();
        session.close();
    }

    public void updateSubject(int id, String Name, int teach_id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Subject subject = (Subject) session.get(Subject.class, id);
        subject.setName(Name);
        subject.setTeachId(teach_id);
        session.update(subject);
        transaction.commit();
        session.close();
    }

    public void removeSubject(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Subject subject = (Subject) session.get(Subject.class, id);
        session.delete(subject);
        transaction.commit();
        session.close();
    }

    public List listSubject() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List subjects = session.createQuery("FROM subjects").list();

        transaction.commit();
        session.close();
        return subjects;
    }
}
