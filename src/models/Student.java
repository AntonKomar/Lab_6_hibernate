package models;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String sName;
    private int id;
    private int faculID;

    public static List<Student> students = new ArrayList<>();

    public Student() { }

    public Student(int id, String Name, String SName, int fac_id) {
        this.id = id;
        this.name = Name;
        this.sName = SName;
        this.faculID = fac_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFaculID(int f){
        this.faculID = f;
    }

    public int getFacid(){
        return faculID;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getName() {
        return name;
    }

    public void setSName(String SName) {
        this.sName = SName;
    }

    public String getSName() {
        return sName;
    }
}

