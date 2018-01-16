package org.exoplatform.gamification.prototype.jongo.DTO;

import java.util.Date;
import java.util.List;

public class Module {
    String module_name;
    int module_score;
    List<Badge> badges;

    public Module() {
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public int getModule_score() {
        return module_score;
    }

    public void setModule_score(int module_score) {
        this.module_score = module_score;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }
}
