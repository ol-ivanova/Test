package Dz.UniversityEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class University {
    private List<Faculty> faculties;

    public University() {
        faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    /**Collectors.toMap() — это метод из java.util.stream.Collectors, который используется для:
       Преобразования потока объектов в Map<K, V> (отображение ключ–значение).
     */
    //Средний балл по факультетам
    public Map<FacultyName, Double> avgGrades() {
        return faculties.stream()
                .collect(Collectors.toMap(Faculty::getFacultyName, Faculty::averageGrade));
    }
  //Все профессоры со степенью PHD
    public List<Professor> findPhDProfessors() {
        return faculties.stream()
                .flatMap(f -> f.getDepartments().stream())
                .flatMap(d -> d.getProfessors().stream())
                .filter(p -> p.getDegree() == AcademicDegree.PHD)
                .toList();
    }
    //Бюджет
    public void budget(double budget) {
        double sum = budget / faculties.size();
        faculties.forEach(f -> System.out.println(f.getFacultyName() + " получил " + sum));
    }

    public Map<FacultyName, List<Student>> topStudents1() {
        return faculties.stream()
                .collect(Collectors.toMap(Faculty::getFacultyName, f -> f.topStudents(3)));
    }

    @Override
    public String toString() {
        return "University{" +
                "faculties=" + faculties +
                '}';
    }

}
