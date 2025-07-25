package Example1;

import java.util.List;

public class Employee {
    private String name;
    private int salary;
    private List<Project> projects;

    public Employee(String name, int salary, List<Project> projects) {
        this.name = name;
        this.salary = salary;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }


    public List<Project> getProjects() {
        return projects;
    }

}
