package org.exoplatform.gamification.prototype.jongo.DTO;

import java.util.Date;
import java.util.List;

public class GamificationEntry {
    String username;
    int score;
    Date lastUpdate;

    List<Module> modules;

    public GamificationEntry() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
