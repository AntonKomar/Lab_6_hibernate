package optionshibernate;

import models.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MethodFaculty {
    private static SessionFactory sessionFactory;

    public MethodFaculty(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addFaculty(int id, String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Faculty faculty = new Faculty(id, name);
        session.save(faculty);
        transaction.commit();
        session.close();
    }

    public void updateFaculty(int id, String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Faculty faculty = (Faculty) session.get(Faculty.class, id);
        faculty.setName(name);
        session.update(faculty);
        transaction.commit();
        session.close();
    }

    public void removeFaculty(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Faculty faculty = (Faculty) session.get(Faculty.class, id);
        session.delete(faculty);
        transaction.commit();
        session.close();
    }

    public List listFaculties() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List faculties = session.createQuery("FROM faculties").list();

        transaction.commit();
        session.close();
        return faculties;
    }
}
