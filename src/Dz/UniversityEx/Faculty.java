package Dz.UniversityEx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Faculty {
    private FacultyName facultyName;
    private List<Student> students;
    private List<Department> departments;

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
        this.students = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    /**anyMatch — это метод, используемый в Stream API для проверки, соответствует ли хотя бы один элемент потока заданному условию (предикату).
     */
    public void addStudent(Student student) throws DuplicateStudentException{
        if (students.stream()
                .anyMatch(s -> s.getNumber() == student.getNumber())) {
            throw new DuplicateStudentException("Такой студент уже существует");
        }
        students.add(student);
    }

    /**.average() - вычисляет среднее значение (арифметическое) всех чисел в потоке.Возвращает OptionalDouble (может быть пустым)
     * .orElse(значение) - Достаёт значение из OptionalDouble или даёт запасной вариант
     */
    public double averageGrade() {
        return students.stream()
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0);
    }

    /**Comparator.comparingDouble(...) — это статический метод из класса java.util.Comparator,
     * который используется для создания компараторов (сравнивателей), сравнивающих объекты по значению типа double.
     * В данном случае сравнивает по getAverageGrade(). Он создаёт компаратор — то есть правило для сравнения объектов типа Student.
     * По умолчанию Comparator.comparingDouble(...) сортирует по возрастанию.
     *
     * .reversed() — меняет порядок на убывающий (от большего к меньшему).
     */
    public List<Student> topStudents(int a) {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .limit(a)
                .collect(Collectors.toList());
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name=" + facultyName +
                ", students=" + students +
                ", departments=" + departments +
                '}';
    }
}
