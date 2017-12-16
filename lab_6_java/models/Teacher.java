package models;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private String teachName;
    private String teachSname;
    private int id;

    public static List<Teacher> teachers = new ArrayList<>();

    public Teacher() { }

    public Teacher(int id, String Name, String SName) {
        this.id = id;
        this.teachName = Name;
        this.teachSname = SName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTeachName(String firstName) {
        this.teachName = firstName;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setSName(String SName) {
        this.teachSname = SName;
    }

    public String getSName() {
        return teachSname;
    }
}
