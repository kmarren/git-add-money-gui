package model;

import java.util.ArrayList;
import java.util.UUID;

public class AppointmentList {
    private static AppointmentList instance;
    private ArrayList<Appointment> appointments;

    private AppointmentList() {
        appointments = new ArrayList<>();
        try {
            ArrayList<Appointment> appts = DataLoader.loadAppointments();
            appointments.addAll(appts);
        } catch (Exception e) {
            System.err.println("Error while loading appointments: " + e.getMessage());
        }
    }

    public static AppointmentList getInstance() {
        if (instance == null) {
            instance = new AppointmentList();
        }
        return instance;
    }

    // adds an appointment to the list
    public void addAppointment(Appointment appointment) {
        try {
            if (appointment != null && appointment instanceof Appointment) {
                appointments.add(appointment);
            }
        } catch (NullPointerException e) {
            System.err.println("Error while adding appointment: " + e.getMessage());
        }
    }

    // removes an appointment by its uuid object
    public void removeAppointment(UUID uuid) {
        try {
            if (uuid != null && uuid instanceof UUID) {
                for (Appointment appointment : appointments) {
                    if (appointment.getAppointmentID().equals(uuid)) {
                        appointments.remove(appointment);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while removing appointment: " + e.getMessage());
        }
    }

    // removes an appointment by its string uuid
    public void removeAppointment(String uuid) {
        try {
            if (uuid != null) {
                for (Appointment appointment : appointments) {
                    if (appointment.getAppointmentID().equals(UUID.fromString(uuid))) {
                        appointments.remove(appointment);
                    }
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error while removing appointment: " + e.getMessage());
        }
    }

    // gets an appointment by its uuid object
    public Appointment getAppointment(UUID uuid) {
        try {
            if (uuid != null && uuid instanceof UUID) {
                for (Appointment appointment : appointments) {
                    if (appointment.getAppointmentID().equals(uuid)) {
                        return appointment;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while getting appointment: " + e.getMessage());
        }
        return null;
    }

    // gets an appointment by its string uuid
    public Appointment getAppointment(String uuid) {
        try {
            if (uuid != null) {
                for (Appointment appointment : appointments) {
                    if (appointment.getAppointmentID().equals(UUID.fromString(uuid))) {
                        return appointment;
                    }
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error while getting appointment: " + e.getMessage());
        }
        return null;
    }

    // returns the arraylist of appointments
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    // final touches for the appointmentlist
    public void loadAll() {
        try {
            DataLoader.finishAppointments(appointments);
        } catch (Exception e) {
            System.err.println("Error while finishing appointments: " + e.getMessage());
        }
    }

    // clears the list
    public void clear() {
        try {
            if (!appointments.isEmpty()) {
                appointments.clear();
            }
        } catch (Exception e) {
            System.err.println("Error while clearing appointments: " + e.getMessage());
        }
    }
}
