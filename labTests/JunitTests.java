

import liquibase.exception.LiquibaseException;
import models.Connector;
import models.Main;
import optionshibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import java.sql.SQLException;

public class JunitTests {

    @BeforeClass
    public static void onlyOnce() throws SQLException, ClassNotFoundException, LiquibaseException {
        Connector.connector();
    }

    @AfterClass
    public static void afterTest() throws SQLException, ClassNotFoundException {
        Connector.disconnect();
    }

    @Test
    public void createTablesTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(Main.sessionFactory);
        MethodFaculty methodFaculty = new MethodFaculty(new Configuration().configure().buildSessionFactory());
        System.out.println(methodFaculty.listFaculties().get(0).toString());
    }

    @Test
    public void getObjectsTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        MethodFaculty methodFaculty = new MethodFaculty(new Configuration().configure().buildSessionFactory());
        System.out.println(methodFaculty.listFaculties().get(0).toString());

        MethodStudent methodStudent = new MethodStudent(new Configuration().configure().buildSessionFactory());
        System.out.println(methodStudent.listStudents().get(0).toString());

        MethodStudSubj methodStudSubj = new MethodStudSubj(new Configuration().configure().buildSessionFactory());
        System.out.println(methodStudSubj.listStudSubjs().get(0).toString());

        MethodSubject methodSubject = new MethodSubject(new Configuration().configure().buildSessionFactory());
        System.out.println(methodSubject.listSubject().get(0).toString());

        MethodTeacher methodTeacher = new MethodTeacher(new Configuration().configure().buildSessionFactory());
        System.out.println(methodTeacher.listTeachers().get(0).toString());
    }

    @Test
    public void updateTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        MethodFaculty methodFaculty = new MethodFaculty(new Configuration().configure().buildSessionFactory());
        methodFaculty.updateFaculty(1, "PBF");

        MethodTeacher methodTeacher = new MethodTeacher(new Configuration().configure().buildSessionFactory());
        methodTeacher.updateTeacher(1, "Enekin","Skayvoker");

        MethodStudent methodStudent = new MethodStudent(new Configuration().configure().buildSessionFactory());
        methodStudent.updateStudent(1, "Roma","Riabushkin", 4);

        MethodStudSubj methodStudSubj = new MethodStudSubj(new Configuration().configure().buildSessionFactory());
        methodStudSubj.updateStudSubj(1, 3);

        MethodSubject methodSubject = new MethodSubject(new Configuration().configure().buildSessionFactory());
        methodSubject.updateSubject(1, "MSDB", 3);
    }

    @Test
    public void addRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        MethodFaculty methodFaculty = new MethodFaculty(new Configuration().configure().buildSessionFactory());
        methodFaculty.addFaculty(10, "IHF");
        methodFaculty.removeFaculty(10);

        MethodSubject methodSubject = new MethodSubject(new Configuration().configure().buildSessionFactory());
        methodSubject.addSubject(10, "MSDB", 3);
        methodSubject.removeSubject(10);

        MethodStudSubj methodStudSubj = new MethodStudSubj(new Configuration().configure().buildSessionFactory());
        methodStudSubj.addStudSubj(10, 3);
        methodStudSubj.removeStudSubj(10);

        MethodStudent methodStudent = new MethodStudent(new Configuration().configure().buildSessionFactory());
        methodStudent.addStudent(10, "Max", "Shevchuk", 2);
        methodStudent.removeStudent(10);

        MethodTeacher methodTeacher = new MethodTeacher(new Configuration().configure().buildSessionFactory());
        methodTeacher.addTeacher(10, "Enekin","Skayvoker");
        methodTeacher.removeTeacher(10);
    }
}
