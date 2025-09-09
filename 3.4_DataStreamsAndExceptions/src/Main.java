
import java.io.*;

class Student implements Serializable {

    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

class Course implements Serializable {

    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}

class Enrollment implements Serializable {

    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}

public class Main {

    private final static String FILENAME = "enrollments.ser";

    public static void main(String[] args) {
        // Sample
        Student student = new Student(1, "Veijo", 21);
        Course course = new Course("TX00EY21-3009", "Olio-ohjelmointi", "Matti");
        Enrollment enrollment = new Enrollment(student, course, "2025-08-18");

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(enrollment);
            System.out.println(FILENAME);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialize 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            Enrollment loaded = (Enrollment) ois.readObject();
            System.out.println("Deserialized Enrollment:");
            System.out.println("Student: " + loaded.getStudent().getName());
            System.out.println("Course: " + loaded.getCourse().getCourseName());
            System.out.println("Date: " + loaded.getEnrollmentDate());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
