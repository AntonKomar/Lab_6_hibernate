package models;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private String name;
    private int id;
    private int teachId;

    public static List<Subject> subjects = new ArrayList<>();

    public Subject() { }

    public Subject(int id, String Name, int teach_id) {
        this.id = id;
        this.name = Name;
        this.teachId = teach_id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getTeachId() {
        return teachId;
    }

    public void setTeachId(int id) {
        this.teachId = teachId;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getName() {
        return name;
    }
}
