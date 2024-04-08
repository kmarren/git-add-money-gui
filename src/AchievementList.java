package src;

import java.util.ArrayList;
import java.util.UUID;

public class AchievementList {
    private static AchievementList instance;
    private ArrayList<Achievement> achievements;

    private AchievementList() {
        achievements = new ArrayList<>();
        try {
            ArrayList<Achievement> ach = DataLoader.loadAchievements();
            achievements.addAll(ach);
        } catch (Exception e) {
            System.err.println("Error while loading achievements: " + e.getMessage());
        }
    }

    public static AchievementList getInstance() {
        if (instance == null) {
            instance = new AchievementList();
        }
        return instance;
    }

    // adds an achievement to the list
    public void addAchievement(Achievement achievement) {
        try {
            if (achievement != null && achievement instanceof Achievement) {
                achievements.add(achievement);
            }
        } catch (NullPointerException e) {
            System.err.println("Error while adding achievement: " + e.getMessage());
        }
    }

    public void removeAchievement(UUID uuid) {
        try {
            if (uuid != null && uuid instanceof UUID) {
                for (Achievement achievement : achievements) {
                    if (achievement.getAchievementID().equals(uuid)) {
                        achievements.remove(achievement);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while removing achievement: " + e.getMessage());
        }
    }

    public void removeAchievement(String uuid) {
        try {
            if (uuid != null) {
                for (Achievement achievement : achievements) {
                    if (achievement.getAchievementID().equals(UUID.fromString(uuid))) {
                        achievements.remove(achievement);
                    }
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error while removing achievement: " + e.getMessage());
        }
    }

    public Achievement getAchievement(UUID uuid) {
        try {
            if (uuid != null && uuid instanceof UUID) {
                for (Achievement achievement : achievements) {
                    if (achievement.getAchievementID().equals(uuid)) {
                        return achievement;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error while getting achievement: " + e.getMessage());
        }
        return null;
    }

    public Achievement getAchievement(String uuid) {
        try {
            if (uuid != null) {
                for (Achievement achievement : achievements) {
                    if (achievement.getAchievementID().equals(UUID.fromString(uuid))) {
                        return achievement;
                    }
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Error while getting achievement: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    public void clear() {
        try {
            if (!achievements.isEmpty()) {
                achievements.clear();
            }
        } catch (Exception e) {
            System.err.println("Error while clearing achievements: " + e.getMessage());
        }
    }
}
