package Dz.UniversityEx;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Professor> professors;

    public Department(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", professors=" + professors +
                '}';
    }
}
