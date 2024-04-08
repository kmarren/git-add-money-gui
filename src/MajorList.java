package src;

import java.util.ArrayList;
import java.util.UUID;

public class MajorList {
    private static MajorList majorList;
    private ArrayList<Major> majors;

    private MajorList() {
        majors = new ArrayList<>();
        try {
            ArrayList<Major> mjr = DataLoader.loadMajors();
            majors.addAll(mjr);
        } catch (Exception e) {
            System.err.println("Error while loading majors: " + e.getMessage());
        }
    }

    public static MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;
    }

    public ArrayList<Major> getMajors() {
        return majors;
    }

    public Major getMajorID(String majorID) {
        try {
            if (majorID != null) {
                for (Major major : majors) {
                    if (major.getMajorID().equals(majorID)) {
                        return major;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while getting major by ID: " + e.getMessage());
        }
        return null;
    }

    public Major getMajorID(UUID majorID) {
        try {
            if (majorID != null && majorID instanceof UUID) {
                for (Major major : majors) {
                    if (UUID.fromString(major.getMajorID()).equals(majorID)) {
                        return major;
                    }
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error while getting major by ID: " + e.getMessage());
        }
        return null;
    }

    public void addMajor(Major major) {
        try {
            if (major instanceof Major && major != null) {
                majors.add(major);
            }
        } catch (NullPointerException e) {
            System.err.println("Error while adding major: " + e.getMessage());
        }
    }

    public void removeMajor(String uuid) {
        try {
            if (uuid != null) {
                for (Major major : majors) {
                    if (major.getMajorID().equals(uuid)) {
                        majors.remove(major);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while removing major: " + e.getMessage());
        }
    }

    public void removeMajor(UUID uuid) {
        try {
            if (uuid != null && uuid instanceof UUID) {
                for (Major major : majors) {
                    if (UUID.fromString(major.getMajorID()).equals(uuid)) {
                        majors.remove(major);
                    }
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error while removing major: " + e.getMessage());
        }
    }

    public void loadAll() {
        try {
            DataLoader.finishMajors(majors);
        } catch (Exception e) {
            System.err.println("Error while finishing majors: " + e.getMessage());
        }
    }

    public void clear() {
        try {
            if (!majors.isEmpty()) {
                majors.clear();
            }
        } catch (Exception e) {
            System.err.println("Error while clearing majors: " + e.getMessage());
        }
    }
}
