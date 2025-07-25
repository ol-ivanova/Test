package Dz.UniversityEx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Professor {
    private String name;
    private AcademicDegree degree;
    private List<Professor> professors = new ArrayList<>();

    public Professor(String name, AcademicDegree degree) {
        this.name = name;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public AcademicDegree getDegree() {
        return degree;
    }
    public void addProfessor(Professor p) {
        professors.add(p);
    }

    public List<Professor> getProfessors() {
        return professors;
    }


    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", degree=" + degree +
                '}';
    }
}
