package model;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        users = new ArrayList<>();
        ArrayList<User> advi = DataLoader.loadAdvisors();
        ArrayList<User> fac = DataLoader.loadFaculty();
        ArrayList<User> stud = DataLoader.loadStudents();
        users.addAll(advi);
        users.addAll(fac);
        users.addAll(stud);
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public User getUser(String userName) {
        if (userName == null) {
            return null;
        }
        for (User user : users) {
            if (userName.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String userName, String password) {
        if (userName == null || password == null) {
            return null;
        }
        for (User user : users) {
            if (userName.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        if (user != null) {
            users.add(user);
        }
    }   

    public void removeUser(UUID userID) {
        if (userID == null) {
            return;
        }
        users.removeIf(user -> user.getUserID().equals(userID));
    }

    public boolean login(String userName, String password) {
        return getUser(userName, password) != null;
    }

    public User getUserById(UUID userID) {
        if (userID == null) {
            return null;
        }
        for (User user : users) {
            if (userID.equals(user.getUserID())) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        return students;
    }

    public void loadAll() {
        try {
            DataLoader.finishStudents(users);
            DataLoader.finishAdvisors(users);
            DataLoader.finishFaculty(users);
            System.out.println("All users loaded successfully");
        } catch (Exception e) {
            System.err.println("Failed to finish loading users: " + e.getMessage());
        }
    }

    public void clear() {
        if (!users.isEmpty()) {
            users.clear();
        }
    }

}