package Example1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Project project1 = new Project("Проект 1");
        Project project2 = new Project("Проект 2");
        Project project3 = new Project("Проект 3");
        Project project4 = new Project("Проект 4");
        Project project5 = new Project("Проект 5");

        List<Project> projects1 = new ArrayList<>();
        projects1.add(project1);
        projects1.add(project2);

        List<Project> projects2 = new ArrayList<>();
        projects2.add(project4);
        projects2.add(project5);

        List<Project> projects3 = new ArrayList<>();
        projects3.add(project3);

        Employee employee1 = new Employee("Ярослав", 90000, projects3);
        Employee employee2 = new Employee("Алина", 110000, projects2);
        Employee employee3 = new Employee("Ника", 105000, projects1);
        Employee employee4 = new Employee("Ника", 105000, projects2);
        Employee employee5 = new Employee("Ника", 98000, projects3);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        Department department = new Department(employees);

        List<Department> departments = new ArrayList<>();
        departments.add(department);

        List<Project> projectList = departments.stream()
                .flatMap(el -> el.getEmployees().stream())
                .filter(el1 -> el1.getSalary() > 100000)
                .flatMap(el3 -> el3.getProjects().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(projectList);
    }
}
