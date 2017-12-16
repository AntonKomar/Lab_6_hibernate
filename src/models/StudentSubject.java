package models;

import java.util.ArrayList;
import java.util.List;

public class StudentSubject {

    private int stud_id;
    private int subj_id;

    public static List<StudentSubject> StudentSubjects = new ArrayList<>();

    public StudentSubject() { }

    public StudentSubject(int St_id, int Sub_id) {
        this.stud_id = St_id;
        this.subj_id = Sub_id;
    }

    public void setSubjId(int id) {
        this.subj_id = id;
    }

    public int getSubId() {
        return subj_id;
    }

    public void setStudId(int id) {
        this.stud_id = id;
    }

    public int getStudId() {
        return stud_id;
    }
}


