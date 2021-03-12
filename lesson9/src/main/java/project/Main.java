package project;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<Course>(Arrays.asList(
                new Course("тестирование"),
                new Course("java"),
                new Course("java core"),
                new Course("linux"),
                new Course("python"),
                new Course("автоматизация тестирования"),
                new Course("HTML/CSS")
        ));

        List<Person> persons = new ArrayList<Person>(Arrays.asList(
                new Person("Alex", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(1)))),
                new Person("Kate", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(1),
                        courses.get(2), courses.get(3)))),
                new Person("Dilan", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(2),
                        courses.get(4)))),
                new Person("Kurt", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(1),
                        courses.get(5), courses.get(3)))),
                new Person("Lili", new ArrayList<Course>(Arrays.asList(courses.get(0), courses.get(1),
                        courses.get(2), courses.get(6))))
        ));

//        1 function
        List<String> studentCourses = persons.stream()
                .flatMap(person -> person.getAllCourses().stream().map(course -> course.courseName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(studentCourses);

        System.out.println("~~~~~~~~~~~~~~~~~~");

//        2 function
        List<String> goodStudent = persons.stream()
                .sorted(Comparator.comparing(Person::getLenghtCourse).reversed())
                .map(person -> person.getName())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println((goodStudent));

        System.out.println("~~~~~~~~~~~~~~~~~~");

//         3 function

        List<String> visitToCourse = persons.stream()
                .filter(person -> person.getAllCourses().contains(courses.get(1)))
                .map(person -> person.getName())
                .collect(Collectors.toList());
        System.out.println(visitToCourse);


    }

}


