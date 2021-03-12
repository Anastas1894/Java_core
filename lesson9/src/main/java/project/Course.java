package project;

public class Course implements ICourse{
    String courseName;

    public Course (String courseName){
        this.courseName = courseName;
    }

    public String getName() {
        return this.courseName;
    }
}
