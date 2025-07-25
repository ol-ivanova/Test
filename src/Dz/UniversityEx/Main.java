package Dz.UniversityEx;

public class Main {
    public static void main(String[] args) throws DuplicateStudentException, CourseFullException {
        University university = new University();

        Faculty mathFaculty = new Faculty(FacultyName.MATHEMATICS);
        Faculty historyFaculty = new Faculty(FacultyName.HISTORY);
        university.addFaculty(mathFaculty);
        university.addFaculty(historyFaculty);

        Department mathDept = new Department("Алгебра");
        Department historyDept = new Department("История");
        mathFaculty.getDepartments().add(mathDept);
        historyFaculty.getDepartments().add(historyDept);

        Professor prof1 = new Professor("Елена Викторовна", AcademicDegree.PHD);
        Professor prof2 = new Professor("Валентин Юрьевич", AcademicDegree.MASTER);
        Professor prof3 = new Professor("Ирина Геннадьевна", AcademicDegree.PHD);
        mathDept.getProfessors().add(prof1);
        mathDept.getProfessors().add(prof2);
        historyDept.getProfessors().add(prof3);

        Student s1 = new Student("Артём", 1, 3.7);
        Student s2 = new Student("Вика", 2, 5.0);
        Student s3 = new Student("Соня", 3, 2.8);
        Student s4 = new Student("Дима", 4, 3.1);
        Student s5 = new Student("Ника", 5, 4.9);

        mathFaculty.addStudent(s1);
        mathFaculty.addStudent(s2);
        historyFaculty.addStudent(s3);
        historyFaculty.addStudent(s4);
        historyFaculty.addStudent(s5);

        System.out.println(mathDept);
        try {
            mathFaculty.addStudent(new Student("Алиса", 1, 4.6)); // такой студент уже есть
        } catch (DuplicateStudentException e) {
            System.out.println(e.getMessage());
        }

        //Все профессоры со степенью PHD
        System.out.println("Профессора с PhD:");
        university.findPhDProfessors().forEach(p ->
                System.out.println(" - " + p.getName() + ", " + p.getDegree()));

        //Средний балл по факультетам
        System.out.println("Средний балл по факультетам:");
        university.avgGrades().forEach((faculty, avg) ->
                System.out.println(faculty + ": " + avg));

        //Бюджет
        System.out.println("Бюджет:");
        university.budget(10000);

        //Топ-3 студента на каждом факультете
        System.out.println("Топ-3 студента по факультетам:");
        university.topStudents1().forEach((faculty, students) -> {
            System.out.println("Факультет: " + faculty);
            students.forEach(s -> System.out.println(" - " + s.getName() + ", балл: " + s.getAverageGrade()));
        });
    }
}
