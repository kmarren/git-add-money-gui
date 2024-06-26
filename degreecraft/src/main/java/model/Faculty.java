package model;
import java.util.ArrayList;
/**
 * setting up faculty class
 * @author Kennedy Marren
 */
public class Faculty extends User
{
    private String officeHours;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    /**
     * Constructs a new faculty object with office hours and a list of students
     * @param officeHours The office hours of the faculty member.
     * @param studentList The student list of the faculty member.
     * @param firstName The first name of the faculty member
     * @param lastName The last name of the faculty member
     * @param email The email of the faculty member
     * @param username The username of the faculty member
     * @param password The password of the faculty member
     */
    public Faculty(String officeHours, ArrayList<Student> studentList, 
    String firstName, String lastName, String email, String username, String password)
    {
        super(firstName, lastName, email, username, password, 3);
        this.officeHours = officeHours;
        this.studentList = studentList;
    }

    /**
     * Constructs a new faculty with a username and password
     * @param username the facultys username
     * @param password the facultys password
     */
    public Faculty(String username, String password)
    {
        super(username, password, 3);
    }

    // getters and setters

    /**
     * Gets the office hours of the faculty member
     * @return The faculty member's office hours
     */
    public String getOfficeHours() {
        return officeHours;
    }
    /**
     * Sets the faculty member's office hours.
     * 
     * @param officeHours The faculty's office hours.
     */
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    /**
     * Gets the faculty member's assigned list of students
     * @return The faculty's list of students
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    /**
     * Sets the faculty members assigned list of students
     * @param studentList The faculty's list of students.
     */
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Adds a student to a faculty member's list of students.
     * @param student the student who will be added.
     */
    public void addStudent(Student student)
    {
        studentList.add(student);
    }

    public String toString()
    {
        return getFirstName() + " " + getLastName();
    }
}
