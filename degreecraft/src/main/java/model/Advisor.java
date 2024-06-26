package model;

import java.util.ArrayList;

/**
 * class representing an advisor, extends the User class
 * 
 * @author Ben Thompson
 */
public class Advisor extends User {
    private String office;
    private String officeHours;
    private String phoneNumber;
    private ArrayList<Student> adviseeList = new ArrayList<Student>();
    private String schoolOfFocus;
    private String searchField;
    protected ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    /**
     * Constructs an advisor object with the following attributes.
     * 
     * @param office        The location of the advisor's office
     * @param officeHours   The office hours of the advisor.
     * @param phoneNumber   The advisor's phone number.
     * @param adviseeList   A list of all the students the advisor
     *                      has to advise.
     * @param schoolOfFocus The school the advisor focuses on.
     * @param appointments  A list of all the appointments the advisor
     *                      has available.
     * @param firstName     The first name of the advisor.
     * @param lastName      The last name of the advisor.
     * @param email         The email address of the advisor.
     * @param username      The username of the advisor.
     * @param password      The password of the advisor.
     */
    public Advisor(String office, String officeHours,
            String phoneNumber, ArrayList<Student> adviseeList, String schoolOfFocus,
            ArrayList<Appointment> appointments, String firstName, String lastName,
            String email, String username, String password) {
        super(firstName, lastName, email, username, password, 2);
        this.office = office;
        this.officeHours = officeHours;
        this.phoneNumber = phoneNumber;
        this.adviseeList = adviseeList;
        this.schoolOfFocus = schoolOfFocus;
        this.appointments = appointments;
    }

    /**
     * Constructs a new faculty with a username and password
     * 
     * @param username the facultys username
     * @param password the facultys password
     * @param i 
     * @param string2 
     * @param string 
     */
    public Advisor(String username, String password, String string, String string2, int i) {
        super(username, password, 2);
    }
    // Getters and Setters

    /**
     * Gets the location of where the advisor's office is located.
     * 
     * @return The location of the office.
     */
    public String getOffice() {
        return office;
    }

    /**
     * Sets the location of the advisor's office.
     * 
     * @param office The location of the office.
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * Gets the advisor's office hours.
     * 
     * @return The office hours of the advisor.
     */
    public String getOfficeHours() {
        return officeHours;
    }

    /**
     * Sets the advisor's office hours.
     * 
     * @param officeHours The office hours for the advisor.
     */
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    /**
     * Gets the advisor's phone number.
     * 
     * @return The advisor's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the advisor's phone number.
     * 
     * @param phoneNumber The advisor's phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets a list of all the advisees.
     * 
     * @return The list of all the advisees.
     */
    public ArrayList<Student> getAdviseeList() {
        return adviseeList;
    }

    /**
     * Sets the students into a list of advisees.
     * 
     * @param adviseeList A list of all the students being advised.
     */
    public void setAdviseeList(ArrayList<Student> adviseeList) {
        this.adviseeList = adviseeList;
    }

    /**
     * Gets the school of focus for the advisor.
     * 
     * @return The advisor's school of focus.
     */
    public String getSchoolOfFocus() {
        return schoolOfFocus;
    }

    /**
     * Sets the advisor's school of focus.
     * 
     * @param schoolOfFocus The advisor's school of focus.
     */
    public void setSchoolOfFocus(String schoolOfFocus) {
        this.schoolOfFocus = schoolOfFocus;
    }

    /**
     * Gets a list of all the appointments with the advisor that
     * are available.
     * 
     * @return The available appointments.
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Sets the list of appointments that the advisor has available.
     * 
     * @param appointments The available appointments.
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Lets the advisor view a list of the students they will advise.
     * 
     * @param avisees The list of the advisees.
     */
    public String viewAdvisees() {
        StringBuilder list = new StringBuilder();
        if (adviseeList.isEmpty()) {
            list.append("No advisees found for this advisor.");
        } else {
            list.append("List of Advisees:\n");
            for (Student advisee : adviseeList) {
                list.append("Name: ").append(advisee.getFirstName()).append(" ").append(advisee.getLastName())
                        .append("\n");
                list.append("Email: ").append(advisee.getEmail()).append("\n");
            }
        }
        return list.toString();
    }


    /**
     * Allows the advisor to view all the appointments they have.
     * 
     * @param appointments A list of all their current appointments.
     * @return The current list of appointments.
     */
    public String viewAppointments() {
        StringBuilder list = new StringBuilder();
        if (appointments.isEmpty()) {
            list.append("No Available Appointments");
        } else {
            list.append("List of Available Appointments:\n");
            for (Appointment appointment : appointments) {
                list.append("Time: ").append(appointment.getTime())
                        .append("\n");
                list.append("Location: ").append(appointment.getLocation()).append("\n");
            }
        }
        return list.toString();
    }

    /**
     * Adds a student to the list of advisees.
     * 
     * @param advisees The list of advisees.
     */
    public void addAdvisee(Student advisee) {
        adviseeList.add(advisee);
    }

    /**
     * Allows the advisor to add an appointment to their current list of
     * appointments
     * 
     * @param appointment The appointment the advior wants to add.
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     * Allows a search for a student by their name
     * 
     * @param searchFeild name that is being searched
     * @return Student with matching name
     */
    public String searchByName(String searchFeild) {
        String results = new String();
        for (Student student : adviseeList) {
            if (student.getFirstName().equalsIgnoreCase(searchField)) {
                results = student.viewProfile();
            }
        }
        return results;
    }

    /**
     * Allows a seach for a student by their ID
     * 
     * @param searchFeild ID that is being searched
     * @return Student with matching ID
     */
    public ArrayList<Student> searchByID(String searchFeild) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student student : adviseeList) {
            if (student.getUserID().toString().equals(searchField)) {
                results.add(student);
            }
        }
        return results;
    }

    /**
     * Allows a search for a student by their username
     * 
     * @param searchFeild username that is being searched
     * @return Student with matching username
     */
    public User searchByUserName(String searchField) {
        for (User user : UserList.getInstance().getUsers()) {
            if (user.getUsername() == null) {
                break;
            }
            if (user.getUsername().equalsIgnoreCase(searchField.trim())) {
                return user;
            }
        }
        return null;
    }

    public String toString() {
        return this.username;
    }


    public ArrayList<String> getAppointmentIDS()
    {
        ArrayList<String> IDS = new ArrayList<String>();

        for(Appointment appointment : appointments){
            String curr = appointment.getAppointmentID().toString();
            IDS.add(curr);
        }

        return IDS;
    }
}
