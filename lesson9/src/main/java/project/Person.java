package project;

import java.util.ArrayList;
import java.util.List;

public class Person implements Student {


    private String name;
    List<Course> listCourse;


    public Person(String name,List<Course> listCourse ) {
        this.name = name;
        this.listCourse = listCourse;

    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.listCourse;
    }

    @Override
    public int getLenghtCourse() {
        return listCourse.size();
    }
}
