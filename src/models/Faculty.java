
package models;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private String name;
    private int id;

    public static List<Faculty> faculties = new ArrayList<>();

    public Faculty() { }

    public Faculty(int id, String Name) {
        this.id = id;
        this.name = Name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getName() {
        return name;
    }
}
