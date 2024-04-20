package model;

import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList() {
        courses = new ArrayList<>();
        try {
            ArrayList<Course> crs = DataLoader.loadCourses();
            courses.addAll(crs);
        } catch (Exception e) {
            System.err.println("Error while loading courses: " + e.getMessage());
        }
    }

    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Course> getCourse(String courseName) {
        ArrayList<Course> foundCourses = new ArrayList<>();
        try {
            if (courseName != null) {
                for (Course course : courses) {
                    if (course.getCourseName().equals(courseName)) {
                        foundCourses.add(course);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while getting courses by name: " + e.getMessage());
        }
        return foundCourses;
    }

    public Course getCourseByUUID(UUID courseID) {
        try {
            if (courseID != null && courseID instanceof UUID) {
                for (Course course : courses) {
                    if (course.getCourseID().equals(courseID.toString())) {
                        return course;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while getting course by UUID: " + e.getMessage());
        }
        return null;
    }

    public Course getCourseByCourseName(String courseName) {
        try {
            if (courseName != null) {
                for (Course course : courses) {
                    if (course.getCourseName().equalsIgnoreCase(courseName)) {
                        return course;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while getting course by name: " + e.getMessage());
        }
        return null;
    }

    public void addCourse(Course course) {
        try {
            if (course != null && course instanceof Course) {
                courses.add(course);
            }
        } catch (NullPointerException e) {
            System.err.println("Error while adding course: " + e.getMessage());
        }
    }

    public void loadAll() {
        try {
            DataLoader.finishCourses(courses);
        } catch (Exception e) {
            System.err.println("Error while loading all courses: " + e.getMessage());
        }
    }

    public void removeCourse(Course course) {
        try {
            if (course != null && course instanceof Course) {
                courses.remove(course);
            }
        } catch (NullPointerException e) {
            System.err.println("Error while removing course: " + e.getMessage());
        }
    }

    public void clear() {
        try {
            if (!courses.isEmpty()) {
                courses.clear();
            }
        } catch (Exception e) {
            System.err.println("Error while clearing courses: " + e.getMessage());
        }
    }
}
