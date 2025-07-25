package Dz.UniversityEx;

public class Student {
    private String name;
    private int number;
    private double averageGrade;

    public Student(String name, int number, double averageGrade) {
        this.name = name;
        this.number = number;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
