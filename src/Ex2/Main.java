package Ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Ксения", 19, 4.4,Faculty.MATH);
        Student student2 = new Student("Олег", 20, 3.9,Faculty.PHYSICS);
        Student student3 = new Student("Ира", 18, 4.1,Faculty.HISTORY);
        Student student4 = new Student("Никита", 21, 4,Faculty.HISTORY);
        Student student5 = new Student("Илья", 23, 3.4,Faculty.PHYSICS);
        Student student6 = new Student("Артем", 22, 4.9,Faculty.MATH);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        List<Student> result1 = students.stream()
                .filter(el -> el.getFaculty() == Faculty.MATH)
                .sorted(Comparator.comparingDouble(Student::getAverageScore).reversed())
                .collect(Collectors.toList());
        System.out.println();

        Map<Faculty, Double> collect = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)
                ));



        List<Student> result3 = students.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageScore).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Задание 3: " +result3);

        Map<Faculty, List<Student>> result4 = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty));
        System.out.println("Задание 4: " + result4);

        Map<Integer, Long> result5 = students.stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        /** Collectors.counting() — вместо списка студентов сразу считаем их количество.
        * В Java количество может быть очень большим, поэтому метод counting() возвращает Long, чтобы избежать переполнения при больших объемах данных.
        */
        System.out.println("Задание 5: " + result5);

        List<Student> result6 = students.stream()
                .filter(el -> el.getAverageScore() > 4.5)
                .collect(Collectors.toList());
        System.out.println("Задание 6: " + result6);

        List<Faculty> result7 = students.stream()
                .max(Comparator.comparingDouble(Student::getAverageScore))
                .map(Student::getFaculty)
                .stream().toList();
        /**Поток студентов завершился на .max(...).
         Далее все операции идут над результатом типа Optional.
         .stream() превращает Optional в Stream.
         .toList() собирает результат в список.
         */
        System.out.println("Задание 7: " + result7);



    }
}
