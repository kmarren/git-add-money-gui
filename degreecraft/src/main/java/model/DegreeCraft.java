package model;

import java.util.ArrayList;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

//test 
/**
 * The aplication facade.
 * 
 * @author Kennedy Marren
 */
public class DegreeCraft {
    private Student student;
    private Advisor advisor;
    private Faculty faculty;
    private User user;
    private UserList userList = UserList.getInstance();
    private CourseList courseList = CourseList.getInstance();
    private MajorList majorList = MajorList.getInstance();
    private AppointmentList appointmentList = AppointmentList.getInstance();
    private static DegreeCraft application;
    private Scanner keyboard = new Scanner(System.in);

    /**
     * private constructor that will not allow other classes to create a new
     * applicatoin
     */
    private DegreeCraft() {

    }

    /**
     * creates an application if there is not one or returns the application if
     * there is one
     * 
     * @return the application
     */
    public static DegreeCraft getInstance() {
        if (application == null) {
            application = new DegreeCraft();
        }
        return application;
    }

    public void loadAll() {
        userList.loadAll();
        majorList.loadAll();
        appointmentList.loadAll();
        courseList.loadAll();
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    /**
     * takes in the a username and password and returns the user that is trying to
     * login
     * 
     * @param username the username attempt
     * @param password the password attempt
     * @return the user who was logged in
     */
    public void login(String username, String password) // returns void, sets current user to the user who just logged
                                                        // in
    {
        if (userList.login(username, password)) {
            user = userList.getUser(username, password);
            System.out.println("Accepted");
        } else
            System.out.println("Rejected. Please Try Again.");
    }

    public boolean canLogin(String username, String password) {
        if (userList.login(username, password))
            return true;
        else
            return false;
    }

    public boolean canLoginOrSignUp(String choice) {
        if (choice.equalsIgnoreCase("login") || choice.equalsIgnoreCase("sign up")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * takes in a username and password to create a new user with the corresponding
     * username and password
     * 
     * @param username the username given to create the new account
     * @param password the password given to create the new account
     * @return the new user
     */
    public void signUp(String username, String password, String accountType) // returns void, sets current user to the
                                                                             // new user
    {
        if (accountType.equalsIgnoreCase("faculty")) {
            Faculty faculty = new Faculty(username, password);
            UserList.getInstance().addUser(faculty);
            user = faculty;
        } else if (accountType.equalsIgnoreCase("advisor")) {
            // Advisor advisor = new Advisor(username, password);
            // FIX THIS LATER!!!!!
            Advisor advisor = new Advisor(username, password, accountType, accountType, 0);
            UserList.getInstance().addUser(advisor);
            user = advisor;
        } else {
            Student student = new Student(username, password);
            UserList.getInstance().addUser(student);
            user = student;
        }
    }

    public void createSpecificTypes() {
        if (user.getType() == 1) {
            student = (Student) user;
        }

        else if (user.getType() == 2) {
            advisor = (Advisor) user;
        }

        else if (user.getType() == 3) {
            faculty = (Faculty) user;
        }
    }

    public String listCompletedCourses() {
        return student.getCompletedCourses().toString();
    }

    public String listCompletedCourses(Student aStudent) {
        return aStudent.getCompletedCourses().toString();
    }

    public ArrayList<Course> listFutureCourses() {
        return student.getFutureCourses();
    }

    public ArrayList<Course> listFutureCourses(Student aStudent) {
        return aStudent.getFutureCourses();
    }

    public int getUserType() {
        return user.getType();
    }

    public String searchForStudentByUsername(String searchField) {
        User searchedUser = advisor.searchByUserName(searchField.trim());
        System.out.println("Searched Username: " + searchField.trim());

        if (searchedUser == null) {
            return "Could Not Find User";
        } else {
            System.out.println("Found User: " + searchedUser.getUsername());
            if (searchedUser instanceof Student) {
                advisor.addAdvisee((Student) searchedUser);
                ((Student) searchedUser).setAdvisor(advisor);
                return viewStudentProfile((Student) searchedUser);
            } else {
                return "User is not a student";
            }
        }
    }

    public String viewSpecificStudentInfo(Student student) {
        StringBuilder info = new StringBuilder();

        ArrayList<Course> enrolledClasses = student.getEnrolledCourses();
        ArrayList<Course> completedClasses = student.getCompletedCourses();

        info.append("Enrolled Classes:\n");
        for (Course enrolledClass : enrolledClasses) {
            info.append(enrolledClass.getCourseName()).append("\n");
        }

        info.append("\nCompleted Classes:\n");
        for (Course completedClass : completedClasses) {
            info.append(completedClass.getCourseName()).append(" - Grade: ").append(completedClass.getGrade())
                    .append("\n");
        }

        return info.toString();
    }

    public String viewSpecificStudentInfo() {
        StringBuilder info = new StringBuilder();

        ArrayList<Course> enrolledClasses = student.getEnrolledCourses();
        ArrayList<Course> completedClasses = student.getCompletedCourses();

        info.append("Enrolled Classes:\n");
        for (Course enrolledClass : enrolledClasses) {
            info.append(enrolledClass.getCourseName()).append("\n");
        }

        info.append("\nCompleted Classes:\n");
        for (Course completedClass : completedClasses) {
            info.append(completedClass.getCourseName()).append(" - Grade: ").append(completedClass.getGrade())
                    .append("\n");
        }

        return info.toString();
    }

    public String viewStudentFutureCourses() {
        StringBuilder info = new StringBuilder();

        ArrayList<Course> futureCourses = student.getFutureCourses();

        info.append("Future Courses:\n");
        for (Course course : futureCourses) {
            info.append(course.getCourseName()).append("\n");
        }
        return info.toString();
    }

    public String viewNeededCC()
    {
        return student.neededRequirements();
    }

    public void writeStudentComment(Student student, String comment) {
        student.addStudentComment(comment);
    }

    public ArrayList<Course> getCourseList() {
        return courseList.getCourses();
    }

    public ArrayList<User> getUserList() {
        return userList.getUsers();
    }

    public ArrayList<Major> getMajors() {
        return majorList.getMajors();
    }

    /**
     * adds a generalized course to the course
     */
    public void addCourse(Course course) {
        courseList.addCourse(course);
    }

    public User getCurrentUser() {
        return user;
    }

    /**
     * Gets the major map of a specified major
     * 
     * @param major the specified major
     * @return a string of each class within the major's requirements
     */
    public String viewMajorMap(Major major) {
        return " ";
    }

    /**
     * Creates a student with all of the student's specified information.
     * 
     * @param gpa             The GPA of the student.
     * @param minor           Whether the student has a minor.
     * @param studentComments Comments given to a student by an advisor.
     * @param enrolledCourses Courses in which the student is enrolled.
     * @param achievements    Achievements earned by the student (scholarships etc.)
     * @param advisor         The advisor assigned to the student.
     * @param riskFailing     Whether the student is at risk of failing.
     * @param studentID       The ID of the student.
     * @param firstName       The first name of the student.
     * @param lastName        The last name of the student.
     * @param email           The email address of the student.
     * @param username        The username of the student.
     * @param password        The password of the student.
     * @param major           The mojor of the student.
     */
    public void addStudent(double gpa, boolean minor, ArrayList<String> studentComments,
            ArrayList<Achievement> achievements, Advisor advisor, boolean riskFailing,
            String firstName, String lastName, String email, String username, String password, Major major,
            ArrayList<Course> enrolledCourses, ArrayList<Course> completedCourses) {
        Student student = new Student(gpa, minor, studentComments,
                achievements, advisor, riskFailing, firstName, lastName,
                email, username, password, major, enrolledCourses, completedCourses);
        userList.addUser(student);
    }

    /**
     * Creates an advisor with all of the advisor's specified information.
     * 
     * @param advisorId     The ID of the advisor.
     * @param office        The location of the advisor's office
     * @param officeHours   The office hours of the advisor.
     * @param phoneNumber   The advisor's phone number.
     * @param adviseeList   A list of all the students the advisor has to advise.
     * @param schoolOfFocus The school the advisor focuses on.
     * @param appointments  A list of all the appointments the advisor has
     *                      available.
     * @param firstName     The first name of the advisor.
     * @param lastName      The last name of the advisor.
     * @param email         The email address of the advisor.
     * @param username      The username of the advisor.
     * @param password      The password of the advisor.
     */
    public void addAdvisor(String office, String officeHours,
            String phoneNumber, ArrayList<Student> adviseeList, String schoolOfFocus,
            ArrayList<Appointment> appointments, String firstName, String lastName,
            String email, String username, String password) {
        Advisor advisor = new Advisor(office, officeHours, phoneNumber, adviseeList, schoolOfFocus, appointments,
                firstName, lastName, email, username, password);
        UserList.getInstance().addUser(advisor);
    }

    /**
     * Creates a new faculty member.
     * 
     * @param officeHours The office hours of the faculty member.
     * @param studentList The student list of the faculty member.
     * @param firstName   The first name of the faculty member
     * @param lastName    The last name of the faculty member
     * @param email       The email of the faculty member
     * @param username    The username of the faculty member
     * @param password    The password of the faculty member
     */
    public void addFaculty(String officeHours, ArrayList<Student> studentList,
            String firstName, String lastName, String email, String username, String password) {
        Faculty faculty = new Faculty(officeHours, studentList, firstName, lastName, email, username, password);
        UserList.getInstance().addUser(faculty);
    }

    /**
     * Takes in a search field from the user and returns a list of related coursed
     * 
     * @param keyword the name, number, or code of the course, or something similar
     * @return a list of courses that contain the keyword in their information
     */
    /*
     * public ArrayList<Course> findCourse(String keyword) {
        ArrayList<Course> courseList = new ArrayList<Course>();
        return courseList;
    }
     */
    

    /**
     * Allows a student to book an appointment with their advisor based on the time,
     * location, and advisor they enter
     * 
     * @param time     the time of the appointment
     * @param location where the appointment will take place
     * @param advisor  the students assigned advisor
     */
    public void bookAppointment(Student student, String time, String location, Advisor advisor) {
        Appointment appointment = new Appointment(student, time, location);
        advisor.addAppointment(appointment);
    }

    /**
     * Allows a student to view their degree path if they were to change their major
     * 
     * @param newMajor the major the student wishes to view for a potential major
     *                 change
     * @return the major map of the new major with the students specific information
     *         and completed classes included
     */
    public String viewWhatIf(Major newMajor) {
        return " ";
    }

    /**
     * Allows the student to
     * 
     * @param student the student the advisor wishes to send the comment to
     * @param comment the comment the advisor wishes to send
     */
    public void sendStudentComment(Student student, String comment) {
        ArrayList<String> comments = student.getStudentComments();
        comments.add(comment);
        student.setStudentComments(comments);
    }

    /**
     * Adds an achievement to the students list of achievements
     * 
     * @param achievement the achievement being added to the students list
     * @return A string representation of the advisor's list of advisees.
     */
    public void addAchievement(Achievement achievement) {

    }

    /**
     * Gets the advisors list of advisees
     */
    public String viewAdvisees(Advisor advisor) {
        StringBuilder result = new StringBuilder();
        ArrayList<Student> advisees = advisor.getAdviseeList();

        if (advisees.isEmpty()) {
            result.append("No advisees.");
        } else {
            result.append("Advisees:\n");
            for (Student student : advisees) {
                result.append(student.getFirstName()).append(" ").append(student.getLastName()).append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Returns the current students information
     * 
     * @return the students information
     */
    public String viewStudentProfile() {
        return student.viewProfile();
    }

    public String viewCompletedCourseInfo() {
        return student.viewCompletedCourseInfo();
    }

    /**
     * Returns the current students information
     * 
     * @return the students information
     */
    public String viewStudentProfile(Student aStudent) {
        return aStudent.viewProfile();
    }

    /**
     * Retrieves an advisors list of available appointments
     * 
     * @return the advisors available appointments
     */
    public ArrayList<Appointment> getAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        return appointments;
    }

    /**
     * Allows an advisor to add a student to their list of advisees
     * 
     * @param advisor The advisor to whom the student will be added as an advisee.
     * @param student the student to be added to the list
     */
    public void addAdvisee(Advisor advisor, Student student) {
        advisor.addAdvisee(student);
    }

    /**
     * Allows an advisor to add an appointment to their list of available
     * appointments
     * 
     * @param advisor  the advisor whose list of appointments will be added to
     * @param time     the time of the new appointment
     * @param location the location of the new appointment
     * @return whether or not the new appointment is added successfully
     */
    public boolean addAppointment(Advisor advisor, String time, String location) {
        return true;
    }

    /**
     * takes in a course and returns the information about the course
     * 
     * @param course the course's information to be viewed
     */
    public String viewCourse(Course course) {
        return course.toString();
    }

    /*
     * logs the user out and saves all of th4e data to JSON
     * ***MAKE SURE TO EVENTUALLY CHANGE THE NAME OF THE FILES THE SAVED DATA PRINTS
     * TO***
     */
    public void logout() {
        DataWriter.parseUserList();
        DataWriter.writeUsers();
        DataWriter.writeCourses();
        DataWriter.writeMajors();
        DataWriter.writeFaculty();
        DataWriter.writeAdvisors();
        DataWriter.writeStudents();
        DataWriter.writeAllID();
    }


    
     public String viewApplicationAreas() {
        StringBuilder areas = new StringBuilder();
       
        areas.append("1. Science").append("\n");
        areas.append("2. Math").append("\n");
        areas.append("3. Robotics").append("\n");
        areas.append("4. Digital Design").append("\n");
        areas.append("5. Speech").append("\n");

        return areas.toString();
    }

    public void executeApplicationArea(int choice) {
        switch (choice) {
            case 1: //science
                System.out.println("Description:\n Students will explore a variety of lab sciences including Biology, Chemistry, and Physics.");
                System.out.println("Compatable Courses:\n BIOL 101\n BIOL 102\n CHEM 111\n CHEM 112\n PHYS 111\n PHYS 112");
                String word = keyboard.nextLine();
                student.chooseCourse(student.findCourse(word));
                break;
            case 2: //math
                System.out.println("Description:\n Students interested in the physical -- as well as cognitive or algorithmic -- aspects of robots will benefit from these courses.");
                System.out.println("Compatable Courses:\n CSCE 574\n CSCE 580\n EMCH 535\n ELCT 332\n ELCT 531");
                String wordA = keyboard.nextLine();
                student.chooseCourse(student.findCourse(wordA));
                break;
            case 3: //robotics
                System.out.println("Description:\n Provides students with basic abilities in linear and abstract algebra as well as a broad introduction to topics such as logic, set theory, functions and fundamental methods of mathematical proof.");
                System.out.println("Compatable Courses:\n MATH 242\n MATH 300\n MATH 344\n MATH 374\n MATH 511");
                String wordB = keyboard.nextLine();
                student.chooseCourse(student.findCourse(wordB));
                break;
            case 4: //digital design
                System.out.println("Description:\n Prepares students to work in modern media production through hands-on experience and an understanding of how successful media works.");
                System.out.println("Compatable Courses:\n DGDN 244\n DGDN 245\n DGDN 311\n ");
                String wordC = keyboard.nextLine();
                student.chooseCourse(student.findCourse(wordC));
                break;
            case 5: //speech
                System.out.println("Description:\n Students will learn about speech is the workplace and public speaking.");
                System.out.println("Compatable Courses:\n SPCH 300\n SPCH 350\n SPCH 376\n ");
                String wordD = keyboard.nextLine();
                student.chooseCourse(student.findCourse(wordD));
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }

    public String searchForCCCourses(String searchfield)
    {
        return student.searchForCC(searchfield);
    }

    public Course findCourse(String name)
    {
        return CourseList.getInstance().getCourseByCourseName(name);
    }

    public void addCourseToFuture(Course course)
    {
        student.chooseCourse(course);
    }

   
    public int getCurrentSemester()
    {
        return student.findCurrentSemester();
    }

    public ArrayList<Course> eightSemesterPlanGen()
    {
        return student.getCourses();
    }
    
    


}
