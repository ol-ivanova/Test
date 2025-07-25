package Ex2;

public class Student {
    private String name;
    private int age;
    private double averageScore;
    private Faculty faculty;

    public Student(String name, int age, double averageScore, Faculty faculty) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return  name + " " +  age + " " +
                averageScore + " " +
               faculty;
    }
}
